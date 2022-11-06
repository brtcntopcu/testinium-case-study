package page;

import base.PageBase;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    WebDriver driver;

    public static String SEARCH_BOX = "search";
    public static String ACCEPT_COOKIE_BUTTON = "onetrust-accept-btn-handler";

    public static String HEADER_LOGO_XPATH = "//*[@id=\"home\"]/div[4]/header/div/div/div[2]/a";
    public static String BASKET_ICON_CLASS_NAME = "header__basketTrigger";
    public static String BASKET_COUNT_CLASS_NAME = "header__basket--count";


    public void enterSearch(String item) {
        sendKeyWithId(SEARCH_BOX, item);
    }

    public void acceptCookies() {
        clickById(ACCEPT_COOKIE_BUTTON);
    }

    public void clickHeaderLogo() {
        clickByXpath(HEADER_LOGO_XPATH);
    }

    public void clickBasketIcon() {
        clickByClassName(BASKET_ICON_CLASS_NAME);
    }

    public boolean visibilityBasketCount() {
        return checkElementVisibilityClassName(BASKET_COUNT_CLASS_NAME);
    }

}
