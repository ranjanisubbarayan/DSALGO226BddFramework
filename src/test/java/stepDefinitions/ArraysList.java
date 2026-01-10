package stepDefinitions;

import static driver.DriverFactory.getDriver;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArrayListPage;
import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import pageObjects.homePage;

import utilities.DataDriven;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ArraysList {
	
	private static final Logger logger = LogManager.getLogger(ArraysList.class);

	private WebDriver driver;
	LaunchPage launchPage;
	private ArrayListPage arraylistpage;
	private String alertMsg = null;
	
	public ArraysList() {
	    this.driver = getDriver(); 
	    this.launchPage = new LaunchPage(driver);
	    this.arraylistpage = new ArrayListPage(driver);
	}
	@Given("The user sign in to dsAlgo Portal entering firstname {word} & password {word}")
	public void the_user_sign_in_to_ds_algo_portal_entering_firstname_vara_password_varam(String firstname,String password) {
		
	    homePage homepage = launchPage.clickGetStarted();

	    if (!homepage.isUserLoggedIn()) {
	        homepage.clickSignInLinkIfPresent();

	        LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUsername(firstname);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();
	    }
		logger.info("successfully logged into the dsalgo application");
	}

	@Given("The user is in the Home page after Sign in")
	public void the_user_is_in_the_home_page_after_sign_in() {		
		logger.info("successfully logged into the Homepage of the application");		
	}

	@When("The user clicks the Get Started button in Array Panel")
	public void the_user_clicks_the_button_in_array_panel() {
		arraylistpage.getstartedArray();		
		logger.info("successfully logged into the array module");
	}

	@Then("The user should be directed to Array Page")
	public void the_user_should_be_directed_to_Array_page() {
		Assert.assertEquals(
                arraylistpage.getArrayPageText(),
                "Array",
                "User is not on Array Page"
        );
		arraylistpage.clickArraysInPython();
	}

	@When("The user clicks Arrays in Python link")
	public void the_user_clicks_arrays_in_python_link() {
		arraylistpage.clickArraysInPython();
	}

	@Then("The user should be redirected to Arrays in Python page")
	public void the_user_should_be_redirected_to_arrays_in_python_page() {
		 Assert.assertEquals(
	                arraylistpage.getArraysInPythonText(),
	                "Arrays in Python"
	        );
	}

	@When("The user clicks Try Here button in Arrays in Python page")
	public void the_user_clicks_try_here_button_in_arrays_in_python_page() {
		arraylistpage.clickTryHere();
	}

	@Then("The user should be redirected to a page having a try Editor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_a_try_editor_with_a_run_button_to_test() {
		Assert.assertTrue(
                arraylistpage.isRunButtonDisplayed(),
                "Run button is not displayed"
        );
	}

	@Then("The user should see an error message in alert window")
	public void the_user_should_see_an_error_message_in_alert_window() {
		logger.info("An alert message should be shown for Graph Topic invalid execution");
	}

	@When("The user writes {string} in Editor and clicks the Run button")
	public void the_user_writes_code_in_editor_and_clicks_the_run_button(String code) {

		arraylistpage.writeCodeAndRun(code);
		alertMsg = arraylistpage.waitForAlertIfPresent();
		if (alertMsg != null) {
		    System.out.println("Alert detected: " + alertMsg);
		}
		else {
            System.out.println("⚠ No alert detected after clicking Run");
        }
	}

	@When("The user writes valid code in Editor and clicks the Run Button")
	public void the_user_writes_valid_code_in_editor_and_clicks_the_run_button() {
		arraylistpage.writeCodeAndRun("print(5 + 3)");
	}
	@Then("The user writes valid code in Editor and clicks the Run Button in ArrayList Page")
	public void the_user_writes_valid_code_in_editor_and_clicks_the_run_button_in_array_list_page() throws IOException {
		DataDriven d=new utilities.DataDriven();
		ArrayList<String> data=d.getData("ArrayList");
	    arraylistpage.writeAndRunLinkedListCode((String) data.get(1));
	}

	@Then("The user should see output in the console for ArrayList Page")
	public void the_user_should_see_output_in_the_console() {
		logger.info("The user should see output in the console for ArrayList Page"+(driver.findElement(By.xpath("//pre[@id='output']")).getText()));
	}

}
