package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    private WebDriver driver;

    //Elementos
    private By myAccountLinkLocator = By.className("caret");
    private By loginButtonLocator = By.linkText("Login");
    private By registerButtonlocator = By.linkText("Register");

    public HeaderPage(WebDriver _driver){
        this.driver = _driver;
    }

    public void ClickMyAccount(){
        driver.findElement(myAccountLinkLocator).click();
    }

    public void ClickLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }

    public void ClickOnRegisterButton(){
        driver.findElement(registerButtonlocator).click();
    }


}
