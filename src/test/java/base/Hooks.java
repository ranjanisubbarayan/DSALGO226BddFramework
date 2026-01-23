
package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;
import driver.DriverFactory;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;



public class Hooks {

  

    @Before
    public void setUp(Scenario scenario) {

        WebDriver driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getProperty("baseUrl"));
        
      }

    @After
    public void tearDown(Scenario scenario) {       
        if (scenario.isFailed()) {
            try {
             
            	 byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
            	            .getScreenshotAs(OutputType.BYTES);
              
                scenario.attach(screenshot, "image/png", "Failure Screenshot");
            } catch (Exception e) {
            	scenario.log("Failed to capture screenshot: " + e.getMessage());
            }
        }

      
        DriverFactory.cleanupDriver();

      
        
    }
}
