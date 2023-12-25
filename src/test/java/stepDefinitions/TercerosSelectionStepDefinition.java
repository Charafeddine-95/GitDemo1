package stepDefinitions;

import PageObjects.TercerosSelectionPage;
import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class TercerosSelectionStepDefinition extends BaseTest {

    public TercerosSelectionPage tercerosSelectionPage = new TercerosSelectionPage(driver);

    @And("^user enters the id in the corporate filter (.+)$")
    public void user_enters_the_id_in_the_corporate_filter(String corporateId) throws Throwable {
        tercerosSelectionPage.setCorporateId(corporateId);
    }

    @And("^user clicks on search button$")
    public void user_clicks_on_search_button() throws Throwable {
        tercerosSelectionPage.clickOnSearchButton();
    }

    @Then("^verify the result (.+)$")
    public void verify_the_result(String corporateId) throws Throwable {
        Assert.assertTrue(tercerosSelectionPage.isResultFound(corporateId),"FAIL");
    }
}
