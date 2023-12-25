package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TercerosSelectionPage extends AbstractComponent {

    WebDriver driver;

    public TercerosSelectionPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private final By myElementShadowRoot = By.cssSelector("app-main");
    private final By corporateIdField = By.cssSelector("[id='Input_Text_IdCorpo']");
    private final By searchButton = By.cssSelector("[testlabel='Button_Buscar']");

    private final By X = By.cssSelector(".mat-row");

    public void setCorporateId(String corporateId)
    {
        SearchContext shadowRoot = driver.findElement(myElementShadowRoot).getShadowRoot();
        shadowRoot.findElement(corporateIdField).sendKeys(corporateId);
    }

    public void clickOnSearchButton()
    {
        SearchContext shadowRoot = driver.findElement(myElementShadowRoot).getShadowRoot();
        shadowRoot.findElement(searchButton).click();
    }

    public boolean isResultFound(String corporateId) {
        SearchContext shadowRoot = driver.findElement(myElementShadowRoot).getShadowRoot();
        List<WebElement> L = shadowRoot.findElements(X);
        if (L.get(0).getText().contains(corporateId) && L.size() == 1)
            return true;
        return false;
    }
}
