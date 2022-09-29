package pages;

import elements.DropDownListTestCase;
import io.qameta.allure.Step;
import models.CreateTestCaseDataModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testdata.PrepareCreateTestCaseData;
import utils.FakeMessageGenerator;


public class CreateTestCasePage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(CreateTestCasePage.class.getName());
    JavascriptExecutor js = (JavascriptExecutor) driver;
    @FindBy(id = "title")
    private WebElement titleField;

    @FindBy(id = "0-description")
    private WebElement descriptionField;

    @FindBy(id = "0-preconditions")
    private WebElement preconditionsField;

    @FindBy(id = "0-postconditions")
    private WebElement postconditionsField;

    @FindBy(xpath = "//div[contains(@class, 'steps-add')]//a[contains(@id, 'add-step')]")
    private WebElement addStepButton;

    @FindBy(id = "action[0]")
    private WebElement actionField;

    @FindBy(id = "data[0]")
    private WebElement inputDataField;

    @FindBy(id = "expected_result[0]")
    private WebElement expectedResultField;

    @FindBy(xpath = "//div[contains(@class, 'save-menu-wrapper')]//button[contains(@id, 'save-case')]")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class, 'select-block')]//button[contains(@type, 'button')]")
    private WebElement testCaseSteps;

    @FindBy(xpath = "//div[contains(@class, 'select-block')]/div/div//div//div/div[contains(., 'Classic')]")
    private WebElement optionTestCaseSteps;

    @FindBy(xpath = " //*[@id=\"layout\"]/div[3]/div/span")
    private WebElement successfulNotificationCreateTestCase;


    public CreateTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Take successful message notification create Test Case ")
    public String getTestCaseMessage() {
        LOGGER.debug(String.format("Take message : %s", successfulNotificationCreateTestCase.getText()));
        String message = successfulNotificationCreateTestCase.getText();
        return message;
    }

    @Step("Choose option in Test Case Steps")
    public void selectOptionInListTestCaseSteps() {
        js.executeScript("arguments[0].scrollIntoView();", testCaseSteps);
        LOGGER.debug(String.format("Click Test Case Steps Button: %s", testCaseSteps.getText()));
        testCaseSteps.click();
        LOGGER.debug(String.format("Click option: %s", optionTestCaseSteps.getText()));
        optionTestCaseSteps.click();
    }

    @Step("Click 'Add step' Button")
    public void clickAddStepButton() {
        js.executeScript("arguments[0].scrollIntoView();", addStepButton);
        LOGGER.debug(String.format("Click Add Step Button: %s", addStepButton.getText()));
        addStepButton.click();
    }

    @Step("Click Save Button")
    public void clickSaveButton() {
        LOGGER.debug(String.format("Click Save Button: %s", saveButton.getText()));
        saveButton.click();
    }

    @Step("Input Data in New test case from")
    public void testCaseForm(CreateTestCaseDataModel testCase) throws InterruptedException {
        LOGGER.debug(String.format("Input Title field: %s", PrepareCreateTestCaseData.getCreateTestCaseData().getTitle()));
        titleField.sendKeys(PrepareCreateTestCaseData.getCreateTestCaseData().getTitle());
        LOGGER.debug(String.format("Input Status: %s", testCase.getStatus()));
        new DropDownListTestCase(driver, "Status").selectOptionInList(testCase.getStatus());
        LOGGER.debug(String.format("Input Description field: %s", FakeMessageGenerator.generateDescriptionTestCase()));
        descriptionField.sendKeys(FakeMessageGenerator.generateDescriptionTestCase());
        LOGGER.debug(String.format("Input Suite: %s", testCase.getSuite()));
        new DropDownListTestCase(driver, "Suite").selectOptionInListForSuite(testCase.getSuite());
        LOGGER.debug(String.format("Input Severity: %s", testCase.getSeverity()));
        new DropDownListTestCase(driver, "Severity").selectOptionInList(testCase.getSeverity());
        LOGGER.debug(String.format("Input Priority: %s", testCase.getPriority()));
        new DropDownListTestCase(driver, "Priority").selectOptionInList(testCase.getPriority());
        LOGGER.debug(String.format("Input Type: %s", testCase.getType()));
        new DropDownListTestCase(driver, "Type").selectOptionInList(testCase.getType());
        LOGGER.debug(String.format("Input Layer: %s", testCase.getLayer()));
        new DropDownListTestCase(driver, "Layer").selectOptionInList(testCase.getLayer());
        LOGGER.debug(String.format("Input Is flaky: %s", testCase.getIsFlaky()));
        new DropDownListTestCase(driver, "Is flaky").selectOptionInList(testCase.getIsFlaky());
        LOGGER.debug(String.format("Input Milestone: %s", testCase.getMilestone()));
        new DropDownListTestCase(driver, "Milestone").selectOptionInListForMilestone(testCase.getMilestone());
        LOGGER.debug(String.format("Input Behavior: %s", testCase.getBehavior()));
        new DropDownListTestCase(driver, "Behavior").selectOptionInList(testCase.getBehavior());
        LOGGER.debug(String.format("Input Automation status: %s", testCase.getAutomationStatus()));
        new DropDownListTestCase(driver, "Automation status").selectOptionInList(testCase.getAutomationStatus());
        LOGGER.debug(String.format("Input Pre-conditions field: %s", FakeMessageGenerator.generatePreConditionsTestCase()));
        js.executeScript("arguments[0].scrollIntoView();", preconditionsField);
        preconditionsField.sendKeys(FakeMessageGenerator.generatePreConditionsTestCase());
        LOGGER.debug(String.format("Input Post-conditions field: %s", FakeMessageGenerator.generatePostConditionsTestCase()));
        js.executeScript("arguments[0].scrollIntoView();", postconditionsField);
        postconditionsField.sendKeys(FakeMessageGenerator.generatePostConditionsTestCase());
        LOGGER.info("Choose option 'Classic'");
        selectOptionInListTestCaseSteps();
        LOGGER.info("Click Add step button");
        clickAddStepButton();
        LOGGER.debug(String.format("Input action field: %s", FakeMessageGenerator.generateActionTestCase()));
        actionField.sendKeys(FakeMessageGenerator.generateActionTestCase());
        LOGGER.debug(String.format("Input  'Input Data' field: %s", FakeMessageGenerator.generateInputDataTestCase()));
        inputDataField.sendKeys(FakeMessageGenerator.generateInputDataTestCase());
        LOGGER.debug(String.format("Input  Expected Result field: %s", FakeMessageGenerator.generateExpectedResultTestCase()));
        expectedResultField.sendKeys(FakeMessageGenerator.generateExpectedResultTestCase());
        LOGGER.info("Click Save button");
        clickSaveButton();

    }
}