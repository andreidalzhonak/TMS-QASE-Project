package pages;

import elements.DropDownListTestRuns;
import io.qameta.allure.Step;
import models.StartTestRunsDataModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestRunsPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(ProjectsPage.class.getName());

    public TestRunsPage(WebDriver driver) {
        super(driver);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(id = "start-new-test-run-button")
    private WebElement startNewTestRunButton;

    @FindBy(id = "edit-run-add-cases-button")
    private WebElement addCasesButton;

    @FindBy(id = "select-cases-done-button")
    private WebElement doneButton;

    @FindBy(id = "save-run-button")
    private WebElement startRunButton;

    @FindBy(xpath = " //*[@id=\"layout\"]/div[3]/div/span")
    private WebElement successfulNotificationStartTestRun;

    @FindBy(xpath = "//div[contains(@class, 'dropdown')]//a[contains(@class, 'btn')]")
    private WebElement dropDownButton;

    @FindBy(xpath = "//div[contains(@class, 'dropdown-menu')]//div/a[text() = 'Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//form[contains(@class, 'form-delete-milestone')]//button")
    private WebElement deleteRun;


    @FindBy(xpath = "//div[@class='no-entities-content']//a")
    private WebElement startTestRunButton;

    @Step("Click Drop Down button")
    public void clickDropDownButton() {
        LOGGER.debug(String.format("Click Drop Down button: %s", dropDownButton.getText()));
        dropDownButton.click();
    }

    @Step("Check start new test run button")
    public String getNameButton() {
        LOGGER.debug(String.format("Check start new test run button: %s", startTestRunButton.getText()));
        String messageNameButton = startTestRunButton.getText();
        return messageNameButton;
    }


    @Step("Click Delete button")
    public void clickDeleteButton() {
        LOGGER.debug(String.format("Click Delete button: %s", deleteButton.getText()));
        deleteButton.click();
    }

    @Step("Click Delete Run button")
    public void clickDeleteRunButton() {
        LOGGER.debug(String.format("Click Drop Down button: %s", deleteRun.getText()));
        deleteRun.click();
    }


    @Step("Take successful message notification start test run ")
    public String getTestRunMessage() {
        LOGGER.debug(String.format("Take message : %s", successfulNotificationStartTestRun.getText()));
        String message = successfulNotificationStartTestRun.getText();
        return message;
    }

    @Step("Click Add cases button")
    public void clickAddCasesButton() {
        js.executeScript("arguments[0].scrollIntoView();", addCasesButton);
        LOGGER.debug(String.format("Click Add cases button: %s", addCasesButton.getText()));
        addCasesButton.click();
    }

    @Step("Click Done button")
    public void clickDoneButton() {
        LOGGER.debug(String.format("Click done button: %s", doneButton.getText()));
        doneButton.click();
    }

    @Step("Click Start Run button")
    public void clickStartRunButton() {
        LOGGER.debug(String.format("Click done button: %s", startRunButton.getText()));
        startRunButton.click();
    }

    @Step("Click Start new test run button")
    public void clickStartNewTestRun() {
        LOGGER.debug(String.format("Click button: %s", startNewTestRunButton));
        startNewTestRunButton.click();
    }

    @Step("Input Data in Test run")
    public void inputFormForStartTestRun(StartTestRunsDataModel testRun) {
        LOGGER.debug(String.format("Click button: %s", startNewTestRunButton));
        clickStartNewTestRun();
        LOGGER.debug(String.format("InputMilestone: %s", testRun.getMilestone()));
        new DropDownListTestRuns(driver, "Milestone").selectOptionInListTestRun(testRun.getMilestone());
        LOGGER.debug(String.format("Input  Default assignee: %s", testRun.getDefaultAssignee()));
        new DropDownListTestRuns(driver, "Default assignee").selectOptionInListTestRun(testRun.getDefaultAssignee());
        LOGGER.info("Click Add case button");
        clickAddCasesButton();
        LOGGER.debug(String.format("Input Status: %s", testRun.getSuite()));
        new DropDownListTestRuns(driver).selectOptionInListTestSuite(testRun.getSuite());
        LOGGER.info("Click Done button");
        clickDoneButton();
        LOGGER.info("Click Start run button");
        clickStartRunButton();
    }

    @Step("Delete Test Run")
    public void deleteTestRun() {
        LOGGER.info("Click Drop Down button");
        clickDropDownButton();
        LOGGER.info("Click Delete button");
        clickDeleteButton();
        LOGGER.info("Click Delete Run button");
        clickDeleteRunButton();
    }
}
