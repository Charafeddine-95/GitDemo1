package stepDefinitions;

import PageObjects.HomePage;
import TestComponents.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HomeStepDefinition extends BaseTest {

    public HomePage homePage = new HomePage(driver);

    @Then("^user is in homepage and verify the page title (.+)$")
    public void user_is_in_homepage_and_verify_the_page_title(String pageTitle) throws Throwable {
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Login failed");
    }

    @And("^user selects tab (.+)$")
    public void user_selects_tab(String tab) throws Throwable {
        homePage.selectTab(tab);
    }

    @And("^user selects sub tab (.+)$")
    public void user_selects_sub_tab(String subTab) throws Throwable {
        homePage.selectSubTab(subTab);
    }

    @And("^user selects the second sub tab (.+)$")
    public void user_selects_the_second_sub_tab(String subTab2) throws Throwable {
        homePage.selectSubTab(subTab2);
    }

    @And("^user chooses the vertical (.+)$")
    public void user_chooses_the_vertical(String vertical) throws Throwable {
        homePage.chooseVertical(vertical);
    }



}
