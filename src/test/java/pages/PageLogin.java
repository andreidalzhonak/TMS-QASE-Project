package pages;

import constants.Urls;
import io.qameta.allure.Step;
import models.CredentialsModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testdata.PrepareLoginFailedData;

public class PageLogin extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(PageLogin.class.getName());
    @FindBy(id = "inputEmail")
    private WebElement emailField;
    @FindBy(id = "inputPassword")
    private WebElement passwordField;
    @FindBy(id = "btnLogin")
    private WebElement loginButton;
    @FindBy(xpath = "//div[contains(@class, 'has-error')]//div")
    private WebElement notificationErrorEmail;

    public PageLogin(WebDriver driver) {
        super(driver);
    }

    @Step("Check notification text")
    public String takeNotificationError() {
        LOGGER.debug(String.format("Check notification: %s", notificationErrorEmail.getText()));
        String notification = notificationErrorEmail.getText();
        return notification;
    }

    @Step("Open account Url")
    public void openAccountsPage() {
        driver.get(Urls.APP_QASE_LOGIN);
    }

    @Step("Input Username and Password")
    public void loginToQase(CredentialsModel admin) {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.APP_QASE_LOGIN));
        openAccountsPage();
        LOGGER.debug(String.format("Input username"));
        emailField.sendKeys(admin.getEmail());
        LOGGER.debug(String.format("Input password"));
        passwordField.sendKeys(admin.getPassword());
        LOGGER.info("Click Log In");
        loginButton.click();
    }

    @Step("Input Failed Username and Failed Password")
    public void loginFailedToQase() {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.APP_QASE_LOGIN));
        openAccountsPage();
        LOGGER.debug(String.format("Input username %s", PrepareLoginFailedData.getValidData().getEmail()));
        emailField.sendKeys(PrepareLoginFailedData.getValidData().getEmail());
        LOGGER.debug(String.format("Input password %s", PrepareLoginFailedData.getValidData().getPassword()));
        passwordField.sendKeys(PrepareLoginFailedData.getValidData().getPassword());
        LOGGER.info("Click Log In");
        loginButton.click();
    }
}