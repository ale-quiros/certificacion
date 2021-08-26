package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductInfoPage extends BasePage{

    public ProductInfoPage(WebDriver _driver){
        super(_driver);
    }

    //elements
    public By ProductPriceLocator = By.xpath("//ul[@class='list-unstyled']//h2");

 /*   public void clickAddButton(){
        driver.findElement(AddButtonSelector).click();
    }

    public boolean isAlertSuccessDisplayed(){
        return driver.findElement(AlertSuccess).isDisplayed();
    }*/

    public String getProductPrice(){
        return driver.findElement(ProductPriceLocator).getText();
    }

}
