package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LaunchPage;
import pageObjects.homePage;
import driver.DriverFactory;

public class homeSteps {	
	
	private static final Logger logger = LogManager.getLogger(homeSteps.class);

	WebDriver driver;
	private  homePage homepage;
	LaunchPage launchPage;
	
	public homeSteps() {		
		this.driver = DriverFactory.getDriver(); 
		this.launchPage = new LaunchPage(driver);	    	
	}
	
	@Given("The user has to open browser")
	public void the_user_has_to_open_browser() {	
		
		logger.info("User Successfully opened the browser");
	}
	@When("the user enter the correct DS Algo Portal URL")
	public void the_user_enter_the_correct_ds_algo_portal_url() {	
		logger.info("User Successfully enter the correct DS Algo Portal URL");
	}
	@Then("The user able to land on the DS Algo portal with Get Started button")
	public void the_user_able_to_land_on_the_ds_algo_portal_with_get_started_button() {		
		
		logger.info("User Successfully able to land on the DS Algo portal");
	}

	@Given("The user is on the DS Algo Portal")
	public void the_user_is_on_the_ds_algo_portal() {
		launchPage = new LaunchPage(driver);
		homepage = launchPage.clickGetStarted();
	}

	@When("Landing on the page")
	public void landing_on_the_page() {		
	      Assert.assertTrue(homepage.isPageTitleDisplayed(),"Home page title is not displayed");
	}
	
	@Then("The user shouble able to navigated to the Home page, which displays the Register and Sign in links")
	public void the_user_shouble_able_to_navigated_to_the_home_page_which_displays_the_register_and_sign_in_links() {
		Assert.assertTrue(homepage.isRegAndSignInDisplayed(), "Register and Sign in links not displayed");		   
	}

	@Given("The user is on Home page")
	public void the_user_is_on_home_page() {
		launchPage = new LaunchPage(driver);
		homepage = launchPage.clickGetStarted();	   
	}

	@When("User click the dropdown button")
	public void user_click_the_dropdown_button() {
		homepage.clickDropdownMenu();	   
	}
	
	@Then("The user should able to see six options  Array Linked List Stack Queue Tree Graph in dropdown menu")
	public void the_user_should_able_to_see_six_options_array_linked_list_stack_queue_tree_graph_in_dropdown_menu() {
		homepage.clickDropdownMenu();
	}
			
	@When("user click the dropdown")
	public void user_click_the_dropdown() {
	    homepage.clickDropdownMenu();
	}

	@Then("The user should able to see an Warning message {string}")
	public void the_user_should_able_to_see_an_warning_message(String string) {
	    homepage.showError_msg();
	}

	@When("the user selects Arrays from the dropdown")
	public void the_user_selects_arrays_from_the_dropdown() {	
		homepage.clickArrayDropdown();	    
	}

	@When("user click the Get Started button of Data Structure - Induction")
	public void user_click_the_get_started_button_of_data_structure_induction() {
	    homepage.clickDataStructureGetStarted();
	}
	
	@When("user  select Linked List in the dropdown button")
	public void user_select_linked_list_in_the_dropdown_button() {
	   homepage.clickLinkedListDropdown();
	}

	@When("user select  Stack in the dropdown button")
	public void user_select_stack_in_the_dropdown_button() {
	    homepage.clickStackDropdown();
	}

	@When("user select Queue in the dropdown button")
	public void user_select_queue_in_the_dropdown_button() {
	    homepage.clickQueueDropdown();
	}

	@When("user select Tree in the dropdown button")
	public void user_select_tree_in_the_dropdown_button() {
	    homepage.clickTreeDropdown();
	}

	@When("user select Graph in the dropdown button")
	public void user_select_graph_in_the_dropdown_button() {
	   homepage.clickGraphDropdown();
	}

	@When("user click the Get Started button of Linked List")
	public void user_click_the_get_started_button_of_linked_list() {
	    homepage.clickLinkedListGetStarted();
	}
	
	@When("click the Get Started button of Array")
	public void click_the_get_started_button_of_array() {
	    homepage.clickArrayGetStarted();
	}

	@When("user click the Get Started button of Stack")
	public void user_click_the_get_started_button_of_stack() {
	   homepage.clickStackGetStarted();
	}

	@When("user click the Get Started button of Queue")
	public void user_click_the_get_started_button_of_queue() {
	   homepage.clickQueueGetStarted();
	}

	@When("user click the Get Started button of Tree")
	public void user_click_the_get_started_button_of_tree() {
	    homepage.clickTreeGetStarted();
	}

	@When("user click the Get Started button of Graph")
	public void user_click_the_get_started_button_of_graph() {
	    homepage.clickGraphGetStarted();
	}
}