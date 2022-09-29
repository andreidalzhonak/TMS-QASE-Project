package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testdata.PrepareCreateSuiteData;

public class CreateSuitePage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(CreateSuitePage.class.getName());

    @FindBy(id = "name")
    private WebElement suiteNameField;

    @FindBy(xpath = "//div[contains(@id, 'descriptionGroup')]//p")
    private WebElement descriptionSuiteField;

    @FindBy(xpath = "//div[contains(@id, 'preconditionsGroup')]//p")
    private WebElement preconditionsSuiteField;

    @FindBy(id = "save-suite-button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@id='layout']/div[3]//span//span")
    private WebElement saveMessage;


    public CreateSuitePage(WebDriver driver) {
        super(driver);
    }

    @Step("Input Data for create Test Suite ")
    public void inputTestSuiteData() {
        LOGGER.debug(String.format("Input data in : %s", suiteNameField.getText()));
        suiteNameField.sendKeys(PrepareCreateSuiteData.getCreateSuiteData().getSuiteName());
        LOGGER.debug(String.format("Input data in : %s", descriptionSuiteField.getText()));
        suiteNameField.sendKeys(PrepareCreateSuiteData.getCreateSuiteData().getDescription());
        LOGGER.debug(String.format("Input data in : %s", preconditionsSuiteField.getText()));
        suiteNameField.sendKeys(PrepareCreateSuiteData.getCreateSuiteData().getPreconditions());
        saveButton.click();
    }

    @Step("Take successful message notification ")
    public String getSuiteMessage() {
        LOGGER.debug(String.format("Take message : %s", saveMessage.getText()));
        String message = saveMessage.getText();
        return message;
    }
}