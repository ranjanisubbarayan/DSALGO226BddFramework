package base;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.DriverFactory;
import utilities.LoggerLoad;
import utilities.Report;
import utilities.ScreenshotUtils;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import static driver.DriverFactory.cleanupDriver;
import java.io.ByteArrayInputStream;

public class Hooks {
	private static final Logger logger = LoggerLoad.getLogger(Hooks.class);

 //   private static ExtentReports extent = Report.getInstance();
    public static ExtentTest test;
 

    
    @Before(order = 0)
    public void startReport() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
    }
    
    @Before(order = 1) 
    public void setUp(Scenario scenario) {
    	 driver = DriverFactory.getDriver();
   	    test = extent.createTest(scenario.getName());
        test.info("Starting scenario: " + scenario.getName());
        	logger.info("Starting scenario: " + scenario.getName());
        	// DriverFactory.getInstance().getDriver();
        	
                       
    }
   
    @After(order = 1)
    public void tearDown(Scenario scenario) {
    	
    	logger.info("Ending scenario: " + scenario.getName());
    	if (scenario.isFailed()) {
            test.fail("Scenario failed: " + scenario.getName());
        } else {
            test.pass("Scenario passed");
        }

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Screenshot");

            String screenshotPath = ScreenshotUtils.takeScreenshot(driver, scenario.getName());

            test.fail("Scenario Failed. Screenshot Attached:")
                .addScreenCaptureFromPath(screenshotPath);
        }
        else {
            test.pass("Scenario Passed");
        }
      //  DriverFactory.getInstance().quitDriver();

        if (driver != null) {
           // driver.quit();
        }

        extent.flush();
    }

    private String saveScreenshot(byte[] screenshot) {
        // Save screenshot to a file and return path
        try {
            String path = "target/screenshots/" + System.currentTimeMillis() + ".png";
            java.nio.file.Files.createDirectories(java.nio.file.Paths.get("target/screenshots"));
            java.nio.file.Files.write(java.nio.file.Paths.get(path), screenshot);
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @After(order = 0)
    public void flushReport() {
        extent.flush();
    }
}

