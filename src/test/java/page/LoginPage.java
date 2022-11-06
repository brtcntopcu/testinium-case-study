package page;

import base.PageBase;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    WebDriver driver;

    public static String EMAIL_INPUT_ID = "n-input-email";
    public static String PASSWORD_INPUT_ID = "n-input-password";
    public static String LOGIN_BUTTON_XPATH = "//*[@id=\"login\"]/button";

    public void login(String mail, String password) {
        sendKeyWithId(EMAIL_INPUT_ID,mail);
        sendKeyWithId(PASSWORD_INPUT_ID,password);
    }

    public boolean checkLoginButtonVisibility() {
        return checkElementVisibilityXpath(LOGIN_BUTTON_XPATH);
    }



}
