package selenium;
import org.apache.commons.lang3.RandomStringUtils;


public class GeneralUtils {

    public static String generateRandomEmail(){
        return RandomStringUtils.randomAlphabetic(8) +"@gmail.com";
    }

    public static String removeCurrency (String price) { return price.replaceAll("[^0-9.]", "");   }
}

