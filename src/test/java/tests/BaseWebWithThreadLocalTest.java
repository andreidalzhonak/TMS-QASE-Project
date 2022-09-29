package tests;

import driverManager.DriverType;
import driverManager.threadlocalmanager.DriverThreadLocalManager;
import driverManager.threadlocalmanager.DriverThreadLocalManagerFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import utils.TestListeners;

@Listeners(TestListeners.class)
public class BaseWebWithThreadLocalTest extends CommonBaseTest {

    DriverThreadLocalManager driverManager;

    @BeforeMethod
    public void createManager() {
        DriverThreadLocalManagerFactory factory = new DriverThreadLocalManagerFactory();
        driverManager = factory.getManager(DriverType.CHROME);
    }

    @BeforeMethod
    public void setUp() {
        driverManager.createDriver();
        driverManager.startMaximize();
        driverManager.setTimeout();
    }

    public WebDriver getDriver() {
        return driverManager.getDriver();
    }

    @Attachment
    public String getBrowser() {

        Capabilities cap = ((RemoteWebDriver) driverManager.getDriver()).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        String v = cap.getVersion();
        return browserName + " " + v;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverManager.getDriver().quit();
    }


}