package stepDefinition;

import common.AttachHooks;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import page.TablePage;

public class TableStepDef {
    TablePage tablePage = new TablePage(AttachHooks.driver);

    private static Logger LOGGER = LoggerFactory.getLogger(TableStepDef.class);
    @Given("^Check the length of tables$")
    public void check_the_length_of_tables() throws Throwable {
        if (tablePage.checkLength()) {
            LOGGER.info("Length is set in data bean");
        } else {
            Assert.fail();
        }
    }

    @Then("^Click on last name on (.*)$")
    public void click_on_last_name_on_table_one(String tableName) throws Throwable {
        if (tablePage.clickName(tableName)) {
            LOGGER.info("Last name is clicked");
        } else {
            Assert.fail();
        }
    }

    @And("^Click on first name on (.*)$")
    public void click_on_first_name_on_table_two(String tableName) throws Throwable {
        if (tablePage.clickName(tableName)) {
            LOGGER.info("First name is clicked");
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify the alphabet order of lastName in table 1$")
    public void verify_the_alphabet_order_of_lastName_in_tableOne() throws Throwable {
        if (tablePage.VerifyTableOneOrder()) {
            LOGGER.info("Order is verified");
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify the alphabet order of firstName in table 2$")
    public void verify_the_alphabet_order_of_firstName_in_tableTwo() throws Throwable {
        if (tablePage.VerifyTableTwoOrder()) {
            LOGGER.info("Order is verified");
        } else {
            Assert.fail();
        }
    }

}
