package stepDefinition;

import common.AttachHooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import page.WindowPage;

public class WindowStepDef {

    WindowPage windowPage = new WindowPage(AttachHooks.driver);

    private static Logger LOGGER = LoggerFactory.getLogger(WindowStepDef.class);

    @Given("^Click on click here button$")
    public void click_on_click_here_button() throws Throwable {
        if (windowPage.ClickForNewWindow()) {
            LOGGER.info("Click here button is clicked");
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify that user is redirected to new window$")
    public void verify_that_user_is_redirected_to_new_window() throws Throwable {
        if (windowPage.VerifyNewWindow()) {
            LOGGER.info("New window is verified");
        } else {
            Assert.fail();
        }
    }
}
