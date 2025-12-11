package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class homeSteps {
	
	private WebDriver driver = DriverFactory.getInstance().getDriver(); 
	private homePage homepage = new homePage(driver); 
	
	
	
	@Given("The user has to open browser")
	public void the_user_has_to_open_browser() {
		driver.get(ConfigReader.getProperty("baseUrl"));
		    
	}

	@When("the user enter the correct DS Algo Portal URL")
	public void the_user_enter_the_correct_ds_algo_portal_url() {
		
		homepage.openDSAlgoPortal();
	    
	}

	@Then("The user able to land on the DS Algo portal with Get Started button")
	public void the_user_able_to_land_on_the_ds_algo_portal_with_get_started_button() {
		
	   
	}

	@Given("The user is on the DS Algo Portal")
	public void the_user_is_on_the_ds_algo_portal() {
		homepage.clickGetStartedbutton();
	    
	}

	@When("Landing on the page")
	public void landing_on_the_page() {
		//homepage = new homePage(driver);
	      homepage.isdisplayedPageTitle();		
	}
	
	@Then("The user shouble able to navigated to the Home page, which displays the Register and Sign in links")
	public void the_user_shouble_able_to_navigated_to_the_home_page_which_displays_the_register_and_sign_in_links() {
				homepage.isdisplayedReg_Sign_link();
				System.out.println("isDisplayed register and sign in link");
	}

	@Given("The user is on Home page")
	public void the_user_is_on_home_page() {
	    homepage.isdisplayedPageTitle();
	}

	@When("User click the dropdown button")
	public void user_click_the_dropdown_button() {
		homepage.clickdropdown_menu();
	   
	}
	
	@Then("The user should able to see six options  Array Linked List Stack Queue Tree Graph in dropdown menu")
	public void the_user_should_able_to_see_six_options_array_linked_list_stack_queue_tree_graph_in_dropdown_menu() {
		//homepage = new homePage(driver);
		   homepage.clickdropdown_menu();
	}
			
	@When("user click the dropdown")
	public void user_click_the_dropdown() {
	    homepage.clickdropdown_menu();
	}


	@Then("The user should able to see an Warning message {string}")
	public void the_user_should_able_to_see_an_warning_message(String string) {
	    homepage.showError_msg();
	}

	@When("the user selects Arrays from the dropdown")
	public void the_user_selects_arrays_from_the_dropdown() {
		homepage.click_array_dropdown();
	    
	}

	@When("user click the Get Started button of Data Structure - Induction")
	public void user_click_the_get_started_button_of_data_structure_induction() {
	    homepage.clickdatastrut_GetStarted_btn();
	}

	
	@When("user  select Linked List in the dropdown button")
	public void user_select_linked_list_in_the_dropdown_button() {
	   homepage.click_linkedlist_dropdown();
	}

	@When("user select  Stack in the dropdown button")
	public void user_select_stack_in_the_dropdown_button() {
	    homepage.click_stack_dropdown();
	}

	@When("user select Queue in the dropdown button")
	public void user_select_queue_in_the_dropdown_button() {
	    homepage.click_queue_dropdown();
	}

	@When("user select Tree in the dropdown button")
	public void user_select_tree_in_the_dropdown_button() {
	    homepage.click_tree_dropdown();
	}

	@When("user select Graph in the dropdown button")
	public void user_select_graph_in_the_dropdown_button() {
	   homepage.click_graph_dropdown();
	}

	@When("user click the Get Started button of Linked List")
	public void user_click_the_get_started_button_of_linked_list() {
	    homepage.clicklinkdlist_Getstarted_btn();
	}
	@When("click the Get Started button	of Array")
	@When("click the Get Started button of Array")
	public void click_the_get_started_button_of_array() {
	    homepage.clickarray_Getstarted_btn();
	}

	@When("user click the Get Started button of Stack")
	public void user_click_the_get_started_button_of_stack() {
	   homepage.clickstack_Getstarted_btn();
	}

	@When("user click the Get Started button of Queue")
	public void user_click_the_get_started_button_of_queue() {
	   homepage.clickqueue_Getstarted_btn();
	}

	@When("user click the Get Started button of Tree")
	public void user_click_the_get_started_button_of_tree() {
	    homepage.clicktree_Getstarted_btn();
	}

	@When("user click the Get Started button of Graph")
	public void user_click_the_get_started_button_of_graph() {
	    homepage.clickgraph_Getstarted_btn();
	}

}