package stepDefinition;

import common.AttachHooks;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import page.DynamicPage;

public class DynamicStepDef {
    DynamicPage dynamicPage = new DynamicPage(AttachHooks.driver);

    private static Logger LOGGER = LoggerFactory.getLogger(DynamicStepDef.class);

    @Then("^Click on (.*) button and Verify the input field$")
    public void click_button(String buttonType) throws Throwable {
        if (dynamicPage.ClickSwapButton(buttonType)) {
            LOGGER.info(buttonType+" is clicked successfully");
        } else {
            Assert.fail();
        }
    }

    @And("^Verify success message for (.*)$")
    public void verify_success_message(String successMessage) throws Throwable {
        if (dynamicPage.VerifySuccessMessage(successMessage)) {
            LOGGER.info("Message is verified successfully");
        } else {
            Assert.fail();
        }
    }

    @Then("^Enter (.*) in the input$")
    public void enter_value_in_the_input(String input) throws Throwable {
        if (dynamicPage.EnterValue(input)) {
            LOGGER.info("Input is entered");
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify that string is available in the input$")
    public void verify_that_string_is_available_in_the_input() throws Throwable {
        if (dynamicPage.VerifyString()) {
            LOGGER.info("String is verified");
        } else {
            Assert.fail();
        }
    }
}
