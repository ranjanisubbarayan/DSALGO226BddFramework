package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static driver.DriverFactory.getDriver;
import static driver.DriverFactory.cleanupDriver;

import utilities.Report;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.ExtentTest;

public class Hooks {

    public static ExtentTest test;

    @Before
    public void setUp(Scenario scenario) {

        getDriver();

       
        test = Report.getInstance().createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
       
        if (scenario.isFailed()) {
            try {
             
                byte[] screenshot = ((org.openqa.selenium.TakesScreenshot) getDriver())
                        .getScreenshotAs(org.openqa.selenium.OutputType.BYTES);

              
                test.fail("Scenario Failed",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                java.util.Base64.getEncoder().encodeToString(screenshot)
                        ).build());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

      
        cleanupDriver();

      
        Report.getInstance().flush();
    }
}
