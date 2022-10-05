package api.test;

import api.constants.UrlsApi;
import api.models.TestSuiteModel;
import api.testdata.PrepareDataApi;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.LoginModel;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

@Epic("User Managment")
@Feature("Test Suite")
@Story("Create Test Suite")

public class CreateTestSuiteApiTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Description("Create Test suite API")
    @Severity(SeverityLevel.BLOCKER)
    public void createTestSuiteTest() {
        TestSuiteModel testsuite = PrepareDataApi.getValidDataForTestSuite();
        RestAssured
                .given()
                .header("Token", LoginModel.TOKEN)
                .contentType(ContentType.JSON)
                .and()
                .when()
                .body(testsuite)
                .log().body()
                .when()
                .post(UrlsApi.BASE_URL.concat(UrlsApi.CREATE_TEST_SUITE_URL))
                .then()
                .statusCode(200)
                .log().body()
                .log().status();
    }
}