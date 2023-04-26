package Page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProfilePage extends BasePage{
    public ProfilePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(id = "//*[@text='Dünya Gezegeni - 2']")
    private MobileElement watchlistTvTitle;
    @AndroidFindBy(xpath = "//*[@text='Emma Naper']")
    private MobileElement castTitle;

    public String getWatchlistTvTitle(){
        waitGenericMethod(watchlistTvTitle);
        return watchlistTvTitle.getText();
    }
    public String getFavoriteCast(){
        waitGenericMethod(castTitle);
        return castTitle.getText();
    }

}
