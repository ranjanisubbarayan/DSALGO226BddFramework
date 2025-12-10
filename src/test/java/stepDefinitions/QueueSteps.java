package stepDefinitions;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
//import pageObjects.LoginPage;
import pageObjects.QueuePage;
import utilities.ConfigReader;
//import utilities.DriverFactory;
//import utilities.ExcelSheetHandling;
import utilities.DriverFactory;
import utilities.ExcelSheetHandling;

public class QueueSteps {
	

	private WebDriver driver = DriverFactory.getInstance().getDriver(); 
	private LoginPage loginpage = new LoginPage(driver); 
	private QueuePage queuepage = new QueuePage(driver);
	
	private Map<String, String> queuephyTryEditData;
	
	

	
	@Given("The user signs in to DS Algo Portal for QUEUE module with username {string} and password {string}")
	public void the_user_signs_in_to_ds_algo_portal_for_queue_module_with_username_and_password(String username, String password) {
		driver.get(ConfigReader.getProperty("loginUrl"));
		loginpage.enterUsername(ConfigReader.getProperty("username"));
		loginpage.enterPassword(ConfigReader.getProperty("password")); 
		loginpage.clickLoginButton(); 
	}

	@Given("The user clicks on {string} button in Queue module")
	public void the_user_clicks_on_button_in_queue_module(String action) {
	   
		queuepage.click_Queue_Get_Started_button();
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	}

	@Given("The user is on the {string} in Queuepage")
	public void the_user_is_on_the_in_queuepage(String pageName) {
		
		switch(pageName) {

	    case "Implementation of Queue in Python":
	        driver.get("https://dsportalapp.herokuapp.com/queue/implementation/");
	        queuepage.waitForElementAndScroll(queuepage.implementationPythonHeading, 20);
	        Assert.assertTrue(queuepage.implementationPythonHeading.isDisplayed(),
	                          "Page heading not found!");
	        break;

	    case "tryEditor":
	        driver.get("https://dsportalapp.herokuapp.com/tryEditor");
	        queuepage.waitForElementAndScroll(queuepage.runBtn, 30);
	        Assert.assertTrue(queuepage.runBtn.isDisplayed(),
	                          "Run button not found!");
	        break;
	}

	}

	@When("The user clicks {string} button in Queuepage")
	public void the_user_clicks_button_in_queuepage(String action) {
		 queuepage.clickAction(action);
	}

	@When("If applicable, user enters {string} in the editor in Queuepage")
	public void if_applicable_user_enters_in_the_editor_in_queuepage(String code) {
		if (!code.trim().isEmpty()) {
            queuepage.enterCodeInEditor(code);
        }
	    
	}

	@Then("The user should see {string} in Queuepage")
	public void the_user_should_see_in_queuepage(String expected) throws InterruptedException {
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
	@Given("I read queue TryEditor test data for {string}")
	public void i_read_queue_try_editor_test_data_for(String testId) {
		 String path = Paths.get("src", "test", "resources", "ExcelSheet", "DsAlgoTestData.xlsx").toString();
		    ExcelSheetHandling excel = new ExcelSheetHandling(path);

		    System.out.println("Reading Excel Sheet: phythonTryEditor, testId=" + testId);

		    queuephyTryEditData = excel.getRowData("phythonTryEditor", testId);

		    if (queuephyTryEditData == null || queuephyTryEditData.isEmpty()) {
		        throw new RuntimeException("Excel returned EMPTY/NULL data for sheet 'phythonTryEditor' and testId: " + testId);
		    }

		    System.out.println("Loaded Excel row: " + queuephyTryEditData);
	}

	@When("I enter the pythonTryEditor details from excel")
	public void i_enter_the_python_try_editor_details_from_excel() {
		queuepage.openTryEditor();

	    String valid = queuephyTryEditData.get("Valid Input");
	    String invalid = queuephyTryEditData.get("Invalid Input");
	    
	    if (valid != null && !valid.isEmpty()) {
	        queuepage.enterCodeInEditor(valid);
	    }
	    else if (invalid != null && !invalid.isEmpty()) {
	        queuepage.enterCodeInEditor(invalid);
	    }
	    else {
	        throw new RuntimeException("Both Valid Input and Invalid Input columns are empty in Excel!");
	    }
	}
	@Then("I should see Queue output")
	public void i_should_see_queue_output() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	String output = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output"))).getText();
       	System.out.println(output);
	}

}
