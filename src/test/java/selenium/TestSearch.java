package selenium;

import PageObjects.SearchResultsPage;
import dataProviders.SearchProvider;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.SearchData;

public class TestSearch extends BaseClass {
    @Test
    @Parameters ({"searchCriteria", "expectedResult"})
    public void Validate_Search(@Optional("macbook") String searchCriteria, @Optional ("3") String expectedResult){
        int results = Integer.parseInt(expectedResult);

        searchResultsPage().findElement(searchCriteria);

        Assert.assertTrue(driver.getCurrentUrl().contains("search=" + searchCriteria));
        int actualResults =  searchResultsPage().getResultsCount();
        Assert.assertEquals(actualResults, results,
                String.format("Expecting %s results but got %s", results, actualResults));
    }

    @Test
    public void Test_Empty_Results(){
        String searchCriteria = "Star Wars";
        int expectedResult = 0;

        searchResultsPage().findElement(searchCriteria);

        Assert.assertEquals(searchResultsPage().getResultsCount(), expectedResult,
                String.format("Expecting %s results but got %s", expectedResult, searchResultsPage().getResultsCount()));
    }

    @Test (dataProvider = "getSearchDataFromJson", dataProviderClass = SearchProvider.class) //antes dataProvider = "getSearchData"
    public void Test_Search_WithData(SearchData testData){
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.findElement(testData.getSearchCriteria());

        if (testData.getSearchExpectedResults() > 0)
            Assert.assertEquals(searchResultsPage.getResultsCount(), testData.getSearchExpectedResults());
        else
            Assert.assertTrue(searchResultsPage.isNoResultsVisible());
    }
}
