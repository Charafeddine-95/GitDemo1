package PageObjects;

import AbstractComponents.AbstractComponent;
import com.aventstack.extentreports.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InscriptionsBudgetairesPage extends AbstractComponent {

    WebDriver driver;

    public InscriptionsBudgetairesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private final By myElementShadowRoot = By.cssSelector("app-main");

    private final By links = By.cssSelector(".accessibility-a");

    private final By Annuler_button = By.cssSelector("[testlabel='cancel_action_button']");

    private final By warning_message = By.cssSelector("[testlabel='undefined_message']");

    private final By pec_ckeckbox = By.cssSelector("[id='mat-mdc-checkbox-1-input']");

    private final By createButton = By.cssSelector("[testlabel='create_action_button']");

    private final By signatureDate = By.cssSelector("[testlabel='Date_Signature_input']");


    public void clickLink(String link) throws InterruptedException {
        synchronizedWait(1000);
        SearchContext shadowRoot = driver.findElement(myElementShadowRoot).getShadowRoot();
        List<WebElement> linkList = shadowRoot.findElements(links);
        for (WebElement element : linkList) {
            if (element.getText().contains(link))
                element.click();
        }
    }

    public void clickCancelButton() throws InterruptedException {
        synchronizedWait(1000);
        SearchContext shadowRoot = driver.findElement(myElementShadowRoot).getShadowRoot();
        shadowRoot.findElement(Annuler_button).click();

    }

    public boolean isWarningMessageDisplayed(String message) throws InterruptedException {

        return driver.findElement(warning_message).getText().equals(message);
    }

    public void checkPECCheckbox() throws InterruptedException {
        synchronizedWait(1000);
        SearchContext shadowRoot = driver.findElement(myElementShadowRoot).getShadowRoot();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shadowRoot.findElement(pec_ckeckbox));
        shadowRoot.findElement(pec_ckeckbox).click();

    }

    public boolean isPECBoxUnchecked() throws InterruptedException {
        synchronizedWait(1000);
        SearchContext shadowRoot = driver.findElement(myElementShadowRoot).getShadowRoot();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shadowRoot.findElement(pec_ckeckbox));
        return !shadowRoot.findElement(pec_ckeckbox).isSelected();
    }

    public void clickCreateButton() throws InterruptedException {
        synchronizedWait(1000);
        SearchContext shadowRoot = driver.findElement(myElementShadowRoot).getShadowRoot();
        shadowRoot.findElement(createButton).click();
    }

    public void setSignatureDate(String date) throws InterruptedException {
        synchronizedWait(1000);
        SearchContext shadowRoot = driver.findElement(myElementShadowRoot).getShadowRoot();

        shadowRoot.findElement(signatureDate).sendKeys(date);

    }
}
