package test;

import base.TestBase;
import data.CSVData;
import log.Log;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import page.BasketPage;
import page.HomePage;
import page.LoginPage;
import page.SearchResultsPage;
import java.io.IOException;


public class MainTest extends TestBase {

    @Test()
    public void mainTest() throws InterruptedException, IOException {
        Log logger = new Log();

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        String selected_size = "54/6N";
        String mail_and_password_csv_path = "src/main/resources/tablo.csv";
        CSVData csvData = new CSVData(mail_and_password_csv_path);

        Assert.assertEquals("https://www.network.com.tr/",driver.getCurrentUrl());
        logger.info("URL checked");

        homePage.acceptCookies();
        homePage.enterSearch("ceket" + Keys.ENTER);
        logger.info("Item searched");

        searchResultsPage.clickMoreContentButton();
        logger.info("Clicked more content button");

        Thread.sleep(750); // wait for refreshed url
        Assert.assertEquals("https://www.network.com.tr/search?searchKey=ceket&page=2",driver.getCurrentUrl());
        logger.info("URL checked");

        searchResultsPage.hoverFirstDiscountedItem();
        searchResultsPage.chooseSize();
        searchResultsPage.goBasket();
        Assert.assertEquals(selected_size, basketPage.selectedSize());
        logger.info("Added item size checked");

        Assert.assertTrue(basketPage.firstItemOldPrice() > basketPage.getFirstItemDiscountedPrice());
        logger.info("Old price and discounted price compared");

        basketPage.clickContinueButton();

        String mail = csvData.dataFromCSV()[0][0].toString();
        String password = csvData.dataFromCSV()[0][1].toString();

        loginPage.login(mail, password);
        Assert.assertTrue(loginPage.checkLoginButtonVisibility());
        logger.info("Login button visibility checked");
        homePage.clickHeaderLogo();
        homePage.clickBasketIcon();
        basketPage.removeItem();
        Assert.assertTrue(homePage.visibilityBasketCount());
        logger.info("Empty basket checked");
    }
}
