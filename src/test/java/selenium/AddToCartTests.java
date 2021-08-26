package selenium;

import PageObjects.*;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseClass {
    @Description ("Validate Add to cart Working")
    @Test
    public void Test_Add_To_Cart_Functionality(){
        int quantity = 5;
        String imageURL = "macbook_1-47x47.jpg";

        String name = homePage().selectFirstProductAndGetName();
        Assert.assertTrue(productPage().isTitleDisplayed(name));
        productPage().setQuantity(quantity);
        productPage().clickAddButton();
        Assert.assertTrue(productPage().isAlertSuccessDisplayed());
        headerPage().clickOnCartButton();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(shoppingCartPage().isProductNameDisplayed(name), "Title was not displayed");
        Assert.assertEquals(shoppingCartPage().getProductQuantity(), quantity, "Quantity is not matching");
      //  Assert.assertTrue(shoppingCartPage().getProductImageURL().contains(imageURL), "Image is not the one expected");
    }

    @Description("Validate several items added to the cart")
    @Test
    public void Test_Several_Items_Added_To_The_Cart(){
        homePage().selectProductByName("MacBook");
        productPage().setQuantity(2);
        productPage().clickAddButton();
        homePage().GoTo();
        homePage().selectProductByName("iPhone");
        productPage().setQuantity(5);
        productPage().clickAddButton();
        headerPage().clickOnCartButton();
        Assert.assertEquals(shoppingCartPage().getAmountOfShoppingCartRows(), 2, "Expected to get 2 rows");
    }

    @Description("CheckOutProduct para la tarea")
    @Test
    public void Test_Check_Out_Product(){
        String productName = "Mac Air";
        int cantidad = 3;
        String expectedMessage = "Success: You have added MacBook Air to your shopping cart!";
        String expectedCheckOutMessage = "Products marked with *** are not available in the desired quantity or not in stock!";

        searchResultsPage().addToCartElement(productName);
        productPage().setQuantity(cantidad);
        productPage().clickAddButton();

        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(productPage().isAlertSuccessDisplayed());

        headerPage().clickOnCartButton();
        shoppingCartPage().clickOnCheckoutButton();

        Assert.assertTrue(shoppingCartPage().isAlertNotStockDisplayed());

    }

}
