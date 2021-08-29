package selenium;

import dataProviders.ProductosInfoProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.PrecioProductosData;

public class TestProductos  extends BaseClass {

    @Test (dataProvider = "getPreciosDataFromJson", dataProviderClass = ProductosInfoProvider.class)
    public void Test_Precios_WithData(PrecioProductosData testData){
        final String EURO = "euro";
        final String POUND = "pound";
        final String DOLLAR = "dolar";

        homePage().selectProductByName(testData.getProducto());

        headerPage().selectCurrency(DOLLAR);
        Assert.assertEquals(getPagePrice(productInfoPage().getProductPrice()), testData.getPrecioDolar());
        headerPage().selectCurrency(EURO);
        Assert.assertEquals(getPagePrice(productInfoPage().getProductPrice()), testData.getPrecioEuro());
        headerPage().selectCurrency(POUND);
        Assert.assertEquals(getPagePrice(productInfoPage().getProductPrice()), testData.getPrecioPound());
    }

    public double getPagePrice(String _price){
        return Double.parseDouble(GeneralUtils.removeCurrency(_price));
    }

}
