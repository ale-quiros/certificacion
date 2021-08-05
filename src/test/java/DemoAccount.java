import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;


public class DemoAccount {
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @Ignore
    @Test
    public void testCapabilities(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--headless");
        //options.setHeadless(true);
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(options);
        //driver.get("https://www.seleniumeasy.com/test");
        driver.get("https://expired.badssl.com");
        Assert.assertTrue(driver.findElement(By.id("content")).isDisplayed());

       // driver.manage().window().maximize();
    }

    @Test
    public void testWaits(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
        driver.findElement(By.id("downloadButton")).click();

        boolean result = false;
        try {
            result = wait.until(
                    ExpectedConditions.textToBe(
                            By.className("progress-label"), "Complete!"));
        }
        catch (WebDriverException exception){
            System.out.println("No funciono");
        }
    }

    /*
    @Test
    public void drag_and_drop(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");

        Actions actions = new Actions(driver);
        WebElement caja1 = driver.findElement()

        actions.dragAndDrop();
    }
    */
}
