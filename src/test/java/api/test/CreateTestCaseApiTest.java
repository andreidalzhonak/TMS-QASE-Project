package api.test;

import api.constants.UrlsApi;
import api.models.TestCaseModel;
import api.testdata.PrepareDataApi;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.CredentialsModel;
import org.testng.annotations.Test;
import tests.BaseCredentialsTest;
import utils.RetryAnalyzer;

@Epic("User Managment")
@Feature("Test Case")
@Story("Create Test Case")

public class CreateTestCaseApiTest extends BaseCredentialsTest {
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Description("Create Test Case API")
    @Severity(SeverityLevel.BLOCKER)
    public void createTestCaseTest() {
        TestCaseModel model = PrepareDataApi.getValidDataForTestCase();
        RestAssured
                .given()
                .header("Token", admin.getToken())
                .contentType(ContentType.JSON)
                .and()
                .when()
                .body(model)
                .log().body()
                .when()
                .post(UrlsApi.BASE_URL.concat(UrlsApi.CREATE_TEST_CASE_URL))
                .then()
                .statusCode(200)
                .log().body()
                .log().status();
    }
}