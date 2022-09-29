package tests;

import io.qameta.allure.*;
import models.StartTestRunsDataModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import testdata.PrepareNewTestRunData;
import utils.RetryAnalyzer;

@Epic("User Managment")
@Feature("Test Run")
@Story("Start and Delete Test Run")
public class TestRunTest extends BaseWebTest {

    private static final Logger LOGGER = LogManager.getLogger(NewTestSuiteTest.class.getName());

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Description("Start Test Run")
    @Severity(SeverityLevel.BLOCKER)

    public void startTestRunTest() {
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
        LOGGER.info("Click Test Run Button");
        currentProjectPage.clickTestRunsButton();
        LOGGER.info(String.format("Data %s is prepared ", PrepareNewTestRunData.class.getName()));
        StartTestRunsDataModel testRunsDataModel = PrepareNewTestRunData.getTestRunData();
        LOGGER.info(String.format("Page %s initialized", TestRunsPage.class.getName()));
        TestRunsPage testRunsPage = new TestRunsPage(driverManager.getDriver());
        LOGGER.info("Input test data");
        testRunsPage.inputFormForStartTestRun(testRunsDataModel);
        LOGGER.info("Check notification start test run ");
        Assert.assertEquals(testRunsPage.getTestRunMessage(), "Run was created successfully!");
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    @Description("Delete Test Run")
    @Severity(SeverityLevel.BLOCKER)

    public void deleteTestRunTest() {
        //LOGGER.info("Launch Start Test Run test");
        //startTestRunTest();

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
        CurrentProjectPage currentProjectPage = new CurrentProjectPage(driverManager.getDriver());
        LOGGER.info("Click Test Run Button");
        currentProjectPage.clickTestRunsButton();
        LOGGER.info(String.format("Page %s initialized", TestRunsPage.class.getName()));
        TestRunsPage testRunsPage = new TestRunsPage(driverManager.getDriver());
        LOGGER.info("Delete Test Run");
        testRunsPage.deleteTestRun();
        LOGGER.info("Check name start new test run button");
        Assert.assertEquals(testRunsPage.getNameButton(), "Start new test run");
    }

}