package api.test;

import api.constants.UrlsApi;
import constants.Credentials;
import api.models.MilestoneModel;
import api.testdata.PrepareDataApi;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import tests.BaseApiTest;
import utils.RetryAnalyzer;


@Epic("User Managment")
@Feature("Milestone")
@Story("Create Milestone")
public class CreateMilestoneApiTest extends BaseApiTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Description("Create Milestone API")
    @Severity(SeverityLevel.BLOCKER)

    public void createMilestoneTest() {
        MilestoneModel milestone = PrepareDataApi.getValidDataForMilestoun();
        RestAssured
                .given()
                .header("Token", Credentials.TOKEN)
                .contentType(ContentType.JSON)
                .and()
                .when()
                .body(milestone)
                .log().body()
                .when()
                .post(UrlsApi.BASE_URL.concat(UrlsApi.CREATE_MILESTONE_URL))
                .then()
                .statusCode(200)
                .log().body()
                .log().status();
    }
}