package page;

import AudibeneBean.DataBean;
import common.BasePage;
import common.ConfigManager;
import objectrepository.UILocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TablePage extends BasePage {
    public TablePage(WebDriver driver) {
        super(driver);
    }

    private static Logger LOGGER = LoggerFactory.getLogger(TablePage.class);
    BasePage basepage;

    public boolean checkLength() {
        try {
            if (isElementPresent(UILocators.exampleOne, 10)) {
                List<WebElement> tableOne = driver.findElements(UILocators.tableOne);
                DataBean.setTableOneLength(tableOne.size());

                List<WebElement> tableTwo = driver.findElements(UILocators.tableTwo);
                DataBean.setTableTwoLength(tableTwo.size());

                LOGGER.info("Table one length is " + DataBean.getTableOneLength());
                LOGGER.info("Table two length is " + DataBean.getTableTwoLength());
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Table length is not fetched successfully " + e.getMessage());
        }
        LOGGER.error("Table length is not fetched successfully");
        return false;
    }

    public boolean clickName(String tableName) {
        try {
            if (tableName.equalsIgnoreCase("table 1")) {
                findElement(UILocators.lastName, 10).click();
                LOGGER.info("Last name is clicked successfully for " + tableName);
                return true;
            } else if (tableName.equalsIgnoreCase("table 2")) {
                findElement(UILocators.firstName, 10).click();
                LOGGER.info("First name is clicked successfully for " + tableName);
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Name is not clicked successfully " + e.getMessage());
        }
        LOGGER.error("Name is not clicked successfully");
        return false;
    }

    public boolean checkAscendingOrder(List<String> tableNames) {
        for (int i = 1; i < tableNames.size(); i++) {
            if (tableNames.get(i - 1).compareTo(tableNames.get(i)) > 0)
                return false;
        }
        LOGGER.info("Names are in ascending order");
        return true;
    }

    public boolean checkDescendingOrder(List<String> tableNames) {
        for (int i = 1; i < tableNames.size(); i++) {
            if (tableNames.get(i).compareTo(tableNames.get(i - 1)) > 0)
                return false;
        }
        LOGGER.info("Names are in descending order");
        return true;
    }

    public boolean VerifyTableOneOrder() {
        try {
            List<String> result = new ArrayList<>();
            for (int i = 1; i <= DataBean.getTableOneLength(); i++) {
                result.add(driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[" + i + "]/td[1]")).getText());
            }
            DataBean.setTableOneNames(result);
            LOGGER.info("Table Last name are added in the list as "+DataBean.getTableOneNames());

            if (checkAscendingOrder(DataBean.getTableOneNames()) || checkDescendingOrder(DataBean.getTableOneNames())) {
                LOGGER.info("List is sorted");
                return true;
            }

        } catch (Exception e) {
            LOGGER.error("Last Names are not sorted successfully " + e.getMessage());
        }
        LOGGER.error("Last Names are not sorted successfully");
        return false;
    }

    public boolean VerifyTableTwoOrder() {
        try {
            List<String> result = new ArrayList<>();
            for (int i = 1; i <= DataBean.getTableTwoLength(); i++) {
                result.add(driver.findElement(By.xpath("//*[@id='table2']/tbody/tr[" + i + "]/td[1]")).getText());
            }
            DataBean.setTableTwoNames(result);
            LOGGER.info("Table First name are added in the list as "+DataBean.getTableTwoNames());
            if (checkAscendingOrder(DataBean.getTableOneNames()) || checkDescendingOrder(DataBean.getTableOneNames())) {
                LOGGER.info("List is sorted");
                return true;
            }

        } catch (Exception e) {
            LOGGER.error("First Names are not sorted successfully " + e.getMessage());
        }
        LOGGER.error("First Names are not sorted successfully");
        return false;
}

}
