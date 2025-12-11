package stepDefinitions; 
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver; 
import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import pageObjects.StackPage;
import utilities.ConfigReader;
import utilities.DriverFactory;


public class StackSteps { 
	
	private static final Logger logger = LogManager.getLogger(StackSteps.class);
	private WebDriver driver = DriverFactory.getInstance().getDriver(); 
	private LoginPage loginpage = new LoginPage(driver); 
	private StackPage stackpage = new StackPage(driver);
	

	@Given("The user signs in to DS Algo Portal for stack module with username {string} and password {string}") 
	public void the_user_signs_in_to_ds_algo_portal_for_stack_module_with_username_and_password(String username, String password) { 
		
		
		driver.get(ConfigReader.getProperty("loginUrl"));
		loginpage.enterUsername(ConfigReader.getProperty("username"));
		loginpage.enterPassword(ConfigReader.getProperty("password")); 
		loginpage.clickLoginButton(); 
		
		logger.info("successfully logged into the dsalgo application");
		} 
	
	@Given("The user is in Home page after Sign in")
	public void the_user_is_in_home_page_after_sign_in() {
		stackpage.verifyHomePage();
		driver.get(ConfigReader.getProperty("homeUrl"));
		
	    }
	
	@When("The user clicks the Getting Started button in Stack Panel OR The user select Stack item from the drop down menu") 
	public void the_user_clicks_getting_started_button_or_stack_dropdown() {
	
		stackpage.clickstack_Getstarted_btn();
	
		} 

	@Given("The user is in the Stack page after Sign in")
	public void the_user_is_in_the_stack_page_after_sign_in() {
		
		stackpage.verifyStackPage();
		driver.get(ConfigReader.getProperty("stackUrl"));
			
	   }
	
		
	@Then("The user be directed to Stack Data Structure Page") 
	public void the_user_be_directed_to_stack_data_structure_page() { 
	
		stackpage.verifyStackPage();
		} 
	
	@When("The user clicks Operations in Stack button") 
	public void the_user_clicks_operations_in_stack_button() { 
		stackpage.clickOperationsInStack();
		} 
	@Given("The user is on the Operations in Stack page")
	public void the_user_is_on_the_operations_in_stack_page() {
		stackpage.redirectedOperationinStackPage();
	    stackpage.verifyOperationInStack();
	   
	}

	@Then("The user should be redirected to a page having an try Editor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test() throws InterruptedException {
	  
		stackpage.verifyTryEditorPage();
	}

	
	@Then("The user should be redirected to Operations in Stack page") 
	public void the_user_should_be_redirected_to_operations_in_stack_page() { 
		stackpage.redirectedOperationinStackPage();
		
		}
	
	@When("The user clicks Implementation button") 
		public void the_user_clicks_implementation_button() { 
			stackpage.clickImplementStackLink(); 
			}
	@Given("The user is on the Implementation page")
	public void the_user_is_on_the_implementation_page() {		
	
	    stackpage.verifyImplementInStack();
	}

		
		@Then("The user should be redirected to Implementation page") 
		public void the_user_should_be_redirected_to_implementation_page() { 
			
			stackpage.verifyImplementInStack();
			} 
		
		@When("The user clicks Applications button") 
		public void the_user_clicks_applications_button() { 
			stackpage.clickApplicationStackLink(); 
			
			
			} 
		@Given("The user is on the Applications page")
		public void the_user_is_on_the_applications_page() {
			stackpage.verifyApplicationInStack();
		}

		
		@Then("The user should be redirected to Applications page") 
		public void the_user_should_be_redirected_to_applications_page() { 
						
			}
		
		@When("The user clicks Practice Questions button")
			public void the_user_clicks_practice_questions_button() {
			stackpage.redirectedOperationinStackPage();
				stackpage.clickPracticeQuestions(); 
				}
			
			@Then("The user should be redirected to Practice page") 
			public void the_user_should_be_redirected_to_practice_page() { 
				stackpage.practicePage();
				}
			
				
			
			@When("The user clicks Try Here button")
			public void the_user_clicks_try_here_button() throws InterruptedException {
				stackpage.clickTryhereofoperation(); 
				} 
			
			@Given("The user is in the tryEditor page")
			public void the_user_is_in_the_try_editor_page() { 
				stackpage.verifyTryEditorPage();;
				}
			
			@When("The user clicks Try Here button in Operations in Stack page") 
			public void the_user_clicks_try_here_button_in_operations_in_stack_page() throws InterruptedException { 
               //stackpage.redirectedOperationinStackPage();
				stackpage.clickTryhereofoperation(); 
				}
			
			@When("The user clicks Try Here button in Implementation page") 
			public void the_user_clicks_try_here_button_in_implementation_page() throws InterruptedException { 
				stackpage.verifyImplementInStack();
				stackpage.clickTryHere(); 
				}
			
			
			@When("The user clicks Try Here button in Applications page")
			public void the_user_clicks_try_here_button_in_applications_page() throws InterruptedException { 
				stackpage.verifyApplicationInStack();
				stackpage.clickTryHere(); 
				}

			@When("The user write the valid {string} in Editor and click the Run Button")
			public void the_user_write_the_valid_in_editor_and_click_the_run_button(String code, io.cucumber.datatable.DataTable dataTable) {
				
				List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
				stackpage.enterCodeInEditor(data.get(0).get(code));
				stackpage.enterCodeInEditor(data.get(1).get(code));
				
			}	
			
			
			@When("The user write the invalid {string} in Editor and click the Run Button")
			public void the_user_write_the_invalid_print_hello_in_editor_and_click_the_run_button(String code, io.cucumber.datatable.DataTable dataTable) {
				List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
				stackpage.enterCodeInEditor(data.get(0).get(code));
			    stackpage.enterCodeInEditor(data.get(1).get(code));
			
			    
			}
			
			@When("The user clicks the Run Button without entering the code in the Editor")
			public void the_user_clicks_the_run_button_without_entering_the_code_in_the_editor() {
				stackpage.clickRunButton();

			}
			
			@Then("The user should able to see output in the console") 
			public void the_user_should_able_to_see_output_in_the_console() {
				stackpage.seeOutput();
			}
			
			@Then("The user should able to see an error message in alert window")
			public void the_user_should_able_to_see_an_error_message_in_alert_window() { 
				
				stackpage.errorMessageinAlertWindow();
				
			}
			@Given("I read stack Tryeditor test data for {string}")
			public void i_read_stack_tryeditor_test_data_for(String testId) {
				
				 stackpage.readDataFromExcel(testId);
			}
			
			@When("I enter the phythonTryEditor details from excel")
			public void i_enter_the_try_editor_details_from_excel() {
				stackpage.getDataFromExcel();
			}

			@Then("I should see output")
			public void i_should_see_output() {
				stackpage.seeOutput();
			}

}