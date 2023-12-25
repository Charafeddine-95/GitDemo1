package stepDefinitions;

import PageObjects.ComptesPage;
import PageObjects.TercerosSelectionPage;
import TestComponents.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ComptesStepDefinition extends BaseTest {

    public ComptesPage comptesPage = new ComptesPage(driver);


    @Then("^user types the key word in the search field (.+)$")
    public void userTypesTheKeyWordInTheSearchField(String keyWord) throws InterruptedException {
        comptesPage.setSearchField(keyWord);

    }

    @And("^user verifies that key word is present in all results (.+)$")
    public void userVerifiesThatKeyWordIsPresentInAllResults(String keyWord) throws InterruptedException {
        Assert.assertTrue(comptesPage.isResultsFound(keyWord),"keyword not found or empty results");
    }

}

