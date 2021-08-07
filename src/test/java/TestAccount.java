import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TestAccount extends BaseClass{
    @Description("Validate test login was successful")
    @Test(description = "Test Loggin Success")
    public void Test_Login_Successful(){
        String username = "ale@test.com";
        String password = "1234";

        driver.findElement(By.xpath("//div[@id='top-links']//li[@class='dropdown']//span[@class='caret']")).click();
        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logoutButton.isDisplayed());
    }

    @Description("Validate test login is working with no valid credentiasls")
    @Test(description = "Test Login unsuccessful")
    public void Test_Login_UnSuccessful(){
        String username = "ale@test.com";
        String password = "123";
        String expectedMessage = "warning: no match for e-mail address and/or password.";

        driver.findElement(By.xpath("//div[@id='top-links']//li[@class='dropdown']//span[@class='caret']")).click();
        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());
    }
}
