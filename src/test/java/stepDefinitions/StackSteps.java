package stepDefinitions; 
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; 
import org.testng.Assert; 
import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import pageObjects.StackPage;
import utilities.DriverFactory;
import utilities.ExcelSheetHandling;


public class StackSteps { 
	private WebDriver driver = DriverFactory.getInstance().getDriver(); 
	private LoginPage loginpage = new LoginPage(driver); 
	private StackPage stackpage = new StackPage(driver);
	
	private Map<String, String> stackphyTryEditData;

	
	@Given("The user signs in to DS Algo Portal for stack module with username {string} and password {string}") 
	public void the_user_signs_in_to_ds_algo_portal_for_stack_module_with_username_and_password(String username, String password) { 
		loginpage.openLoginPage(); 
		loginpage.enterUsername(username);
		loginpage.enterPassword(password); 
		loginpage.clickLoginButton(); 
		} 
	
	@Given("The user is in Home page after Sign in")
	public void the_user_is_in_home_page_after_sign_in() {
	    driver.get("https://dsportalapp.herokuapp.com/home");
	}

	@Given("The user is in the Stack page after Sign in")
	public void the_user_is_in_the_stack_page_after_sign_in() {
		stackpage.clickstack_Getstarted_btn();
	    driver.get("https://dsportalapp.herokuapp.com/stack/");
	}
	
	@When("The user clicks the Getting Started button in Stack Panel OR The user select Stack item from the drop down menu") 
	public void the_user_clicks_getting_started_button_or_stack_dropdown() {
	
		} 
	
	@Then("The user be directed to Stack Data Structure Page") 
	public void the_user_be_directed_to_stack_data_structure_page() { 
	
		} 
	
	@When("The user clicks Operations in Stack button") 
	public void the_user_clicks_operations_in_stack_button() { 
		stackpage.clickOperationsInStack();
		} 
	@Given("The user is on the Operations in Stack page")
	public void the_user_is_on_the_operations_in_stack_page() {
	    
	    driver.get("https://dsportalapp.herokuapp.com/stack/operations/"); // replace with actual URL if different
	}

	@Then("The user should be redirected to a page having an try Editor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test() {
	  
	    WebElement runBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
	        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Run']")));
	    Assert.assertTrue(runBtn.isDisplayed(), "Run button is not displayed on the Try Editor page");
	}

	
	@Then("The user should be redirected to Operations in Stack page") 
	public void the_user_should_be_redirected_to_operations_in_stack_page() { 
		
		}
	
	@When("The user clicks Implementation button") 
		public void the_user_clicks_implementation_button() { 
			stackpage.clickImplementStackLink(); 
			}
	@Given("The user is on the Implementation page")
	public void the_user_is_on_the_implementation_page() {
	    driver.get("https://dsportalapp.herokuapp.com/implementation"); 
	}

		
		@Then("The user should be redirected to Implementation page") 
		public void the_user_should_be_redirected_to_implementation_page() { 
			
			stackpage.verifyImplementationPage(); 
			} 
		
		@When("The user clicks Applications button") 
		public void the_user_clicks_applications_button() { 
			stackpage.clickApplicationStackLink(); 
			driver.get("https://dsportalapp.herokuapp.com/applications");
			
			} 
		@Given("The user is on the Applications page")
		public void the_user_is_on_the_applications_page() {
		    driver.get("https://dsportalapp.herokuapp.com/applications");
		}

		
		@Then("The user should be redirected to Applications page") 
		public void the_user_should_be_redirected_to_applications_page() { 
			
			}
		
		@When("The user clicks Practice Questions button")
			public void the_user_clicks_practice_questions_button() {
                 driver.get("https://dsportalapp.herokuapp.com/stack/operations-in-stack/");
				stackpage.clickPracticeQuestions(); 
				}
			
			@Then("The user should be redirected to Practice page") 
			public void the_user_should_be_redirected_to_practice_page() { 
				driver.get("https://dsportalapp.herokuapp.com/stack/practice"); 
				}
			
				
			
			@When("The user clicks Try Here button")
			public void the_user_clicks_try_here_button() throws InterruptedException {
				stackpage.clickTryHere(); 
				} 
			
			@Given("The user is in the tryEditor page")
			public void the_user_is_in_the_try_editor_page() { 
				driver.get("https://dsportalapp.herokuapp.com/tryEditor");
				}
			
			@When("The user clicks Try Here button in Operations in Stack page") 
			public void the_user_clicks_try_here_button_in_operations_in_stack_page() throws InterruptedException { 
                driver.get("https://dsportalapp.herokuapp.com/stack/operations-in-stack/");
				stackpage.clickTryhereofoperation(); 
				}
			
			@When("The user clicks Try Here button in Implementation page") 
			public void the_user_clicks_try_here_button_in_implementation_page() throws InterruptedException { 
				driver.get("https://dsportalapp.herokuapp.com/stack/implementation/");
				stackpage.clickTryHere(); 
				}
			
			
			@When("The user clicks Try Here button in Applications page")
			public void the_user_clicks_try_here_button_in_applications_page() throws InterruptedException { 
				driver.get("https://dsportalapp.herokuapp.com/stack/stack-applications/");
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
				//stackpage.clickRunButton();

			}
			
			@Then("The user should able to see output in the console") 
			public void the_user_should_able_to_see_output_in_the_console() {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    	String output = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output"))).getText();
		        //driver.findElement(loginBtn).click();
				System.out.println(output);
			}
			
			@Then("The user should able to see an error message in alert window")
			public void the_user_should_able_to_see_an_error_message_in_alert_window() { 
				
				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				Alert alert = null;

				try {
				   
				    alert = wait.until(ExpectedConditions.alertIsPresent());
				    
				   
				    String alertMsg = alert.getText();
				    System.out.println("Alert Message: " + alertMsg); 
				    alert.accept();
				   				    
				} catch (TimeoutException e) {
				    
				    System.out.println("No native alert appeared.");
				   
				}
				
			}
			@Given("I read stack Tryeditor test data for {string}")
			public void i_read_stack_tryeditor_test_data_for(String testId) {
				
				 String path = Paths.get("src", "test", "resources", "ExcelSheet", "DsAlgoTestData.xlsx").toString();
				    ExcelSheetHandling excel = new ExcelSheetHandling(path);

				    System.out.println("Reading Excel Sheet: phythonTryEditor, testId=" + testId);

				    stackphyTryEditData = excel.getRowData("phythonTryEditor", testId);

				    if (stackphyTryEditData == null || stackphyTryEditData.isEmpty()) {
				        throw new RuntimeException("Excel returned EMPTY/NULL data for sheet 'phythonTryEditor' and testId: " + testId);
				    }

				    System.out.println("Loaded Excel row: " + stackphyTryEditData);
			}
			
			@When("I enter the phythonTryEditor details from excel")
			public void i_enter_the_try_editor_details_from_excel() {
				stackpage.openTryEditor();

			    String valid = stackphyTryEditData.get("Valid Input");
			    String invalid = stackphyTryEditData.get("Invalid Input");
			    
			    if (valid != null && !valid.isEmpty()) {
			        stackpage.enterCodeInEditor(valid);
			    }
			    else if (invalid != null && !invalid.isEmpty()) {
			        stackpage.enterCodeInEditor(invalid);
			    }
			    else {
			        throw new RuntimeException("Both Valid Input and Invalid Input columns are empty in Excel!");
			    }
			}

			@Then("I should see output")
			public void i_should_see_output() {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    	String output = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output"))).getText();
		       	System.out.println(output);
			}

}