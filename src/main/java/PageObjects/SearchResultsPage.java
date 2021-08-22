package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage{

    private static final String ERROR_MESSAGE_NO_RESULTS_DISPLAYED = "There is no product that matches the search criteria.";
    //FindElements
    private By resultsSelector = By.className("product-thumb");
    private By noResultsSelector = By.id("content");
    private By searchFieldLocator = By.name("search");
    private By searchButtonLocator = By.xpath("//button[@class='btn btn-default btn-lg']");

    public SearchResultsPage(WebDriver _driver){
        super(_driver);
    }

    public int getResultsCount(){
        return driver.findElements(resultsSelector).size();
    }

    public boolean isNoResultsVisible(){
        return driver.findElement(noResultsSelector).getAttribute("innerHTML").contains(ERROR_MESSAGE_NO_RESULTS_DISPLAYED);
    }

    public void findElement(String _searchCriteria){
        driver.findElement(searchFieldLocator).sendKeys(_searchCriteria);
        driver.findElement(searchButtonLocator).click();
    }
}
