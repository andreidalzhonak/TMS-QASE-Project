package utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseWebWithThreadLocalTest;

public class TestListeners implements ITestListener {
    private static final Logger LOGGER = LogManager.getLogger(TestListeners.class.getName());

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info("Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Object currentClass = iTestResult.getInstance();
        WebDriver driver = ((BaseWebWithThreadLocalTest) currentClass).getDriver();
        ((BaseWebWithThreadLocalTest) currentClass).getBrowser();
        AllureService allureService = new AllureService();
        allureService.getSystemName();
        allureService.takeScreenshot(driver);
        LOGGER.info("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object currentClass = iTestResult.getInstance();
        WebDriver driver = ((BaseWebWithThreadLocalTest) currentClass).getDriver();
        AllureService allureService = new AllureService();
        ((BaseWebWithThreadLocalTest) currentClass).getBrowser();
        allureService.getSystemName();
        allureService.takeScreenshot(driver);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}