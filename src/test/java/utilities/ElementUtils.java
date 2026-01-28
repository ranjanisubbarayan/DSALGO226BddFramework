package utilities;

import driver.DriverFactory;

public class ElementUtils {

    public static String getCurrentTitle(){
        return DriverFactory.getDriver().getTitle();
    }
    public static String getCurrentURL(){
        return DriverFactory.getDriver().getCurrentUrl();
    }
    public static boolean getCurrentURLwithEndpointsArray(){
        return DriverFactory.getDriver().getCurrentUrl().endsWith("arrays-in-python/");
    }
}
