package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import driver.DriverFactory;

public class ExtentTestNGListener implements ITestListener {

    private static ExtentReports extent = Report.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        LoggerLoad.info("Starting test: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed");
        LoggerLoad.info("Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, result.getThrowable());
        LoggerLoad.error("Test Failed: " + result.getMethod().getMethodName());

        // Get WebDriver from DriverFactory
        WebDriver driver = DriverFactory.getDriver();

        // Take screenshot
        String screenshotPath =
                ScreenshotUtil.takeScreenshot(driver, result.getMethod().getMethodName());

        // Attach screenshot to Extent report
        try {
            test.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped");
        LoggerLoad.warn("Test Skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        LoggerLoad.info("===== Test Execution Finished =====");
    }
}
