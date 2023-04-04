package Page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class SearchPage extends BasePage{
    public SearchPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy (id = "navigation_search_browse")
    private MobileElement navigation_search_browse;
    @AndroidFindBy (id = "search_src_text")
    private MobileElement search_src_text;
    @AndroidFindBy (xpath = "//*[@text='Hobbit: Beş Ordunun Savaşı']")
    private MobileElement hobbit2014film;
    @AndroidFindBy (id = "title")
    private MobileElement title;

    public void clickNavigationSearch(){
        waitGenericMethod(navigation_search_browse);
        navigation_search_browse.click();
    }

    public void sendKeysHobbit(){
        waitGenericMethod(search_src_text);
        search_src_text.click();
        search_src_text.sendKeys("hobbit");
    }

    public String getHobbitFilmText(){
        waitGenericMethod(hobbit2014film);
        return hobbit2014film.getText();
    }

    public void clickFilm(){
        waitGenericMethod(hobbit2014film);
        hobbit2014film.click();
    }

    public String getFilmTitle(){
        waitGenericMethod(title);
        return title.getText();
    }

    public void waitGenericMethod(MobileElement element) {
        FluentWait<AppiumDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(10))
                        .pollingEvery(Duration.ofSeconds(1))
                        .ignoring(NoSuchElementException.class)
                        .withMessage("element not found");

        wait.until(ExpectedConditions.visibilityOf(element));
        Assertions.assertTrue(element.isDisplayed());
    }

}
