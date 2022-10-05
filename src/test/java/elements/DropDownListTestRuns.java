package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class DropDownListTestRuns {
    private static final String LIST_XPATH = "//div[@class='row']//label[text() = '%s']//parent::div/div/div/div[1]";
    private static final String OPTION_XPATH = "//div[@id='layout']/div[6]//div//div//div";
    private static final String LIST_XPATH_SUITES = "//div[contains(@class, 'suites-column')]/div//p[text() ='%s']";
    private static final String OPTION_XPATH_SUITES = "//div[contains(@class, 'suites-column')]/div//p[text() ='%s']//parent::div//span";
    private String labelText;
    private WebDriver driver;
    public DropDownListTestRuns(WebDriver driver, String labelText) {
        this.driver = driver;
        this.labelText = labelText;
    }

    public DropDownListTestRuns(WebDriver driver) {
        this.driver = driver;
    }

    public void selectOptionInListTestRun(String option) {
        String listFinalXpath = String.format(LIST_XPATH, labelText);
        driver.findElement(By.xpath(listFinalXpath)).click();
        String optionFinalXpath = String.format(OPTION_XPATH, option);
        driver.findElement(By.xpath(optionFinalXpath)).click();
    }

    public void selectOptionInListTestSuite(String option) {
        String listFinalXpath = String.format(LIST_XPATH_SUITES, option);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(listFinalXpath)));
        String optionFinalXpath = String.format(OPTION_XPATH_SUITES, option);
        driver.findElement(By.xpath(optionFinalXpath)).click();
    }
}