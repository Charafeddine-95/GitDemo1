package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {

    WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        //initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //PageFactory
    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;
    @FindBy(xpath = "//button[@id='soumettreBtn']")
    private WebElement singIn;
    @FindBy(xpath = "//span[@class='message-text']")
    private WebElement errorMessage;

    public HomePage loginApplication(String email, String pwd)
    {
        username.sendKeys(email);
        password.sendKeys(pwd);
        singIn.click();
        HomePage homePage = new HomePage(driver);
        return homePage;
    }

    public String getErrorMessage()
    {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }

    public void goTo()
    {
        driver.get("https://avgf-shell.qa.gfe.mrc.berger-levrault.com/");
    }
}
