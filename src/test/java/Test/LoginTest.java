package Test;

import Page.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeEach
    public void before(){
        loginPage = new LoginPage(driver);
    }

    @Description("Başarılı login testi")
    @Test
    public void testSuccessfulLogin(){
        loginPage.clickYou();
        loginPage.clickSignIn();
        loginPage.clickImdbSignIn();
        loginPage.sendKeysEmailPassword();
        loginPage.clickImdbSignInSubmit();
        Assertions.assertEquals(loginPage.getUsername(),"mobil");
    }
}
