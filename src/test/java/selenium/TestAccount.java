package selenium;

import dataProviders.SearchProvider;
import dataProviders.UsersProvider;
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

    @Description("nuevos accounts con random emails para la tarea")
    @Test
    public void Test_Create_New_Account(){
        //setup
        String firstname = "ale";
        String lastname = "quiros";
        String email = GeneralUtils.generateRandomEmail();
        String telephone = "88888888";
        String password ="123456";
        String expectedMessage = "Your Account Has Been Created!";

        registerPage().GoTo();
        registerPage().FillForm(firstname, lastname, email, telephone, password);

        Assert.assertEquals(registerPage().getConfirmationMessage(), expectedMessage);
    }

    @Description("Duplicated Emails para la tarea")
    @Test (dataProvider = "duplicatedEmailProvider", dataProviderClass = UsersProvider.class)
    public void Test_Duplicated_Email(String _duplicatedEmail){
        //setup
        String firstname = "ale";
        String lastname = "quiros";
        String email = _duplicatedEmail;   //"aleq@test.com";
        String telephone = "88888888";
        String password ="123456";
        String expectedMessage = "Warning: E-Mail Address is already registered!";

        registerPage().GoTo();
        registerPage().FillForm(firstname, lastname, email, telephone, password);
        Assert.assertEquals(registerPage().getDuplicatedAccountMessage(), expectedMessage);
    }
}
