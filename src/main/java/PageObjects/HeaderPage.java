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
    private By yourCurrencyLocator = By.xpath("//i[@class='fa fa-caret-down']");
    private By euroCurrencyLocator = By.name("EUR");
    private By poundCurrencyLocator = By.name("GBP");
    private By dolarCurrencyLocator = By.name("USD");

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

    public void clickOnCurencyButton() {driver.findElement(yourCurrencyLocator).click();}

    public void selectEuroCurrencyOption() {driver.findElement(euroCurrencyLocator).click();}

    public void selectPoundCurrencyOption() {driver.findElement(poundCurrencyLocator).click();}

    public void selectDolarCurrencyOption() {driver.findElement(dolarCurrencyLocator).click();}

    public void selectCurrency(String _currency){
        clickOnCurencyButton();
        switch(_currency) {
            case "euro":
                selectEuroCurrencyOption();
                break;
            case "pound":
                selectPoundCurrencyOption();
                break;
            default:
                selectDolarCurrencyOption();
        }
    }


}
