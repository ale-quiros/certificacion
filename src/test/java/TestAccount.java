import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAccount {
    @Test
    public void Test_Login_Successful(){
        String username = "ale@test.com";
        String password = "1234";
        String pathToDriver = Test.class.getResource("/chromeDriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", pathToDriver);
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

        driver.close();
        driver.quit();
        /*
        Ejemplo de listas
        WebElemwnt wishList = driver.findElement(By.linkText("Wish List")).click();
        ArrayList <> WishList = driver.findElement(By.linkText("Wish List")).click();
         */
    }
}
