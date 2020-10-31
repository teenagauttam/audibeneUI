package stepDefinition;

import common.AttachHooks;
import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import page.ExitPage;

public class ExitStepDef {

    ExitPage exitPage = new ExitPage(AttachHooks.driver);

    private static Logger LOGGER = LoggerFactory.getLogger(ExitStepDef.class);
    @Then("^Move the mouse outside of the viewport$")
    public void move_the_mouse_outside_of_the_viewport() throws Throwable {
        if (exitPage.MoveMouse()) {
            LOGGER.info("Mouse is moved");
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify and click on close button$")
    public void verify_and_click_on_close_button() throws Throwable {
        if (exitPage.VerifyAndClickCloseButton()) {
            LOGGER.info("Close button is clicked");
        } else {
            Assert.fail();
        }
    }
}
