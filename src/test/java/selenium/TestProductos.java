package selenium;

import dataProviders.PreciosProductosProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.PrecioProductosData;

public class TestProductos  extends BaseClass {
    @Test (dataProvider = "getPreciosDataFromJson", dataProviderClass = PreciosProductosProvider.class)
    public void Test_Search_WithData(PrecioProductosData testData){
        homePage().selectProductByName(testData.getProducto());

        //euro
        headerPage().clickOnCurencyButton();
        headerPage().selectEuroCurrencyOption();
        Assert.assertEquals(testData.getPrecioEuro(), Double.parseDouble(GeneralUtils.removeCurrency(productInfoPage().getProductPrice())));

        //pound

        headerPage().clickOnCurencyButton();
        headerPage().selectPoundCurrencyOption();
        System.out.println(productInfoPage().getProductPrice());
        Assert.assertEquals(testData.getPrecioPound(), Double.parseDouble(GeneralUtils.removeCurrency(productInfoPage().getProductPrice())));

        //dolar

        headerPage().clickOnCurencyButton();
        headerPage().selectDolarCurrencyOption();
        System.out.println(productInfoPage().getProductPrice());
        Assert.assertEquals(testData.getPrecioDolar(), Double.parseDouble(GeneralUtils.removeCurrency(productInfoPage().getProductPrice())));


 /*       SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.findElement(testData.getSearchCriteria());

        if (testData.getSearchExpectedResults() > 0)
            Assert.assertEquals(searchResultsPage.getResultsCount(), testData.getSearchExpectedResults());
        else
            Assert.assertTrue(searchResultsPage.isNoResultsVisible());*/
    }

    public void selectProduct(String _product){
        homePage().selectProductByName(_product);
        headerPage().clickOnCurencyButton();
        headerPage().selectEuroCurrencyOption();
    }


}
