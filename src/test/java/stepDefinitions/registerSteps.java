package stepDefinitions;


import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.registerPage;
import driver.DriverFactory;

public class registerSteps {
	private static final Logger logger = LogManager.getLogger(registerSteps.class);
	private WebDriver driver;
	private registerPage registerpage;
	

	public registerSteps() {
	
	    this.driver = DriverFactory.getDriver();
	    this.registerpage = new registerPage(driver);

	}

	@Given("The user is on the user Registration page")
	public void the_user_is_on_the_user_registration_page() {
		WebDriver driver = DriverFactory.getDriver(); // initialize driver
	    registerpage = new registerPage(driver); 
	   registerpage.open_DSALGO_registerPage();
	}

	@When("The user clicks the Register link on the Home page")
	public void the_user_clicks_the_register_link_on_the_home_page() {
		
		registerpage.click_register_link();
	    
	}

	@Then("The user navigates to the Register page")
	public void the_user_navigates_to_the_register_page() {
		registerpage.isRegisterPageDisplayed();
	}

	@When("The user clicks the Register button with all fields are empty")
	public void the_user_clicks_the_register_button_with_all_fields_are_empty() {
	    registerpage.clickWithEmptyFields();
	}

	@Then("The Error message Please fill out this field, Shows under the Username box")
	public void the_error_message_please_fill_out_this_field_shows_under_the_username_box() {
	    registerpage.show_ErrorMsg_EmptyUsername();
	}
	
	@When("The user clicks the Register button after entAbcering a {string} and {string} with Password confirmation field is empty")
	public void the_user_clicks_the_register_button_after_ent_abcering_a_and_with_password_confirmation_field_is_empty(String username, String password, io.cucumber.datatable.DataTable dataTable) {
	    
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
	    registerpage.enter_registerUsername(data.get(0).get(username));
	    registerpage.enter_regPassword(data.get(0).get(password));
	    registerpage.clickRegisterButton();
	}
	
	@When("The userclicks the Register button after entering password and password confirmation with the Username field is empty")
	public void the_userclicks_the_register_button_after_entering_password_and_password_confirmation_with_the_username_field_is_empty(io.cucumber.datatable.DataTable dataTable) {
	    
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

	    String password = data.get(0).get("Password");
	    String confirmPassword = data.get(0).get("Password confirmation");

	    registerpage.enter_regPassword(password);
	    registerpage.enter_regPwdConfirm(confirmPassword);
	    registerpage.clickRegisterButton();
	}



	@Then("The Error message {string}, Shows under the Username box")
	public void the_error_message_shows_under_the_username_box(String string) {
	    registerpage.show_ErrorMsg_EmptyUsername();
	}

	@When("The user clicks the Register button after entering a Username with other fields are empty")
	public void the_user_clicks_the_register_button_after_entering_a_username_with_other_fields_are_empty(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		String username = data.get(0).get("Username");
		registerpage.enter_registerUsername(username);
		 registerpage.clickRegisterButton();
	}


	@Then("The error message {string}, Shows under the Password box")
	public void the_error_message_shows_under_the_password_box(String string) {
		registerpage.show_ErrorMsg_EmptyPassword();
	}
	
	@When("The user clicks the Register button after entAbcering a Username and Password with Password confirmation field is empty")
	public void the_user_clicks_the_register_button_after_ent_abcering_a_username_and_password_with_password_confirmation_field_is_empty(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

	    String username = data.get(0).get("Username");
	    String password = data.get(0).get("Password");
	    registerpage.enter_registerUsername(username);
	    registerpage.enter_regPassword(password);
	    registerpage.clickRegisterButton();
	}


	@Then("The error message {string}, Shows under the Password confirmation box")
	public void the_error_message_shows_under_the_password_confirmation_box(String string) {
	    registerpage.show_ErrorMsg_EmptyConfirmPassword();
	    logger.info("Errormessafe for the password confirmation box");
	}
	
	@When("The user clicks the Register button after entering a Username containing space character and invalid symbols other than digits and \\(.\\/+=_@)) with  password and password confirmation")
	public void the_user_clicks_the_register_button_after_entering_a_username_containing_space_character_and_invalid_symbols_other_than_digits_and_with_password_and_password_confirmation(io.cucumber.datatable.DataTable dataTable) {
		 List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		    String username = data.get(0).get("Username");
		    String password = data.get(0).get("Password");
		    String confirmPassword = data.get(0).get("Password confirmation");

		    registerpage.enter_registerUsername(username);
		    registerpage.enter_regPassword(password);
		    registerpage.enter_regPwdConfirm(confirmPassword);
		    registerpage.clickRegisterButton();
	}


	@Then("No {string} shows when entered invalid Username field")
	public void no_shows_when_entered_invalid_username_field(String expectedMessage) {
		 
		    String actualMessage = registerpage.getValidationMessage();
		    System.out.println("Expected message: " + expectedMessage);
	        System.out.println("Actual message:   " + actualMessage);
		    
	}


	
	@When("The user clicks the Register button after entering username with entering a Password and password confirmation consisting only of numeric data")
	public void the_user_clicks_the_register_button_after_entering_username_with_entering_a_password_and_password_confirmation_consisting_only_of_numeric_data(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

	    String username = data.get(0).get("Username");
	    String password = data.get(0).get("Password");
	    String confirmPassword = data.get(0).get("Password confirmation");

	    registerpage.enter_registerUsername(username);
	    registerpage.enter_regPassword(password);
	    registerpage.enter_regPwdConfirm(confirmPassword);
	    registerpage.clickRegisterButton();
	}


	
	@Then("No error message shows when entered invalid Password field")
	public void no_error_message_shows_when_entered_invalid_password_field() {
	
	    String actualMessage = registerpage.getPasswordValidationMessage();
	  
        System.out.println("Actual message:   " + actualMessage);

	}
	
	@When("The user clicks the Register button after entering a {string} with mismatched password in the {string} and {string} fields")
	public void the_user_clicks_the_register_button_after_entering_a_with_mismatched_password_in_the_and_fields(String username, String password, String passwordconfirm) {
		registerpage.enter_registerUsername(username);
	    registerpage.enter_regPassword(password);
	    registerpage.enter_regPwdConfirm(passwordconfirm);
	    registerpage.clickRegisterButton();
	}



	@Then("The user sees the warning message {string}")
	public void the_user_sees_the_warning_message(String string) {
	   
		String actualMessage = registerpage.getPasswordValidationMessage();
		 
	        System.out.println("Actual message:   " + actualMessage);
	}

	@Given("The user is on the user Registeration page")
	public void the_user_is_on_the_user_registeration_page() {
	    
	}
	
	@When("The user clicks the Register button after entering valid Username ,Password and Password confirmation in their respective fields")
	public void the_user_clicks_the_register_button_after_entering_valid_username_password_and_password_confirmation_in_their_respective_fields(io.cucumber.datatable.DataTable dataTable) {

		 registerpage.generate_newUsername();
		    String newusername = registerpage.getGeneratedUsername();

		 
		    List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		    String password = data.get(0).get("Password");
		    String confirmPassword = data.get(0).get("Password confirmation");

		    //registerpage.enter_registerUsername(newusername);
		    registerpage.enter_regPassword(password);
		    registerpage.enter_regPwdConfirm(confirmPassword);
		    registerpage.clickRegisterButton();

		    System.out.println("Generated Username     : " + newusername);
		    System.out.println("Password               : " + password);
		    System.out.println("Password Confirmation  : " + confirmPassword);
		}
	


	@Then("The user goes to DS Algo Home page with the message {string}")
	public void the_user_goes_to_ds_algo_home_page_with_the_message(String string) {
	    registerpage.print_successfullyRegistered();
	}



}
