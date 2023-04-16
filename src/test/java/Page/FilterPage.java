package Page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FilterPage extends BasePage{

    public FilterPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(id = "top_rated_movies")
    private MobileElement top_rated_movies;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    public MobileElement firstFilm;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    public MobileElement secondFilm;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    public MobileElement thirdFilm;
    @AndroidFindBy(id = "refine_button")
    private MobileElement refine_button;
    @AndroidFindBy(xpath = "//*[@text='IMDb puanı']")
    private MobileElement sortByImdbRatings;
    @AndroidFindBy(xpath = "//*[@text='Puanlama sayısı']")
    private MobileElement numberOfRatings;

    public void clickTopRatedMovies(){
        waitGenericMethod(top_rated_movies);
        top_rated_movies.click();
    }
    public void clickRefine(){
        waitGenericMethod(refine_button);
        refine_button.click();
    }
    public void clickSortByImdbRatings(){
        waitGenericMethod(sortByImdbRatings);
        sortByImdbRatings.click();
    }
    public void clickNumberOfRatings(){
        waitGenericMethod(numberOfRatings);
        numberOfRatings.click();
    }

}
