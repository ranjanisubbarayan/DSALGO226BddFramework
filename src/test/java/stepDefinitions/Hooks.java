
package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import pageObjects.homePage;
import utilities.ConfigReader;
import driver.DriverFactory;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

public class Hooks {
    private static final Logger logger = LogManager.getLogger(Hooks.class);
    private WebDriver driver;
    LaunchPage launchPage;
  
    @Before(order =0)
    public void setUp(Scenario scenario) {        
    	String browser = System.getProperty("browser");

        if (browser == null || browser.isEmpty()) {
            browser = ConfigReader.getProperty("browser");
        }

        DriverFactory.setBrowser(browser);
        driver = DriverFactory.getDriver();

        driver.get(ConfigReader.getProperty("baseUrl"));
        launchPage = new LaunchPage(driver);
    }
      @Before(value = "@signIn",order = 1)
      public void init_signIn(){

          homePage homepage = launchPage.clickGetStarted();

          if (!homepage.isUserLoggedIn()) {
              homepage.clickSignInLinkIfPresent();
              LoginPage loginPage = new LoginPage(driver);
              loginPage.enterUsername(ConfigReader.getProperty("username"));
              loginPage.enterPassword(ConfigReader.getProperty("password"));
              loginPage.clickLoginButton();
          }
          logger.info("successfully logged into the dsalgo application");
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
