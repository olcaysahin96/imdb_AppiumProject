package Test;

import Page.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

public class MovieDetailTest extends BaseTest{
    private LoginPage loginPage;
    private SearchPage searchPage;
    private MovieDetailPage movieDetailPage;
    private ProfilePage profilePage;
    private BasePage basePage;

    @BeforeEach public void before(){
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        movieDetailPage = new MovieDetailPage(driver);
        profilePage = new ProfilePage(driver);
        basePage =new BasePage(driver);
    }

    @Description("Watchlist yapılan filmi doğrulama")
    @Test
    public void testWatchList(){
        loginPage.successfulLogin();
        searchPage.clickNavigationSearch();
        searchPage.scrollAndClickTop250TVshows();
        searchPage.clickFirstTvShow();
        movieDetailPage.clickWatchlist();
        Assertions.assertEquals(movieDetailPage.getAddedWatchlist(),"İzleme Listesine eklendi");
        loginPage.clickYou();
        Assertions.assertEquals(profilePage.getWatchlistTvTitle(),"Dünya Gezegeni - 2");
    }
    @Description("Favoriye eklenen oyuncuyu doğrulama")
    @Test
    public void testCastFavorite(){
        loginPage.successfulLogin();
        searchPage.clickNavigationSearch();
        searchPage.scrollAndClickTop250TVshows();
        searchPage.clickFirstTvShow();
        basePage.scrollDown(2);
        movieDetailPage.swipeFifthCastFavorite();
        loginPage.clickYou();
        basePage.scrollDown(2);
        Assertions.assertEquals(profilePage.getFavoriteCast(),"Emma Napper");
    }
}
