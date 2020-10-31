package page;

import AudibeneBean.DataBean;
import common.BasePage;
import common.ConfigManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import objectrepository.UILocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);
    BasePage basepage;

    public boolean NavigateToTheURL(String page) {
        try {
            String URL = ConfigManager.getProperty("PageURL") + page;
            LOGGER.info("entering the URL");
            driver.navigate().to(URL);
            LOGGER.info("URL is entered successfully");
            return true;
        } catch (Exception e) {
            LOGGER.error("URL was not entered successfully" + e.getMessage());
        }
        LOGGER.error("URL was not entered successfully");
        return false;
    }

    public boolean VerifyLoginPage() {
        try {
            if (isElementPresent(UILocators.loginButton, 10)) {
                findElement(UILocators.userName, 10).isEnabled();
                findElement(UILocators.password, 10).isEnabled();
                findElement(UILocators.loginButton, 10).isEnabled();
                LOGGER.info("Login page is verified successfully");
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Login page is not verified successfully" + e.getMessage());
        }
        LOGGER.error("Login page is not verified successfully");
        return false;
    }

    public boolean EnterCredentials(String user) {
        try {
            if (user.equalsIgnoreCase("valid")) {
                findElement(UILocators.userName, 10).sendKeys(ConfigManager.getProperty("userName"));
                findElement(UILocators.password, 10).sendKeys(ConfigManager.getProperty("password"));
                LOGGER.info("Valid User name and password are entered successfully");

                return true;
            } else if (user.equalsIgnoreCase("invalid")) {
                findElement(UILocators.userName, 10).sendKeys(ConfigManager.getProperty("invalidUserName"));
                findElement(UILocators.password, 10).sendKeys(ConfigManager.getProperty("invalidPassword"));
                LOGGER.info("Invalid User name and password are entered successfully");

                return true;
            }

        } catch (Exception e) {
            LOGGER.error("User name and password are not entered successfully" + e.getMessage());
        }
        LOGGER.error("User name and password are not entered successfully");
        return false;
    }

    public boolean ClickLogin() {
        try {
            findElement(UILocators.loginButton, 10).click();
            LOGGER.info("Login button is clicked successfully");
            return true;

        } catch (Exception e) {
            LOGGER.error("Login button is not clicked successfully" + e.getMessage());
        }
        LOGGER.error("Login button is not clicked successfully");
        return false;
    }

    public boolean VerifyMessage(String user) {
        try {
            if (isElementPresent(UILocators.message, 10) && user.equalsIgnoreCase("valid")) {
                findElement(UILocators.message, 10).getText().equalsIgnoreCase(ConfigManager.getProperty("successMessage"));
                LOGGER.info("Success message is verified successfully");
                return true;
            } else if (isElementPresent(UILocators.message, 10) && user.equalsIgnoreCase("invalid")) {
                findElement(UILocators.message, 10).getText().equalsIgnoreCase(ConfigManager.getProperty("errorMessage"));
                LOGGER.info("Error message is verified successfully");
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Success message is not verified successfully" + e.getMessage());
        }
        LOGGER.error("Success message is not verified successfully");
        return false;
    }

    public boolean ClickLogout(String user) {
        try {
            if (isElementPresent(UILocators.logoutButton, 10) && user.equalsIgnoreCase("valid")) {
                findElement(UILocators.logoutButton, 10).click();
                LOGGER.info("Logout button is clicked successfully");
                findElement(UILocators.message, 10).getText().equalsIgnoreCase(ConfigManager.getProperty("logoutMessage"));
                LOGGER.info("Message is verified successfully");
                return true;
            } else if (user.equalsIgnoreCase("invalid")) {
                LOGGER.info("Logout button is not available because user was invalid");
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Logout button is not clicked successfully" + e.getMessage());
        }
        LOGGER.error("Logout button is not clicked successfully");
        return false;
    }

}
