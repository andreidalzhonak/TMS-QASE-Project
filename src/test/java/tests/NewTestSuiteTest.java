package tests;

import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.RetryAnalyzer;

@Epic("User Managment")
@Feature("Test Suite")
@Story("Create Test Suite")
public class NewTestSuiteTest extends BaseWebTest {

    private static final Logger LOGGER = LogManager.getLogger(NewTestSuiteTest.class.getName());

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Description("Create Test Suite")
    @Severity(SeverityLevel.BLOCKER)

    public void createNewTestSuiteTest() {
        LOGGER.info(String.format("Page %s initialized", PageLogin.class.getName()));
        PageLogin pageLogin = new PageLogin(driverManager.getDriver());
        LOGGER.info(String.format("Open page" + PageLogin.class.getName()));
        LOGGER.info("Input username and Password");
        LOGGER.info("Click Button");
        pageLogin.loginToQase();
        LOGGER.info(String.format("Page %s initialized", ProjectsPage.class.getName()));
        ProjectsPage projectsPage = new ProjectsPage(driverManager.getDriver());
        LOGGER.info("Click Project");
        projectsPage.clickProject();
        LOGGER.info(String.format("Page %s initialized", CurrentProjectPage.class.getName()));
        CurrentProjectPage currentProjectPage = new CurrentProjectPage(driverManager.getDriver());
        LOGGER.info("Click Suite Button");
        currentProjectPage.clickSuiteButton();
        LOGGER.info(String.format("Page %s initialized", CreateSuitePage.class.getName()));
        CreateSuitePage createSuitePage = new CreateSuitePage(driverManager.getDriver());
        LOGGER.info("Input Data for create New Test Suite");
        createSuitePage.inputTestSuiteData();
        LOGGER.info("Check notification create Suite ");
        Assert.assertEquals(createSuitePage.getSuiteMessage(), "Suite was successfully created.");
    }
}