package AbstractComponents;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbstractComponent {

    WebDriver driver;

    public AbstractComponent(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@class,'bl-left-menu-item-title ng-tns-c1021977552')]")
    private List<WebElement> tabs;
    @FindBy(xpath = "//*[contains(@class,'bl-left-sub-menu-item')]")
    private List<WebElement> subTabs;

    @FindBy(css = "app-main")
    private WebElement myElementShadowRoot;

    private By tabLocator = By.xpath("//li[@class='bl-left-menu-item ng-tns-c62-3 ng-star-inserted']");

    public void synchronizedWait(int time) throws InterruptedException {
        synchronized (driver) {
            driver.wait(time);
        }
    }

    public void waitForElementToAppear(By findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForWebElementToAppear(WebElement findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void selectTab(String tabName)
    {
        for(WebElement tab : tabs)
        {
            if(tab.getText().contains(tabName))
                tab.click();
        }
    }

    public void selectSubTab(String subTabName)
    {
      //  waitForElementToAppear(tabLocator);
        for(WebElement subTab : subTabs)
        {
            if(subTab.getText().contains(subTabName)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subTab);
                subTab.click();
            }
        }
    }

     public void chooseVertical(String vertical) throws InterruptedException {
        synchronizedWait(1000);
        List<WebElement> verticalList = (List<WebElement>) ((JavascriptExecutor) driver) .executeScript("return arguments[0].shadowRoot.querySelectorAll('[testlabel*=Button_Open] > div > strong')", myElementShadowRoot);
        for(WebElement verticalElement : verticalList)
        {
            if(verticalElement.getText().contains(vertical))
                verticalElement.click();
        }
    }


    public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
        Thread.sleep(2000);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        wait.until(ExpectedConditions.invisibilityOf(ele));
    }
}
