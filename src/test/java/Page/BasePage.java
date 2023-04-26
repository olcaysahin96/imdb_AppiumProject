package Page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class BasePage {

    AppiumDriver driver;

    public BasePage(AppiumDriver appiumDriver){
        this.driver =appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public void waitGenericMethod(MobileElement element) {
        FluentWait<AppiumDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(ofSeconds(15))
                        .pollingEvery(ofSeconds(1))
                        .ignoring(NoSuchElementException.class)
                        .withMessage("element not found");

        wait.until(ExpectedConditions.visibilityOf(element));
        Assertions.assertTrue(element.isDisplayed());
    }
    public void scrollDown(int repeat) {
        for(int i=1; i<=repeat; i++) {
            int pressX = driver.manage().window().getSize().width / 2;
            int bottomY = driver.manage().window().getSize().height * 4 / 5;
            int topY = driver.manage().window().getSize().height / 8;
            scroll(pressX, bottomY, pressX, topY);
        }
    }
    private void scroll(int fromX, int fromY, int toX, int toY) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(point(fromX, fromY)).moveTo(point(toX, toY)).release().perform();
    }
    public void swipeLeft(MobileElement element,int repeat){
        for(int i=1; i<=repeat; i++) {
            Dimension size = element.getSize();
            ElementOption press = element(element, size.width / 2 + 2, size.height / 2);
            ElementOption move = element(element, 1, size.height / 2);
            TouchAction swipe = new TouchAction(driver).press(press)
                    .waitAction(waitOptions(ofSeconds(2)))
                    .moveTo(move).release();
            swipe.perform().release();
        }
    }
}
