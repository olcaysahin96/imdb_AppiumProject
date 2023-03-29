package Page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    AppiumDriver driver;

    public BasePage(AppiumDriver appiumDriver){
        this.driver =appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
