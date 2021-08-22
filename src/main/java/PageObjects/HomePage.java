package PageObjects;

import Selectors.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver _driver){
        super(_driver);
    }

    public String getProductName(){
        return driver.findElement(HomePageLocators.FirstProductTitleSelector).getText();
    }

    public void selectProductByName(String name){
        driver.findElement(By.xpath(HomePageLocators.FirstH4Locator.replace("<name>", name))).click();
    }

    public String selectFirstProductAndGetName(){
        String name = getProductName();
        selectProductByName(name);
        return name;
    }

    public void GoTo(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnYourStoreButton();
    }

}
