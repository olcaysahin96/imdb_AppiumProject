package Page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

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

}
