package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends AbstractComponent {

    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private final By myElementShadowRoot = By.cssSelector("app-main");
    private final By homePageTitle = By.cssSelector(".bl-navbar-brand");

    public String getHomePageTitle()
    {
        //SearchContext shadowRoot = driver.findElement(myElementShadowRoot).getShadowRoot();
        //return shadowRoot.findElement(homePageTitle).getText().trim();
        return driver.findElement(homePageTitle).getText().trim();
    }
}
