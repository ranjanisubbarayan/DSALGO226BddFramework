
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

import static driver.DriverFactory.getDriver;


public class Hooks {
    private static final Logger logger = LogManager.getLogger(Hooks.class);
    private WebDriver driver;
    LaunchPage launchPage;
  

    public Hooks(){
        this.driver = getDriver();
        this.launchPage = new LaunchPage(driver);
      
    }

    @Before(order =0)
    public void setUp() {
        WebDriver driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getProperty("baseUrl"));
        
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
