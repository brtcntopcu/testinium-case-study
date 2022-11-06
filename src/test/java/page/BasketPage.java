package page;

import base.PageBase;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class BasketPage extends PageBase {

    public BasketPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    WebDriver driver;

    public static String FIRST_ITEM_SIZE_XPATH = "//*[@id=\"cop-app\"]/div/div[1]/div[1]/div[1]/div[2]/section/div[3]/div/div/div[1]/div[1]/div[1]/span[2]";
    public static String FIRST_ITEM_OLD_PRICE_XPATH = "//*[@id=\"cop-app\"]/div/div[1]/div[1]/div[1]/div[2]/section/div[3]/div/div/div[1]/div[3]/span[2]";
    public static String FIRST_ITEM_DISCOUNTED_PRICE_XPATH = "//*[@id=\"cop-app\"]/div/div[1]/div[1]/div[1]/div[2]/section/div[3]/div/div/div[1]/div[3]/span[1]";
    public static String CONTINUE_BUTTON_CLASS_NAME = "continueButton";
    public static String REMOVE_ITEM_XPATH = "//*[@id=\"header__desktopBasket\"]/div/div[2]/div/div[3]";
    public static String REMOVE_ITEM_MODAL_BUTTON_CLASS_NAME = "/html/body/div[5]/div[2]/div/div[2]/button[2]";



    public String selectedSize() {
        return getElementByXpath(FIRST_ITEM_SIZE_XPATH).getText();
    }

    public Double firstItemOldPrice() {
        String s = new ArrayList<String>(Arrays.asList(
                getElementByXpath(FIRST_ITEM_OLD_PRICE_XPATH).getText().split(","))).get(0);
        Double old_price = Double.parseDouble(s);
        return old_price;
    }

    public Double getFirstItemDiscountedPrice() {
        String s = new ArrayList<String>(Arrays.asList(
                getElementByXpath(FIRST_ITEM_DISCOUNTED_PRICE_XPATH).getText().split(","))).get(0);
        Double discounted_price = Double.parseDouble(s);
        return discounted_price;
    }

    public void clickContinueButton() {
        clickByClassName(CONTINUE_BUTTON_CLASS_NAME);
    }

    public void removeItem() {
        clickDivButtonXpath(REMOVE_ITEM_XPATH);
        clickDivButtonXpath(REMOVE_ITEM_MODAL_BUTTON_CLASS_NAME);
    }

}
