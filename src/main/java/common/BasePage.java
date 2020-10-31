package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    protected static WebDriver driver;
    static WebDriverWait wait;


    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static void waitForWebElementPresent(WebDriver driver, int seconds, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until( ExpectedConditions.visibilityOf(element));
    }


    public static void scrollIntoViewElement(WebDriver driver , WebElement element) {

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
    }

    //Common Method created to check if element is present - Vishal
    public boolean isElementPresent(By locator, int timeoutInSeconds) {
        try {
            wait = new WebDriverWait(driver, timeoutInSeconds);
            WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            if (elem != null) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    //Common Method created to find an element
    public WebElement findElement(By locator, int timeoutSeconds) {
        wait = new WebDriverWait(driver, timeoutSeconds);
        WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        if (elem != null) {
            return elem;
        } else {
            return null;
        }
    }

    public boolean WaitTime(long time) {
        long startTime = System.currentTimeMillis();;
        long waitTime = Long.parseLong(ConfigManager.getProperty("WaitTime")) * 60000;
        long endTime = time + waitTime;
        if (startTime < endTime) {
            return true;
        } else {
            return false;
        }
    }
}