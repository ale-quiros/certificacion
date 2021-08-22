package selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestAccount extends BaseClass {

    @Description("Validate test login was successful")
    @Test(description = "Test Login Success")
    public void Test_Login_Successful(){
        String username = "ale@test.com";
        String password = "1234";

        loginPage().GoTo();
        loginPage().login(username, password);

        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logoutButton.isDisplayed());
    }


    @Description("Validate test login is working with no valid credentials")
    @Test(description = "Test Login unsuccessful")
    public void Test_Login_UnSuccessful(){
        String username = "ale@test.com";
        String password = "123";
        String expectedMessage = "warning: no match for e-mail address and/or password.";

        loginPage().GoTo();
        loginPage().login(username, password);

        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());
    }

    @Test
    public void Test_Create_New_Account(){
        //setup
        String firstname = "ale";
        String lastname = "quiros";
        String email = "aleq@test.com";
        String telephone = "88888888";
        String password ="123456";
        String expectedMessage = "Your Account Has Been Created!";

        registerPage().GoTo();
        registerPage().FillForm(firstname, lastname, email, telephone, password);

        Assert.assertEquals(registerPage().GetConfirmationMessage(), expectedMessage);
    }
}
