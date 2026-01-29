package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import pageObjects.homePage;
import pageObjects.registerPage;
import utilities.ElementUtils;
import driver.DriverFactory;

public class registerSteps {
	
	    private static final Logger logger = LogManager.getLogger(registerSteps.class);
	    private WebDriver driver;
	    private registerPage registerpage;
	    private LaunchPage launchPage;
        private homePage homepage;
        LoginPage loginpage;
	    
	    public registerSteps() {
	        this.driver = DriverFactory.getDriver();
	        this.launchPage = new LaunchPage(driver);
	        this.registerpage = new registerPage(driver);
	    }

	//@Given("The user is on the user Registeration page")
	@Given("The user is on the user Registration page")
	public void the_user_is_on_the_user_registration_page() {
		 homepage = launchPage.clickGetStarted(); 
		 loginpage = homepage.clickSignOut();  
		 registerpage = homepage.clickRegisterLink(); 
        Assert.assertTrue(registerpage.isRegisterPageDisplayed(), "Register page is not displayed");    
	}

	@When("The user clicks the Register link on the Home page")
	public void the_user_clicks_the_register_link_on_the_home_page() {
		
		logger.info("Successfully logged into the dsAlgo Home Page");
	}

	@Then("The user navigates to the Register page")
	public void the_user_navigates_to_the_register_page() {
		String actualpageTitle = ElementUtils.getCurrentTitle();
    	String expectedTitle = "Registration";
    	System.out.println("Page Title:"+ actualpageTitle);
    	Assert.assertEquals(actualpageTitle, expectedTitle, 
    		    "Page title mismatch!");
        logger.info("User successfully landed on Registration page");
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
	public void the_user_clicks_the_register_button_after_entering_a_and_with_password_confirmation_field_is_empty(String username, String password, io.cucumber.datatable.DataTable dataTable) {
	    
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
	
	@When("The user clicks the Register button after entering a Username and Password with Password confirmation field is empty")
	public void the_user_clicks_the_register_button_after_ent_ering_a_username_and_password_with_password_confirmation_field_is_empty(io.cucumber.datatable.DataTable dataTable) {
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
	
	@When("The user clicks the Register button after entering valid Username ,Password and Password confirmation in their respective fields")
	public void the_user_clicks_the_register_button_after_entering_valid_username_password_and_password_confirmation_in_their_respective_fields(io.cucumber.datatable.DataTable dataTable) {

		    registerpage.generate_newUsername();
		    String newusername = registerpage.getGeneratedUsername();
		 
		    List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		    String password = data.get(0).get("Password");
		    String confirmPassword = data.get(0).get("Password confirmation");
		    
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
	@When("the user generates a new username and writes it into Excel for {string}")
	public void the_user_generates_a_new_username_and_writes_it_into_excel_for(String string) {
	    registerpage.addNewUsernameToRegisterDataSheet();
	}

	@When("the user reads register test data for {string} from Excel")
	public void the_user_reads_register_test_data_for_from_excel(String testId) {
		 registerpage.registerUsingTestData(testId);
	}

	@When("the user submits the Register form using Excel data")
	public void the_user_submits_the_register_form_using_excel_data() {
	    registerpage.getregisterDataFromExcel();
	}

	 @Then("the user should see the ExpectedResult")
	    public void the_user_should_see_the_Expected_Result() {
		String expectedResult = registerpage.getregisterExpectedResult().trim();

        switch (expectedResult) {
            case "You are logged in":
                Assert.assertTrue(registerpage.isRegisterPageDisplayed(),
                    "Expected register page to be displayed, but it was NOT!");
                break;

            case "Please fill out this field":
                String usernameMsg = registerpage.getValidationMessage();
                String passwordMsg = registerpage.getPasswordValidationMessage();
                String confirmpasswordMsg = registerpage.getConfirmPasswordValidationMessage();
                Assert.assertTrue(!usernameMsg.isEmpty() || !passwordMsg.isEmpty() || !confirmpasswordMsg.isEmpty(),
                    "Expected browser validation message but found none.");
                break;

            default: 
            	String alertMessage = registerpage.getAlertMessage();
                Assert.assertTrue(
                    alertMessage.contains(expectedResult),
                    "Expected alert message: [" + expectedResult + "] but got: [" + alertMessage + "]");
                break;
        }        
	}
	 @Then("Register page should load within {string} seconds")
		public void register_page_should_load_within_seconds(String seconds) {
			long maxTime = Long.parseLong(seconds);
	        long start = System.currentTimeMillis();

	        driver.navigate().refresh();

	        long end = System.currentTimeMillis();
	        long loadTime = (end - start) / 1000;
	        Assert.assertTrue(loadTime <= maxTime, "Register page load exceeded " + maxTime + "s. Actual: " + loadTime + "s");
		}

		@Then("all input fields and submit button should be visible")
		public void all_input_fields_and_submit_button_should_be_visible() {
			Assert.assertTrue(registerpage.isUsernameFieldVisible(), "Username field is not visible");
			Assert.assertTrue(registerpage.isPasswordFieldVisible(), "Password field is not visible");
			Assert.assertTrue(registerpage.isConfirmPasswordFieldVisible(), "Confirm Password field is not visible");
			Assert.assertTrue(registerpage.isRegisterButtonVisible(), "Register button is not visible");

		}

		@Then("Register page should be loaded using HTTPS")
		public void register_page_should_be_loaded_using_https() {
			String url = driver.getCurrentUrl();
	        Assert.assertTrue(url.startsWith("https://"), "Register page is not loaded over HTTPS");
			
		}

		@Then("user should be able to navigate Register page using keyboard")
		public void user_should_be_able_to_navigate_register_page_using_keyboard() throws InterruptedException {
			registerpage.register_username.sendKeys(Keys.TAB);
	        Thread.sleep(200);
	        String activeElementId = driver.switchTo().activeElement().getAttribute("id");
	        Assert.assertEquals(activeElementId, "id_password1", "Keyboard navigation failed to move to password field");

	      
	        driver.switchTo().activeElement().sendKeys(Keys.TAB);
	        Thread.sleep(200);
	        activeElementId = driver.switchTo().activeElement().getAttribute("id");
	        Assert.assertEquals(activeElementId, "id_password2", "Keyboard navigation failed to move to confirm password field");

	  
	        driver.switchTo().activeElement().sendKeys(Keys.TAB);
	        Thread.sleep(200);
	        WebElement active = driver.switchTo().activeElement();
	        String activeValue = active.getAttribute("value"); 
	        Assert.assertEquals(activeValue, "Register", "Keyboard navigation failed to move to register button");
		}

		@When("user refreshes the Register page")
		public void user_refreshes_the_register_page() {
			driver.navigate().refresh();
		}

		@Then("Register page should load without errors")
		public void register_page_should_load_without_errors() {
			String pageSource = driver.getPageSource();
	        Assert.assertFalse(pageSource.contains("error"), "Page contains 'error'");
	        Assert.assertFalse(pageSource.contains("404"), "Page contains '404'");
	        Assert.assertFalse(pageSource.contains("500"), "Page contains '500'");
		}

}
