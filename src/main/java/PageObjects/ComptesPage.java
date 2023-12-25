package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ComptesPage extends AbstractComponent {

    WebDriver driver;

    public ComptesPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private final By myElementShadowRoot = By.cssSelector("app-main");
    private final By corporateIdField = By.cssSelector("[id='Input_Text_IdCorpo']");
    private final By searchButton = By.cssSelector("[testlabel='Button_Buscar']");
    private final By searchField = By.cssSelector("[testlabel='Grille_Compte_Util_16text_field_search_input']");

    private final By X = By.cssSelector(".mat-mdc-row");

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

    public boolean isResultFound(String corporateId) throws InterruptedException {
        synchronizedWait(2000);
        SearchContext shadowRoot = driver.findElement(myElementShadowRoot).getShadowRoot();
        List<WebElement> L = shadowRoot.findElements(X);
        if (L.get(0).getText().contains(corporateId) && L.size() == 1)
            return true;
        return false;
    }

    public boolean isResultsFound(String input) throws InterruptedException {
        synchronizedWait(3000);
        SearchContext shadowRoot = driver.findElement(myElementShadowRoot).getShadowRoot();
        List<WebElement> list = shadowRoot.findElements(X);
        if(list.size()==0)
            return false;
        for(WebElement element : list) {
            if (!element.getText().contains(input))
                return false;
        }
        return true;
    }

    public void setSearchField(String keyWord) throws InterruptedException {
        synchronizedWait(1000);
        SearchContext shadowRoot = driver.findElement(myElementShadowRoot).getShadowRoot();
        shadowRoot.findElement(searchField).sendKeys(keyWord);

    }
}
