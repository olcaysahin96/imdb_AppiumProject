package Page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.jupiter.api.Assertions;

public class LoginPage extends BasePage{
    public LoginPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "sign_in_button")
    private MobileElement sign_in_button;
    @AndroidFindBy(id = "imdb_auth_portal")
    private MobileElement imdb_auth_portal;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='ap_email']")
    private MobileElement email;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='ap_password']")
    private MobileElement password;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='signInSubmit']")
    private MobileElement signInSubmit;
    @AndroidFindBy(id = "user_name")
    private MobileElement user_name;
    @AndroidFindBy(id = "navigation_you")
    private MobileElement navigation_you;

    public void clickYou(){
        waitGenericMethod(navigation_you);
        navigation_you.click();
    }
    public void clickSignIn(){
        waitGenericMethod(sign_in_button);
        sign_in_button.click();
    }
    public void clickImdbSignIn(){
        waitGenericMethod(imdb_auth_portal);
        imdb_auth_portal.click();
    }
    public void sendKeysEmailPassword(){
        waitGenericMethod(email);
        email.sendKeys("qamobiltestekibi@gmail.com");
        waitGenericMethod(password);
        password.sendKeys("24af3535");
    }
    public void clickImdbSignInSubmit(){
        waitGenericMethod(signInSubmit);
        signInSubmit.click();
    }
    public String getUsername(){
        waitGenericMethod(user_name);
        return user_name.getText();
    }
    public void successfulLogin(){
        clickYou();
        clickSignIn();
        clickImdbSignIn();
        sendKeysEmailPassword();
        clickImdbSignInSubmit();
        Assertions.assertEquals(getUsername(),"mobil");
    }
}
