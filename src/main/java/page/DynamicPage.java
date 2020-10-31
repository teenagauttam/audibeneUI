package page;

import AudibeneBean.DataBean;
import common.BasePage;
import common.ConfigManager;
import objectrepository.UILocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicPage extends BasePage {
    public DynamicPage(WebDriver driver) {
        super(driver);
    }

    private static Logger LOGGER = LoggerFactory.getLogger(DynamicPage.class);

    public boolean ClickSwapButton(String buttonType) {
        try {
            if (buttonType.equalsIgnoreCase("Enable") && !findElement(UILocators.inputExample, 10).isEnabled()) {
                LOGGER.info("Input field is disabled");
                findElement(UILocators.swapButton, 10).getText().equalsIgnoreCase("Enable");
                LOGGER.info("Button Name is Enable");
                findElement(UILocators.swapButton, 10).click();
                return true;
            } else if (buttonType.equalsIgnoreCase("Disable") && findElement(UILocators.inputExample, 10).isEnabled()) {
                LOGGER.info("Input field is enabled");
                findElement(UILocators.swapButton, 10).getText().equalsIgnoreCase("Disable");
                LOGGER.info("Button Name is Disable");
                findElement(UILocators.swapButton, 10).click();
                return true;
            }
        } catch (Exception e) {
            LOGGER.error(buttonType+" button is not clicked successfully " + e.getMessage());
        }
        LOGGER.error(buttonType+" button is not clicked successfully");
        return false;
    }

    public boolean VerifySuccessMessage(String successMessage) {
        try {
            if (isElementPresent(UILocators.messageDynamic, 10) && successMessage.equalsIgnoreCase("Enable")) {
                findElement(UILocators.inputExample, 10).getText().equalsIgnoreCase(ConfigManager.getProperty("enableMessage"));
                LOGGER.info("Success message is verified successfully for "+successMessage);
                return true;
            }else if (isElementPresent(UILocators.messageDynamic, 10) && successMessage.equalsIgnoreCase("Disable")) {
                findElement(UILocators.inputExample, 10).getText().equalsIgnoreCase(ConfigManager.getProperty("disableMessage"));
                LOGGER.info("Success message is verified successfully for "+successMessage);
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Success message is not verified successfully for "+successMessage + e.getMessage());
        }
        LOGGER.error("Success message is not verified successfully");
        return false;
    }

    public boolean EnterValue(String input) {
        try {
            if (isElementPresent(UILocators.inputExample, 10)) {
                DataBean.setInputValue(input);
                findElement(UILocators.inputExample, 10).sendKeys(input);
                LOGGER.info("Input value is entered successfully");
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Input value is not entered successfully " + e.getMessage());
        }
        LOGGER.error("Input value is not entered successfully");
        return false;
    }

    public boolean VerifyString() {
        try {
            if (findElement(UILocators.inputExample,10).getAttribute("value").equalsIgnoreCase(DataBean.getInputValue())) {
                LOGGER.info("Input value is matched successfully as "+DataBean.getInputValue());
                return true;
            }

        } catch (Exception e) {
            LOGGER.error("Input value is not matched successfully as "+DataBean.getInputValue() + e.getMessage());
        }
        LOGGER.error("Input value is not matched successfully");
        return false;
    }
}
