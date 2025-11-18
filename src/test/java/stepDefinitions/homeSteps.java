package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homePage;
import utilities.baseTest;

public class homeSteps {
	
	WebDriver driver;
	homePage homepage;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	static baseTest base = new baseTest();
	
	public homeSteps(baseTest base) {
		//this.base = base;
		
	}
	
	@Given("The user has to open browser")
	public void the_user_has_to_open_browser() {
		
		base.getDriver();	    
	}

	@When("the user enter the correct DS Algo Portal URL")
	public void the_user_enter_the_correct_ds_algo_portal_url() {
		base.getDriver();
	    
	}

	@Then("The user able to land on the DS Algo portal with Get Started button")
	public void the_user_able_to_land_on_the_ds_algo_portal_with_get_started_button() {
		base.getHomepage().openDSAlgoPortal();
	   
	}

	@Given("The user is on the DS Algo Portal")
	public void the_user_is_on_the_ds_algo_portal() {
		base.getHomepage().clickGetStartedbutton();
	    
	}

	@When("Landing on the page")
	public void landing_on_the_page() {
		//homepage = new homePage(driver);
		base.getHomepage().isdisplayedPageTitle();		
	}
	
	@Then("The user shouble able to navigated to the Home page, which displays the Register and Sign in links")
	public void the_user_shouble_able_to_navigated_to_the_home_page_which_displays_the_register_and_sign_in_links() {
				base.getHomepage().isdisplayedReg_Sign_link();
				System.out.println("isDisplayed register and sign in link");
	}

	@Given("The user is on Home page")
	public void the_user_is_on_home_page() {
	    base.getHomepage().isdisplayedPageTitle();
	}

	@When("User click the dropdown button")
	public void user_click_the_dropdown_button() {
		base.getHomepage().clickdropdown_menu();
	   
	}
	
	@Then("The user should able to see six options  Array Linked List Stack Queue Tree Graph in dropdown menu")
	public void the_user_should_able_to_see_six_options_array_linked_list_stack_queue_tree_graph_in_dropdown_menu() {
		//homepage = new homePage(driver);
		   base.getHomepage().clickdropdown_menu();
	}
			
	@When("user click the dropdown")
	public void user_click_the_dropdown() {
	    base.getHomepage().clickdropdown_menu();
	}


	@Then("The user should able to see an Warning message {string}")
	public void the_user_should_able_to_see_an_warning_message(String string) {
	    base.getHomepage().showError_msg();
	}

	@When("the user selects Arrays from the dropdown")
	public void the_user_selects_arrays_from_the_dropdown() {
		base.getHomepage().click_array_dropdown();
	    
	}

	@When("{string}")
	public void string(String string) {
	    base.getHomepage().clickdropdown_menu();
	}

	@And("user click the Get Started button of Data Structure - Induction")
	public void user_click_the_get_started_button_of_data_structure_induction() {
	    base.getHomepage().clickdatastrut_GetStarted_btn();
	}

	@And("click the Get Started button	of Array")
	public void click_the_get_started_button_of_array() {
		base.getHomepage().clickarray_Getstarted_btn();
	    
	}

	@And("user  select Linked List in the dropdown button")
	public void user_select_linked_list_in_the_dropdown_button() {
	   base.getHomepage().click_linkedlist_dropdown();
	}

	@And("user select  Stack in the dropdown button")
	public void user_select_stack_in_the_dropdown_button() {
	    base.getHomepage().click_stack_dropdown();
	}

	@And("user select Queue in the dropdown button")
	public void user_select_queue_in_the_dropdown_button() {
	    base.getHomepage().click_queue_dropdown();
	}

	@And("user select Tree in the dropdown button")
	public void user_select_tree_in_the_dropdown_button() {
	    base.getHomepage().click_tree_dropdown();
	}

	@And("user select Graph in the dropdown button")
	public void user_select_graph_in_the_dropdown_button() {
	   base.getHomepage().click_graph_dropdown();
	}

	@And("user click the Get Started button of Linked List")
	public void user_click_the_get_started_button_of_linked_list() {
	    base.getHomepage().clicklinkdlist_Getstarted_btn();
	}

	@And("user click the Get Started button of Stack")
	public void user_click_the_get_started_button_of_stack() {
	   base.getHomepage().clickstack_Getstarted_btn();
	}

	@And("user click the Get Started button of Queue")
	public void user_click_the_get_started_button_of_queue() {
	   base.getHomepage().clickqueue_Getstarted_btn();
	}

	@And("user click the Get Started button of Tree")
	public void user_click_the_get_started_button_of_tree() {
	    base.getHomepage().clicktree_Getstarted_btn();
	}

	@And("user click the Get Started button of Graph")
	public void user_click_the_get_started_button_of_graph() {
	    base.getHomepage().clickgraph_Getstarted_btn();
	}

}