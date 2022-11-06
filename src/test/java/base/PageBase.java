package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    WebDriverWait wait ;
    WebDriver driver ;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickByXpath(String elementXpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath))).click();
    }

    public void clickById(String elementId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId))).click();
    }

    public void clickByClassName(String elementId) {
        WebElement Element = wait.until(ExpectedConditions.elementToBeClickable(By.className(elementId)));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.click();
    }

    public void sendKeyWithId(String elementId, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(elementId))).sendKeys(value);
    }

    public void scrollUntilFind(String elementXpath) {
        WebElement Element = driver.findElement(By.xpath(elementXpath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    public void scroll(String x, String y) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy("+ x + "," + y +")");
    }

    public WebElement getFirstElementByClassName(String className) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
    }

    public void hover(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public WebElement getElementByXpath(String element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }

    public boolean checkElementVisibilityXpath(String element) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).isDisplayed();
    }

    public boolean checkElementVisibilityClassName(String element) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(element)));
    }

    public void clickDivButtonXpath(String elementXpath) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        new Actions(driver).moveToElement(element).click().perform();
    }
}
