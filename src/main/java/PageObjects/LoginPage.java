package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    //Elements
    private By emailImputLocator = By.name("email");
    private By passwordImputLocator = By.name("password");
    private By loginButtonSelector = By.xpath("//input[@value='Login']");

    public LoginPage(WebDriver _driver){
        this.driver = _driver;
    }

    public void login(String email, String password){
        this.driver.findElement(emailImputLocator).sendKeys(email);
        this.driver.findElement(passwordImputLocator).sendKeys(password);
        this.driver.findElement(loginButtonSelector).click();
    }

    public void GoTo(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.ClickMyAccount();
        headerPage.ClickLoginButton();
    }
}
