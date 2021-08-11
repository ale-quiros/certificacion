package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPage {
    private WebDriver driver;

    //Find elements
    private By firstnameLocator = By.name("firstname");
    private By lastnameLocator = By.name("lastname");
    private By emailLocator = By.name("email");
    private By telephoneLocator = By.name("telephone");
    private By passwordLocator = By.name("password");
    private By confirmPasswordLocator = By.name("confirm");
    private By termsCheckBoxLocator = By.name("agree");
    private By continueButtonLocator = By.xpath("//input[@value='Continue']");

    private By confimRegiterMessageLocator = By.xpath("//div[@id='content']/h1");

    public RegisterPage(WebDriver _driver){
        this.driver = _driver;
    }

    public void GoTo(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.ClickMyAccount();
        headerPage.ClickOnRegisterButton();
    }

    public void FillForm(String firstname, String lastname, String email, String telephone, String password){
        driver.findElement(firstnameLocator).sendKeys(firstname);
        driver.findElement(lastnameLocator).sendKeys(lastname);
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(telephoneLocator).sendKeys(telephone);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(confirmPasswordLocator).sendKeys(password);
        driver.findElement(termsCheckBoxLocator).click();
        driver.findElement(continueButtonLocator).click();
    }

    public String GetConfirmationMessage(){
        return driver.findElement(confimRegiterMessageLocator).getText();
    }

}
