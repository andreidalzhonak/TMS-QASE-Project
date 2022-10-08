package elements;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class DropDownListTestCase {
    private static final String LIST_XPATH = "//label[text()='%s']//parent::div//button";
    private static final String LIST_XPATH_MILESTONE = "//label[text()='%s']//../div[1]";
    private static final String OPTION_XPATH = "//div[contains(@id, 'modals')]/./child::div/./*/div/div[contains(., '%s')]";
    private static final String OPTION_XPATH_SUITE = "//input[contains(@id, 'suite')]/../child::div/./*//div/div";
    private static final String OPTION_XPATH_MILESTONE = "//div[contains(@class, 'css-1e225yz-menu')]//div[contains(., '%s')]";
    private String labelText;
    private WebDriver driver;

    public DropDownListTestCase(WebDriver driver, String labelText) {
        this.driver = driver;
        this.labelText = labelText;
    }

    public void selectOptionInList(String option) {
        String listFinalXpath = String.format(LIST_XPATH, labelText);
        driver.findElement(By.xpath(listFinalXpath)).click();
        String optionFinalXpath = String.format(OPTION_XPATH, option);
        driver.findElement(By.xpath(optionFinalXpath)).click();
    }

    public void selectOptionInListForSuite(String option) {
        String listFinalXpath = String.format(LIST_XPATH, labelText);
        driver.findElement(By.xpath(listFinalXpath)).click();
        String optionFinalXpathSuite = String.format(OPTION_XPATH_SUITE, option);
        driver.findElement(By.xpath(optionFinalXpathSuite)).click();
    }

    public void selectOptionInListForMilestone(String option) {
        String listFinalXpath = String.format(LIST_XPATH_MILESTONE, labelText);
        String optionFinalXpathMilestone = String.format(OPTION_XPATH_MILESTONE, option);
        WebElement element = driver.findElement(By.xpath(listFinalXpath));
        Actions actions = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        actions.moveToElement(element).click().perform();
        WebElement element1 = (driver.findElement(By.xpath(optionFinalXpathMilestone)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element1);
        actions.moveToElement(element1).click().perform();
    }


}