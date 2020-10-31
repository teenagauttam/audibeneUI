package page;

import AudibeneBean.DataBean;
import common.BasePage;
import common.ConfigManager;
import objectrepository.UILocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class WindowPage extends BasePage {
    public WindowPage(WebDriver driver) {
        super(driver);
    }

    private static Logger LOGGER = LoggerFactory.getLogger(WindowPage.class);
    BasePage basepage;

    public boolean ClickForNewWindow() {
        try {
            if (isElementPresent(UILocators.clickHereButton, 10)) {
                findElement(UILocators.clickHereButton, 10).click();

                LOGGER.info("Click here button is clicked successfully ");
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Click here button is not clicked successfully " + e.getMessage());
        }
        LOGGER.error("Click here button is not clicked successfully");
        return false;
    }

    public boolean VerifyNewWindow() {
        try {
            // Switch to new window opened
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
            findElement(UILocators.newWindowText, 10).getText().equalsIgnoreCase("New Window");
            String url1 = driver.getCurrentUrl();
            String url2 = ConfigManager.getProperty("PageURL") + "windows/new";

            if (url1.equalsIgnoreCase(url2)) {
                LOGGER.info("New window is verified successfully");
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("New window is not verified successfully " + e.getMessage());
        }
        LOGGER.error("New window is not verified successfully");
        return false;
    }
}
