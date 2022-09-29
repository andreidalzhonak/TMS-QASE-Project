package api.test;


import api.constants.UrlsApi;
import constants.Credentials;
import api.models.TestCaseModel;
import api.testdata.PrepareDataApi;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import tests.BaseApiTest;
import utils.RetryAnalyzer;


@Epic("User Managment")
@Feature("Test Case")
@Story("Create Test Case")

public class CreateTestCaseApiTest extends BaseApiTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Description("Create Test Case API")
    @Severity(SeverityLevel.BLOCKER)

    public void createTestCaseTest() {
        TestCaseModel model = PrepareDataApi.getValidDataForTestCase();

        RestAssured
                .given()
                .header("Token", Credentials.TOKEN)
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