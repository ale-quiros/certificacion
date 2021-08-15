import PageObjects.HeaderPage;
import PageObjects.LoginPage;
import dataProviders.SearchProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.SearchData;

import java.util.List;

public class TestSearch extends BaseClass {
    @Test
    @Parameters ({"searchCriteria", "expectedResult"})
    public void Validate_Search(@Optional("macbook") String searchCriteria, @Optional ("3") String expectedResult){
        int results = Integer.parseInt(expectedResult);

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchCriteria, Keys.ENTER);

        Assert.assertTrue(driver.getCurrentUrl().contains("search=" + searchCriteria));
        int actualResults =  getResults();
        Assert.assertEquals(actualResults, results,
                String.format("Expecting %s results but got %s", results, actualResults));
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
        return driver.findElements(By.className("product-thumb")).size();
    }

    @Test (dataProvider = "getSearchDataFromJson", dataProviderClass = SearchProvider.class) //antes dataProvider = "getSearchData"
    public void Test_Search_WithData(SearchData testData){
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(testData.getSearchCriteria());
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

        if (testData.getSearchExpectedResults() > 0)
            Assert.assertEquals(getResults(), testData.getSearchExpectedResults());
        else
        {
            String errorMessage = "There is no product that matches the search criteria.";
            WebElement content = driver.findElement(By.id("content"));
            String actualErrorMessage = content.getAttribute("innerHTML");
            Assert.assertTrue(actualErrorMessage.contains(errorMessage));
        }
    }
}
