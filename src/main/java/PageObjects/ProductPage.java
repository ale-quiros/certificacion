package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver _driver){
        super(_driver);
    }

    //elements
    public String ProductTitleSelector = "//h1[text()='<name>']";
    public By ProductQuantityInputSelector = By.id("input-quantity");
    public By AddButtonSelector = By.id("button-cart");
    public By AlertSuccess = By.cssSelector(".alert-success");
    public By ProductAddedSuccessfuly = By.xpath("//div[@class='alert alert-success alert-dismissible']");

    public boolean isTitleDisplayed(String name){
        return driver.findElement(By.xpath(ProductTitleSelector.replace("<name>", name))).isDisplayed();
    }

    public void setQuantity(int quantity){
        driver.findElement(ProductQuantityInputSelector).clear();
        driver.findElement(ProductQuantityInputSelector).sendKeys("" + quantity);
    }

    public void clickAddButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10 );
        wait.until(ExpectedConditions.presenceOfElementLocated(AddButtonSelector));
        driver.findElement(AddButtonSelector).click();
    }

    public boolean isAlertSuccessDisplayed(){
        return driver.findElement(AlertSuccess).isDisplayed();
    }

    public String getResultProductAddedMessage(){
        String successfulMessage = (driver.findElement(ProductAddedSuccessfuly).getText()).trim();
        return successfulMessage.substring(0, successfulMessage.indexOf("\n"));
    }

    public void addToCart(int _cantidad){
        setQuantity(_cantidad);
        clickAddButton();
    }

}
