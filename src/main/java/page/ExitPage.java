package page;

import common.BasePage;
import common.ConfigManager;
import objectrepository.UILocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExitPage extends BasePage {
    public ExitPage(WebDriver driver) {
        super(driver);
    }

    private static Logger LOGGER = LoggerFactory.getLogger(ExitPage.class);
    BasePage basepage;

    public boolean MoveMouse() {
        try {
            Actions action = new Actions(driver);
            action.moveByOffset(600, -1).build().perform();
            findElement(UILocators.closeButton, 10).getText().equalsIgnoreCase("Close");
            return true;
        } catch (Exception e) {
            LOGGER.error("Mouse was not moved successfully" + e.getMessage());
        }
        LOGGER.error("Mouse was not moved successfully");
        return false;
    }

    public boolean VerifyAndClickCloseButton() {
        try {
            Actions a = new Actions(driver);
            WebElement as = findElement(UILocators.closeButton, 10);
            a.moveToElement(as).build().perform();
            return true;
        } catch (Exception e) {
            LOGGER.error("Close button is not clicked successfully" + e.getMessage());
        }
        LOGGER.error("Close button is not clicked successfully");
        return false;
    }
}
