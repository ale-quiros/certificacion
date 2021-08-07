import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSearch extends BaseClass {
    @Test
    public void Validate_Search(){
       String searchCriteria = "Macbook";
       int expectedResult = 3;

       WebElement searchInput = driver.findElement(By.name("search"));
       searchInput.sendKeys(searchCriteria, Keys.ENTER);

        Assert.assertTrue(driver.getCurrentUrl().contains("search=" + searchCriteria));

        Assert.assertEquals(getResults(), expectedResult,
                String.format("Expecting %s results but got %s", expectedResult, getResults()));
    }

    @Test
    public void Test_Empty_Results(){
        String searchCriteria = "Star Wars";
        int expectedResult = 0;

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchCriteria, Keys.ENTER);

        Assert.assertEquals(getResults(), expectedResult,
                String.format("Expecting %s results but got %s", expectedResult, getResults()));
    }

    public int getResults(){
        return driver.findElements(By.cssSelector(".product-thumb")).size();
    }
}
