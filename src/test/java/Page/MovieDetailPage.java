package Page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.Dimension;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class MovieDetailPage extends BasePage{
    public MovieDetailPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy (id = "text_off")
    private MobileElement watchlist;
    @AndroidFindBy (xpath = "//*[@text='İzleme Listesine eklendi']")
    private MobileElement addedWatchlist;
    @AndroidFindBy (id = "recycler_view")
    private MobileElement recycler_view;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.view.ViewGroup/android.widget.ImageView[2]")
    private MobileElement favoriteFifthCast;

    public void clickWatchlist(){
        waitGenericMethod(watchlist);
        watchlist.click();
    }
    public String getAddedWatchlist(){
        waitGenericMethod(addedWatchlist);
        return addedWatchlist.getText();
    }
    public void swipeFifthCastFavorite(){
        waitGenericMethod(recycler_view);
        swipeLeft(recycler_view,2);
        waitGenericMethod(favoriteFifthCast);
        favoriteFifthCast.click();
    }
}
