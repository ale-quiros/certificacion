package dataProviders;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;
import pojo.PrecioProductosData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class PreciosProductosProvider {

    @DataProvider(name ="getPreciosDataFromJson")
    private Object[][] getPreciosDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/TestData/productosPrecios.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<PrecioProductosData> testData = new Gson().fromJson(dataSet, new TypeToken<List<PrecioProductosData>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each: returnValue){
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

}
