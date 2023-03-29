package Test;

import Page.FilterPage;
import Page.SearchPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import java.util.*;

public class FilterTest extends BaseTest{
    public FilterPage filterPage;
    public SearchPage searchPage;

    @BeforeEach
    public void before(){
        filterPage = new FilterPage(driver);
        searchPage = new SearchPage(driver);
    }

    @Description("Film listesi karsılastırma testi")
    @Test
    public void testFilmListCrossCheck() throws InterruptedException {
        searchPage.clickNavigationSearch();
        filterPage.clickTopRatedMovies();
        Thread.sleep(3000);
        Collection<String> listOne = Arrays.asList(filterPage.firstFilm.getText(),filterPage.secondFilm.getText(),filterPage.thirdFilm.getText());
        filterPage.clickRefine();
        filterPage.clickSortByImdbRatings();
        filterPage.clickNumberOfRatings();
        driver.navigate().back();
        Thread.sleep(3000);
        Collection<String> listTwo = Arrays.asList(filterPage.firstFilm.getText(),filterPage.secondFilm.getText(),filterPage.thirdFilm.getText());
        Collection<String> similarFilm = new HashSet<String>();
        Collection<String> differentFilm = new HashSet<String>();
        differentFilm.addAll(listOne);
        differentFilm.addAll(listTwo);
        similarFilm.addAll(listOne);

        similarFilm.retainAll(listTwo);
        differentFilm.removeAll(similarFilm);

        System.out.println("First film list : " + listOne);
        System.out.println("Second film list : " + listTwo);
        System.out.println("Similar films : " + similarFilm);
        System.out.println("Different films : " + differentFilm);
    }
}
