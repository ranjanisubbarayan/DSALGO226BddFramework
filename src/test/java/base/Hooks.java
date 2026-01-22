
package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;
import com.aventstack.extentreports.MediaEntityBuilder;
import driver.DriverFactory;
import com.aventstack.extentreports.ExtentTest;

public class Hooks {

    public static ExtentTest test;

    @Before
    public void setUp(Scenario scenario) {

        WebDriver driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getProperty("baseUrl"));
        
      }

    @After
    public void tearDown(Scenario scenario) {       
        if (scenario.isFailed()) {
            try {
             
                byte[] screenshot = ((org.openqa.selenium.TakesScreenshot) DriverFactory.getDriver())
                        .getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
              
                test.fail("Scenario Failed",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                java.util.Base64.getEncoder().encodeToString(screenshot)
                        ).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

      
        DriverFactory.cleanupDriver();

      
        
    }
}
