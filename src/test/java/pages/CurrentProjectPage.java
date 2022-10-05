package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CurrentProjectPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(ProjectsPage.class.getName());
    @FindBy(id = "create-suite-button")
    private WebElement createSuiteButton;
    @FindBy(id = "create-case-button")
    private WebElement createCaseButton;
    @FindBy(xpath = "//div[contains(@id, 'layout')]//a[contains(@title, 'Test Runs')]")
    private WebElement testRunsButton;
    public CurrentProjectPage(WebDriver driver) {
        super(driver);
    }
    @Step("Check what Suite Button is Displayed")
    public boolean createSuiteButtonIsDisplayed() {
        LOGGER.debug(String.format("Check button: %s", createSuiteButton.getText()));
        boolean suiteButton = createSuiteButton.isDisplayed();
        return suiteButton;
    }
    @Step("Click Create  Suite Button")
    public void clickSuiteButton() {
        LOGGER.debug(String.format("Click Suite button: %s", createSuiteButton.getText()));
        createSuiteButton.click();
    }
    @Step("Click Create  Test Case Button")
    public void clickTestCaseButton() {
        LOGGER.debug(String.format("Click Test Case button: %s", createCaseButton.getText()));
        createCaseButton.click();
    }
    @Step("Click Test Runs Button")
    public void clickTestRunsButton() {
        LOGGER.debug(String.format("Click Suite button: %s", testRunsButton.getText()));
        testRunsButton.click();
    }
}