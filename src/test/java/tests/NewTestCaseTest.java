package tests;

import io.qameta.allure.*;
import models.CreateTestCaseDataModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import testdata.PrepareCreateTestCaseData;
import utils.RetryAnalyzer;


@Epic("User Managment")
@Feature("Test Case")
@Story("Create Test Case")


public class NewTestCaseTest extends BaseWebTest {
    private static final Logger LOGGER = LogManager.getLogger(NewTestCaseTest.class.getName());

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Description("Create Test Case")
    @Severity(SeverityLevel.BLOCKER)

    public void createNewTestCaseTest() throws InterruptedException {
        LOGGER.info(String.format("Page %s initialized", PageLogin.class.getName()));
        PageLogin pageLogin = new PageLogin(driverManager.getDriver());
        LOGGER.info(String.format("Open page" + PageLogin.class.getName()));
        LOGGER.info("Input username and Password");
        LOGGER.info("Click Button");
        pageLogin.loginToQase();
        LOGGER.info(String.format("Page %s initialized", ProjectsPage.class.getName()));
        ProjectsPage projectsPage = new ProjectsPage(driverManager.getDriver());
        LOGGER.info("Click Project");
        projectsPage.clickProjectSharelane();
        LOGGER.info(String.format("Page %s initialized", CurrentProjectPage.class.getName()));
        CurrentProjectPage currentProjectPage = new CurrentProjectPage(driverManager.getDriver());
        LOGGER.info("Click Case Button");
        currentProjectPage.clickTestCaseButton();
        CreateTestCaseDataModel testCaseDataModel = PrepareCreateTestCaseData.getCreateTestCaseData();
        LOGGER.info(String.format("Page %s initialized", CreateTestCasePage.class.getName()));
        CreateTestCasePage createTestCasePage = new CreateTestCasePage(driverManager.getDriver());
        LOGGER.info("Input Data for create New Test Case");
        createTestCasePage.testCaseForm(testCaseDataModel);
        LOGGER.info("Check notification create Test Case ");
        Assert.assertEquals(createTestCasePage.getTestCaseMessage(), "Test case was created successfully!");
    }
}