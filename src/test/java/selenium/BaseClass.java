package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseClass extends PageObjectHandler {

    @Parameters({"browser"})
    @BeforeMethod
    public void BeforeMethod(@Optional("chrome") String browser){
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                InternetExplorerOptions options = new InternetExplorerOptions();
                options.ignoreZoomSettings();

                driver = new InternetExplorerDriver(options);
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void AfterMethod(){
        TakeScreenshot();
        driver.close();
        try {
            driver.quit();
        }
        catch (WebDriverException exception){
            System.out.println("Ya se habia cerrado");
        }

    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] TakeScreenshot(){
        return ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.BYTES);
    }
}
