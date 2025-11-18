package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArrayListPage;
import pageObjects.LoginPage;

import static driver.DriverFactory.getDriver;

public class ArrayList {

	private WebDriver driver = getDriver();
	LoginPage loginpage = new LoginPage(driver);
	ArrayListPage arraylistpage = new ArrayListPage(driver);

	@Given("The user sign in to dsAlgo Portal entering firstname {word} & password {word}")
	public void the_user_sign_in_to_ds_algo_portal_entering_firstname_vara_password_varam(String firstname,
			String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		loginpage.goTo();
		loginpage.loginApplication(firstname, password);
	}

	@Given("The user is in the Home page after Sign in")
	public void the_user_is_in_the_home_page_after_sign_in() {
		arraylistpage.verifyHomePage();
	}

	@When("The user clicks the Get Started button in Array Panel")
	public void the_user_clicks_the_button_in_array_panel() {
		arraylistpage.getstartedArray();
	}

	@Then("The user should be directed to Array Page")
	public void the_user_should_be_directed_to_Array_page() {
		arraylistpage.verifyArrayPage();
	}

	@When("The user clicks Arrays in Python link")
	public void the_user_clicks_arrays_in_python_link() {
		arraylistpage.clickArraysInPython();
	}

	@Then("The user should be redirected to Arrays in Python page")
	public void the_user_should_be_redirected_to_arrays_in_python_page() {
		arraylistpage.verifyArraysInPythonText();
	}

	@When("The user clicks Try Here button in Arrays in Python page")
	public void the_user_clicks_try_here_button_in_arrays_in_python_page() {
		arraylistpage.clickTryHere();
	}

	@Then("The user should be redirected to a page having a try Editor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_a_try_editor_with_a_run_button_to_test() {
		arraylistpage.verifyRunButton();
	}

	@Then("The user should see an error message in alert window")
	public void the_user_should_see_an_error_message_in_alert_window() {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}

	@When("The user writes {string} in Editor and clicks the Run button")
	public void the_user_writes_code_in_editor_and_clicks_the_run_button(String code) {

		arraylistpage.writeCodeAndRun(code);
	}

	@When("The user writes valid code in Editor and clicks the Run Button")
	public void the_user_writes_valid_code_in_editor_and_clicks_the_run_button() {
		arraylistpage.writeCodeAndRun("print(5 + 3)");
	}

	@Then("The user should see output in the console")
	public void the_user_should_see_output_in_the_console() {
		System.out.println(driver.findElement(By.xpath("//pre[@id='output']")).getText());
	}

}
