import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TestAccount {
    @Description("Validate test login was successful")
    @Test
    public void Test_Login_Successful(){
        String username = "ale@test.com";
        String password = "1234";

        //String pathToDriver = Test.class.getResource("/chromeDriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");

        // go to Login page
        driver.findElement(By.xpath("//div[@id='top-links']//li[@class='dropdown']//span[@class='caret']")).click();
        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(logoutButton.isDisplayed());

        TakeScreenshot(driver);

        driver.close();
        driver.quit();
        /*
        Ejemplo de listas
        WebElemwnt wishList = driver.findElement(By.linkText("Wish List")).click();
        ArrayList <> WishList = driver.findElement(By.linkText("Wish List")).click();
         */
    }

    @Description("Validate test login is working with no valid credentiasls")
    @Test
    public void Test_Login_UnSuccessful(){
        String username = "ale@test.com";
        String password = "123";
        String expectedMessage = "warning: no match for e-mail address and/or password.";

       // String pathToDriver = Test.class.getResource("/chromeDriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");

        // go to Login page
        driver.findElement(By.xpath("//div[@id='top-links']//li[@class='dropdown']//span[@class='caret']")).click();
        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());
        //Assert.assertTrue(alertMessage.isDisplayed());
        TakeScreenshot(driver);
        driver.close();
        driver.quit();
    }

    @Attachment (value = "screenshot", type = "image/png")
    public byte[] TakeScreenshot(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
