package stepDefinition;

import common.AttachHooks;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import page.LoginPage;

public class LoginStepDef {

    LoginPage loginPage = new LoginPage(AttachHooks.driver);

    private static Logger LOGGER = LoggerFactory.getLogger(LoginStepDef.class);

    @Given("^Go to the (.*) page$")
    public void login_URL_is_given_for_the_Portal(String page) throws Throwable {
        if (loginPage.NavigateToTheURL(page)) {
            LOGGER.info("URL entered Successfully");
        } else {
            Assert.fail();
        }
    }

    @Given("^Verify the login page$")
    public void verify_the_login_page() throws Throwable {
        if (loginPage.VerifyLoginPage()) {
            LOGGER.info("Login page is verified Successfully");
        } else {
            Assert.fail();
        }
    }

    @Then("^Enter login credentials for the (.*)$")
    public void enter_login_credentials_for_the_user(String user) throws Throwable {
        if (loginPage.EnterCredentials(user)) {
            LOGGER.info("Login credentials entered");
        } else {
            Assert.fail();
        }
    }

    @Then("^Click on login button$")
    public void click_on_login_button() throws Throwable {
        if (loginPage.ClickLogin()) {
            LOGGER.info("Login button is clicked");
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify message on Login page for (.*)$")
    public void verify_message(String user) throws Throwable {
        if (loginPage.VerifyMessage(user)) {
            LOGGER.info("Message is verified");
        } else {
            Assert.fail();
        }
    }

    @And("^Logout after successful login for (.*)$")
    public void logout_after_successful_login(String user) throws Throwable {
        if (loginPage.ClickLogout(user)) {
            LOGGER.info("logout is clicked");
        } else {
            Assert.fail();
        }
    }
}
