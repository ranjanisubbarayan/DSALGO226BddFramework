package stepDefinitions;

import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.LaunchPage;
import pageObjects.homePage;
import utilities.ElementUtils;
import driver.DriverFactory;

public class homeSteps {

	private static final Logger logger = LogManager.getLogger(homeSteps.class);
    WebDriver driver;
    private homePage homepage;
    private LaunchPage launchPage;
    
  
    @Given("the user opens the browser")
    public void the_user_opens_the_browser() {    	
    	logger.info("successfully logged into the Homepage of the application");
    }

    @When("The user clicks the Get Started button in DS Algo Portal")
    public void the_user_clicks_the_get_started_button_in_ds_algo_portal() {
    	 homepage = launchPage.clickGetStarted();
    }

    @Then("the DS Algo Portal page should be displayed with the Get Started button")
    public void the_ds_algo_portal_page_should_be_displayed_with_the_get_started_button() {
    	String actualpageTitle = ElementUtils.getCurrentTitle();
    	String expectedTitle = "NumpyNinja";
    	System.out.println("Page Title:"+ actualpageTitle);
    	Assert.assertEquals(actualpageTitle, expectedTitle, 
    		    "Page title mismatch!");
        logger.info("User successfully opened the browser and landed on Home page");
    }

    @Then("the user should be navigated to the Home page")
    public void the_user_should_be_navigated_to_the_home_page() {
    	Assert.assertTrue(ElementUtils.getCurrenURLEndswith(), "Page URL mismatch!");
    }

    @Given("The user is on Home page")
    public void the_user_is_on_home_page() {
    	 launchPage = new LaunchPage(driver);
 		homepage = launchPage.clickGetStarted();
         Assert.assertTrue(homepage.isHomePageDisplayed(), "Home page not displayed");
    }
  
    @When("User clicks the Data Structure dropdown")
    public void user_clicks_the_data_structure_dropdown() {
    	 homepage.openDropdown();
        logger.info("User clicked Data Structure dropdown");
    }
    
       @Then("The user should be able to see all modules in the dropdown:")
    public void the_user_should_be_able_to_see_all_modules_in_the_dropdown(io.cucumber.datatable.DataTable dataTable) {
    	List<String> expectedModules = dataTable.asList();
        List<String> actualModules = homepage.getDropdownModules();
        Assert.assertEquals(expectedModules, actualModules);
    }

    @When("User selects module {string} from the dropdown")
    public void user_selects_module_from_the_dropdown(String moduleName) {
    	homepage.clickDropdownModule(moduleName);
         logger.info("User clicked module: " + moduleName);
    }

    @Then("The user should be able to see a warning message {string}")
    public void the_user_should_be_able_to_see_a_warning_message(String expectedMessage) {
    	String actualMessage = homepage.getWarningMessageText();
        Assert.assertEquals(expectedMessage, actualMessage, "Warning message mismatch!");
        System.out.println("Expected Message :  "+ expectedMessage);
        System.out.println("Actual Message :  "+ actualMessage);
    }

    @When("User clicks the Get Started button for module {string}")
    public void user_clicks_the_get_started_button_for_module(String moduleName) {
    	homepage.clickGetStartedForModule(moduleName);
        logger.info("User clicked Get Started for module: " + moduleName);
    }
    
    @Then("home page should load within {string} seconds")
    public void home_page_should_load_within_acceptable_time(String seconds) {
    	Assert.assertNotNull(DriverFactory.getDriver(),
                "Driver not initialized");
    	long maxTime = Long.parseLong(seconds);

        long startTime = System.currentTimeMillis();
        homepage.waitForHomePageToLoad();
        long loadTime = (System.currentTimeMillis() - startTime) / 1000;

        Assert.assertTrue(loadTime <= maxTime,
                "Home page load time exceeded limit: " + loadTime + " seconds");
    }
    @Then("important home page options should be visible")
    public void important_home_page_options_should_be_visible() {
    	
    	 Assert.assertTrue(homepage.areImportantOptionsVisible(), "Important home page options missing");
    	
    }

    @Then("home page should be loaded using HTTPS")
    public void home_page_should_be_loaded_using_https() {
    	String url = driver.getCurrentUrl();
        Assert.assertTrue(url.startsWith("https://"), "Home page is not loaded over HTTPS");
    }

   
    @When("user refreshes the home page")
    public void user_refreshes_the_home_page() {
    	 driver.navigate().refresh();
    }

    @Then("home page should load without errors")
    public void home_page_should_load_without_errors() {
    	 String pageSource = driver.getPageSource();
	        Assert.assertFalse(pageSource.contains("error"), "Page contains 'error'");
	        Assert.assertFalse(pageSource.contains("404"), "Page contains '404'");
	        Assert.assertFalse(pageSource.contains("500"), "Page contains '500'");
	    }
}
