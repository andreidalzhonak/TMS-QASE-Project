package drivermanager.threadlocalmanager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;



public class FirefoxDriverThreadLocalManager extends DriverThreadLocalManager {

    @Override
    public void createDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        threadLocalDriver.set(new FirefoxDriver(options));
    }
}
