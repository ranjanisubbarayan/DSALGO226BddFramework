package stepDefinitions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import pageObjects.homePage;
import pageObjects.registerPage;
import driver.DriverFactory;

public class homeSteps {

	private static final Logger logger = LogManager.getLogger(homeSteps.class);
    WebDriver driver;
    private homePage homepage;
    private LaunchPage launchPage;
    private registerPage registerpage;
    private LoginPage loginPage;

    public homeSteps() {
        this.driver = DriverFactory.getDriver();
        this.launchPage = new LaunchPage(driver);
    }

    @Given("The user has to open browser")
    public void the_user_has_to_open_browser() {
        homepage = launchPage.clickGetStarted();
        logger.info("User successfully opened the browser and landed on Home page");
    }

    @When("Landing on the page")
    public void landing_on_the_page() {
        Assert.assertTrue(homepage.isHomePageDisplayed(), "Home page title is not displayed");
    }
    @When("the user enter the correct DS Algo Portal URL")
    public void the_user_enter_the_correct_ds_algo_portal_url() {
//    	homepage = launchPage.clickGetStarted();
//        logger.info("User successfully opened the browser and landed on Home page");;
    }
    @Then("The user able to land on the DS Algo portal with Get Started button")
    public void the_user_able_to_land_on_the_ds_algo_portal_with_get_started_button() {
    	//Assert.assertTrue(homepage.isHomePageDisplayed(), "Home page title is not displayed");
    }

    @Then("The user should be navigated to the Home page, which displays the Register and Sign in links")
    public void the_user_should_be_navigated_to_the_home_page_which_displays_the_register_and_sign_in_links() {
        Assert.assertTrue(homepage.isRegisterLinkDisplayed(), "Register link not displayed");
        Assert.assertTrue(homepage.isSignInLinkDisplayed(), "Sign In link not displayed");
    }
    @Given("The user is on the DS Algo Portal")
    public void the_user_is_on_the_ds_algo_portal() {
    	launchPage = new LaunchPage(driver);
 		homepage = launchPage.clickGetStarted();
         Assert.assertTrue(homepage.isHomePageDisplayed(), "Home page not displayed");
    }
    @Then("The user shouble able to navigated to the Home page, which displays the Register and Sign in links")
    public void the_user_shouble_able_to_navigated_to_the_home_page_which_displays_the_register_and_sign_in_links() {
    	 Assert.assertTrue(homepage.isRegisterLinkDisplayed(), "Register link not displayed");
         Assert.assertTrue(homepage.isSignInLinkDisplayed(), "Sign In link not displayed");
    }

    @Given("The user is on Home page")
    public void the_user_is_on_home_page() {
    	 launchPage = new LaunchPage(driver);
 		homepage = launchPage.clickGetStarted();
         Assert.assertTrue(homepage.isHomePageDisplayed(), "Home page not displayed");
    }

    @When("User clicks the Data Structure dropdown")
    public void user_clicks_the_data_structure_dropdown() {
    	 homepage.openDropdownOnly();
        logger.info("User clicked Data Structure dropdown");
    }

    @Then("The user should be able to see all modules in the dropdown:")
    public void the_user_should_be_able_to_see_all_modules_in_the_dropdown(io.cucumber.datatable.DataTable dataTable) {
    	List<String> expectedModules = dataTable.asList();
        List<String> actualModules = homepage.getAllDropdownModules();
        Assert.assertEquals(expectedModules, actualModules);
    }

    @When("User selects module {string} from the dropdown")
    public void user_selects_module_from_the_dropdown(String moduleName) {
    	homepage.openDropdownOnly();
    	homepage.clickModuleFromDropdown(moduleName);
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
    @When("User clicks all Data Structure modules safely")
    public void user_clicks_all_data_structure_modules_safely() {
    	 homepage.clickAllDropdownModulesSafely();
    }

    @When("User clicks on Register link")
    public void user_clicks_on_register_link() {
        //registerpage = homepage.clickRegisterLink();
    }

    @When("User clicks on Sign In link")
    public void user_clicks_on_sign_in_link() {
       // loginPage = homepage.clickSignInLink();
    }

    @When("User clicks Sign Out if logged in")
    public void user_clicks_sign_out_if_logged_in() {
        if (homepage.isUserLoggedIn()) {
            loginPage = homepage.clickSignOut();
        }
    }
}
