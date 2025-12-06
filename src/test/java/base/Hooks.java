package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.DriverFactory;
import utilities.Report;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import static driver.DriverFactory.cleanupDriver;
import java.io.ByteArrayInputStream;

public class Hooks {

    private static ExtentReports extent = Report.getInstance();
    public static ExtentTest test;
    private WebDriver driver;

    @Before    
    public void setUp(Scenario scenario) {
//    	 DriverFactory.getInstance().getDriver();
//
//    	    test = extent.createTest(scenario.getName());
    	    DriverFactory.getDriver();

            // ✔ Create test node in Extent report
            Report.getInstance().createTest(scenario.getName());
    }

//    @After
//    
//    public void tearDown() {
//	
//}
    
    @After
    public static void tearDown() {
    	//DriverFactory.getInstance().quitDriver();;
    	//cleanupDriver();
        Report.getInstance().flush();  // <-- Required
        //System.out.println("Extent Report generated.");
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
}

//public void tearDown(Scenario scenario) {
//if (scenario.isFailed()) {
//  // Capture screenshot
//  byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//  test.addScreenCaptureFromPath(saveScreenshot(screenshot), "Failed Screenshot");
//  test.log(Status.FAIL, "Scenario failed");
//} else {
//  test.log(Status.PASS, "Scenario passed");
//}
//if (driver != null) {
//  driver.quit();
//}
//extent.flush();
//}

//package base;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import static driver.DriverFactory.getDriver;
//import static driver.DriverFactory.cleanupDriver;
//
//public class Hooks {
//	
//	@Before
//	public void setup() {
//		getDriver();
//	}
//	@After
//	public void tearDown() {
//		cleanupDriver();
//	}
//}
