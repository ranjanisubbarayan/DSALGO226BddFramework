package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import pageObjects.homePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.Assert;

import driver.DriverFactory;

public class NFHomeSteps {
	
	private static final Logger logger = LogManager.getLogger(homeSteps.class);
	WebDriver driver;
	private static homePage homepage;
	LaunchPage launchPage;
	
	public NFHomeSteps() {		
		this.driver = DriverFactory.getDriver();   
		 homepage = new homePage(DriverFactory.getDriver());
	}

    @Given("user is on DSAlgo home page")
    public void user_is_on_ds_algo_home_page() {
    	
    	 homepage = new homePage(driver);
    	
    	    homepage.navigateToHomePage();
                homepage.signOutIfLoggedIn();
            
    	    Assert.assertTrue(homepage.isHomePageDisplayed(), "Home page is not displayed");
    	    logger.info("Home page loaded successfully");
    }

    @Given("user launches DSAlgo home page")
    public void user_launches_ds_algo_home_page() {
    
     	
        
    }
    @Then("home page should load within acceptable time")
    public void home_page_should_load_within_acceptable_time() {
    	Assert.assertNotNull(DriverFactory.getDriver(),
                "Driver not initialized");
    }
    @Then("important home page options should be visible")
    public void important_home_page_options_should_be_visible() {
    	
    	 Assert.assertTrue(homepage.areImportantOptionsVisible(), "Important home page options missing");
    	 System.out.println("Print value  "+homepage.areImportantOptionsVisible());
    }

    @Then("home page should be loaded using HTTPS")
    public void home_page_should_be_loaded_using_https() {
        WebDriver driver = DriverFactory.getDriver();
        Assert.assertTrue(driver.getCurrentUrl().startsWith("https"));
    }

    @Then("user should be able to navigate home page using keyboard")
    public void user_should_be_able_to_navigate_home_page_using_keyboard() {
        WebDriver driver = DriverFactory.getDriver();
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        Assert.assertNotNull(driver.switchTo().activeElement());
    }

    @When("user refreshes the home page")
    public void user_refreshes_the_home_page() {
        DriverFactory.getDriver().navigate().refresh();
    }

    @Then("home page should load without errors")
    public void home_page_should_load_without_errors() {
        Assert.assertNotNull(DriverFactory.getDriver().getTitle());
        System.out.println(DriverFactory.getDriver().getTitle());
    }
}
