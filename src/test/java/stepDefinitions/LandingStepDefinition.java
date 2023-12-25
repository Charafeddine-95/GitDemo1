package stepDefinitions;

import PageObjects.LandingPage;
import TestComponents.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LandingStepDefinition extends BaseTest {

    public LandingPage landingPage;

    @Given("^I landed on Sign In Page$")
    public void i_landed_on_sign_in_page() throws Throwable {
        landingPage = launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_username_and_password(String username, String password)
    {
        landingPage.loginApplication(username, password);
    }

    @Then("^login fails and the error message is displayed (.+)$")
    public void loginFailsAndTheErrorMessageIsDisplayed(String errorMessage) {
        Assert.assertEquals(landingPage.getErrorMessage(),errorMessage);

    }
    @After
    public void tearDown()
    {
      //  driver.quit();
    }
}
