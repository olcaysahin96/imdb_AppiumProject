package Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {
    protected AppiumDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", "s21");
        caps.setCapability("udid", "R5CNC0ZS30F");
        caps.setCapability("app", "Users/olcay.sahin/imdb.apk");
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("newCommandTimeout", "600");
        this.driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
    }

    @AfterEach
    public void tearDown() {
        if (null != this.driver) {
            this.driver.quit();
        }

    }
}
