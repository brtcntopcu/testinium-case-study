package page;

import base.PageBase;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends PageBase {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    WebDriver driver;

    public static String PRODUCT_LIST_MORE_CONTENT_BUTTON_XPATH = "//*[@id=\"pagedListContainer\"]/div[2]/div[2]/button";
    public static String DISCOUNTED_ITEMS_CLASS_NAME = "product__discountPercent";
    public static String SIZE_XPATH = "//label[contains(text(),'54/6N')]";
    public static String GO_BASKET_BUTTON_XPATH = "//*[@id=\"header__desktopBasket\"]/div/div[3]/a";

    public void clickMoreContentButton() {
        scrollUntilFind(PRODUCT_LIST_MORE_CONTENT_BUTTON_XPATH);
        scroll("0","-300");
        clickByXpath(PRODUCT_LIST_MORE_CONTENT_BUTTON_XPATH);
    }

    public void hoverFirstDiscountedItem(){
        hover(getFirstElementByClassName(DISCOUNTED_ITEMS_CLASS_NAME));
    }

    public void chooseSize() {
        clickByXpath(SIZE_XPATH);
    }

    public void goBasket() {
        clickByXpath(GO_BASKET_BUTTON_XPATH);
    }

}
