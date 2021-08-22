package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage{

    //Elementos
    private By myAccountLinkLocator = By.className("caret");
    private By loginButtonLocator = By.linkText("Login");
    private By registerButtonlocator = By.linkText("Register");
    private By shoppingCartLocator = By.linkText("Shopping Cart");
    private By yourStoreButtonLocator = By.linkText("Your Store");

    public HeaderPage(WebDriver _driver){
        super(_driver);
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

    public void clickOnCartButton(){
        driver.findElement(shoppingCartLocator).click();
    }

    public void clickOnYourStoreButton() {driver.findElement(yourStoreButtonLocator).click();}


}
