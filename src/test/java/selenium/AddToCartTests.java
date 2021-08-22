package selenium;

import PageObjects.*;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseClass {
    @Description ("Validate Add to cart Working")
    @Test
    public void Test_Add_To_Cart_Functionality(){
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        int quantity = 5;

        String name = homePage.selectFirstProductAndGetName();
        Assert.assertTrue(productPage.isTitleDisplayed(name));
        productPage.setQuantity(quantity);
        productPage.clickAddButton();
        Assert.assertTrue(productPage.isAlertSuccessDisplayed());
        headerPage.clickOnCartButton();
        //Assert.assertTrue(shoppingCartPage.isProductNameDisplayed(name), "Title was not displayed");
        Assert.assertEquals(shoppingCartPage.getProductQuantity(), quantity, "Quantity is not matching");
    }
}
