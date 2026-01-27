package utilities;

import driver.DriverFactory;

public class ElementUtils {

    public static String getCurrentTitle(){
        return DriverFactory.getDriver().getTitle();
    }
    public static String getCurrentURL(){
        return DriverFactory.getDriver().getTitle();
    }

}
