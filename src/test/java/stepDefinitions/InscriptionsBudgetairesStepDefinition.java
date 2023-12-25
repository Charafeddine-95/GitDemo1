package stepDefinitions;


import PageObjects.InscriptionsBudgetairesPage;
import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class InscriptionsBudgetairesStepDefinition extends BaseTest {

    public InscriptionsBudgetairesPage ibPage = new InscriptionsBudgetairesPage(driver);

    @And("^user clicks on the link (.+)$")
    public void user_Clicks_On_TheLink(String link) throws InterruptedException {
        ibPage.clickLink(link);
    }

    @Then("user clicks on cancel button")
    public void userClicksOnCancelButton() throws InterruptedException {
        ibPage.clickCancelButton();
    }

    @And("^user verifies the snackbar warning message (.+)$")
    public void userVerifiesTheSnackbarWarningMessage(String message) throws InterruptedException {
        Assert.assertTrue(ibPage.isWarningMessageDisplayed(message));
    }

    @And("user checks the PEC checkbox")
    public void userChecksThePECCheckbox() throws InterruptedException {
        ibPage.checkPECCheckbox();
        
    }

    @And("user verifies that the PEC checkbox is unchecked")
    public void userVerifiesThatThePECCheckboxIsUnchecked() throws InterruptedException {
        Assert.assertTrue(ibPage.isPECBoxUnchecked());
    }

    @And("user clicks on Create button")
    public void userClicksOnCreateButton() throws InterruptedException {
        ibPage.clickCreateButton();
    }

    @And("^user enters the signature date (.+)$")
    public void userEntersTheSignatureDate(String date) throws InterruptedException {
        ibPage.setSignatureDate(date);
    }
}
