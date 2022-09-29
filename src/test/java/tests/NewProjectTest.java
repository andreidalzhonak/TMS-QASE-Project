package tests;

import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateNewProjectPage;
import pages.CurrentProjectPage;
import pages.PageLogin;
import pages.ProjectsPage;
import utils.RetryAnalyzer;

@Epic("User Managment")
@Feature("Login")
@Story("Input Credentials")

public class NewProjectTest extends BaseWebTest {
    private static final Logger LOGGER = LogManager.getLogger(NewProjectTest.class.getName());

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Description("Login in Qase account")
    @Severity(SeverityLevel.BLOCKER)

    public void createNewProjectTest() throws InterruptedException {
        LOGGER.info(String.format("Page %s initialized", PageLogin.class.getName()));
        PageLogin pageLogin = new PageLogin(driverManager.getDriver());
        LOGGER.info(String.format("Open page" + PageLogin.class.getName()));
        LOGGER.info("Input username and Password");
        LOGGER.info("Click Button");
        pageLogin.loginToQase();
        LOGGER.info(String.format("Page %s initialized", ProjectsPage.class.getName()));
        ProjectsPage projectsPage = new ProjectsPage(driverManager.getDriver());
        LOGGER.info("Click Create Button");
        projectsPage.clickCreateButton();
        LOGGER.info(String.format("Page %s initialized", CreateNewProjectPage.class.getName()));
        CreateNewProjectPage newProjectPage = new CreateNewProjectPage(driverManager.getDriver());
        LOGGER.info("Input Data for create New Project");
        newProjectPage.createNewProject();
        LOGGER.info(String.format("Page %s initialized", CurrentProjectPage.class.getName()));
        CurrentProjectPage currentProjectPage = new CurrentProjectPage(driverManager.getDriver());
        LOGGER.info("Check create Suite button is Displayed");
        Assert.assertTrue(currentProjectPage.createSuiteButtonIsDisplayed(), "Button isn't displayed");
    }
}