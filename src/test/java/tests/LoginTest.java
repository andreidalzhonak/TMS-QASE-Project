package tests;

import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageLogin;
import pages.ProjectsPage;
import utils.RetryAnalyzer;

@Epic("User Managment")
@Feature("Login")
@Story("Input Credentials")
public class LoginTest extends BaseWebWithThreadLocalTest {
    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Description("Login in Qase account")
    @Severity(SeverityLevel.BLOCKER)
    public void inputCredentialsTest() {
        LOGGER.info(String.format("Page %s initialized", PageLogin.class.getName()));
        PageLogin pageLogin = new PageLogin(driverManager.getDriver());
        pageLogin.loginToQase(admin);
        LOGGER.info(String.format("Open page" + PageLogin.class.getName()));
        LOGGER.info("Input username and Password");
        LOGGER.info("Click Button");
        LOGGER.info(String.format("Page %s initialized", ProjectsPage.class.getName()));
        ProjectsPage projectsPage = new ProjectsPage(driverManager.getDriver());
        LOGGER.info("Check what create button is Displayed");
        Assert.assertTrue(projectsPage.createButtonIsDisplayed(), "Button isn't displayed");
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Description("Login failed in Qase account")
    @Severity(SeverityLevel.BLOCKER)
    public void inputFailedCredentialsTest() {
        LOGGER.info(String.format("Page %s initialized", PageLogin.class.getName()));
        PageLogin pageLogin = new PageLogin(getDriver());
        LOGGER.info(String.format("Open page" + PageLogin.class.getName()));
        LOGGER.info("Input username and Password");
        LOGGER.info("Click Button");
        pageLogin.loginFailedToQase();
        LOGGER.info("Check what notification is Displayed");
        Assert.assertEquals(pageLogin.takeNotificationError(), "These credentials do not match our records.");
    }
}