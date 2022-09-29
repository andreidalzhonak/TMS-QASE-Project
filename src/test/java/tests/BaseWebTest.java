package tests;

import driverManager.DriverFactory;
import driverManager.DriverManager;
import driverManager.DriverType;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import utils.TestListeners;

@Listeners(TestListeners.class)
public class BaseWebTest extends CommonBaseTest {

    public WebDriver driver;
    public DriverManager driverManager;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        DriverFactory driverFactory = new DriverFactory();
        DriverType type = null;
        if (browser.equals("chrome")) {
            type = DriverType.CHROME;
        } else if (browser.equals("firefox")) {
            type = DriverType.FIREFOX;
        }
        driverManager = driverFactory.getManager(type);
        driverManager.createDriver();
        driverManager.startMaximize();
        driverManager.setTimeout();
        driver = driverManager.getDriver();

    }

    public String getBrowser() {

        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        String v = cap.getVersion();
        return browserName + " " + v;
    }

    public WebDriver getDriver() {
        return driver;
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }
}