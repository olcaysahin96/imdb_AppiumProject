package Test;

import Page.SearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

public class SearchTest extends BaseTest{
    private SearchPage searchPage;

    @BeforeEach
    public void before(){
        searchPage = new SearchPage(driver);
    }

    @Description("Film arama ve film detay testi")
    @Test
    public void testSearchFilmAndFilmDetail(){
        searchPage.clickNavigationSearch();
        searchPage.sendKeysHobbit();
        Assertions.assertEquals(searchPage.getHobbitFilmText(),"Hobbit: Beş Ordunun Savaşı");
        searchPage.clickFilm();
        Assertions.assertEquals(searchPage.getFilmTitle(),"Hobbit: Beş Ordunun Savaşı");
    }
}
