package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import utilities.DriverFactory;
import utilities.ExcelSheetHandling;
import utilities.LoggerLoad;
import utilities.ScreenshotUtils;

import java.nio.file.Paths;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginSteps {
	     
	private static final Logger logger = LoggerLoad.getLogger(LoginSteps.class);

    WebDriver driver;
    LoginPage loginpage;

    
    public LoginSteps() {
        driver = DriverFactory.getInstance().getDriver();
        loginpage = new LoginPage(driver);
    }

    @Given("user is on the Login page")
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
    	logger.info("Navigating to the Login Page");
        loginpage.openLoginPage();
    }

    @When("the user clicks the {string} link on the Home page")
    public void the_user_clicks_the_link_on_the_home_page(String linkText) {
    	logger.info("Clicking Login button");
            }

    @And("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginpage.clickLoginButton();
    }

    @Then("the Sign in form should be displayed")
    public void the_sign_in_form_should_be_displayed() {
       
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_credentials(String username, String password) {
        loginpage.enterUsername(username);
        loginpage.enterPassword(password);
    }

    @Then("{string} should be displayed")
    public void message_should_be_displayed(String expectedMessage) {

        loginpage.errorMessage(expectedMessage);
    }

    @Given("I read login test data for {string}")
    public void i_read_login_test_data_for(String testId) {
    	loginpage.loginUsingTestData(testId);
    }

    @When("I enter the login details from excel")
    public void i_enter_the_login_details_from_excel() {
        loginpage.openLoginPage();
        loginpage.getDataFromExcel();
    }

    @Then("I should see the ExpectedResult")
    public void i_should_see_the_expected_result(String expectedMessage) {
    	loginpage.errorMessage(expectedMessage);
        
    }
    @Then("I capture screenshot {string}")
    public void i_capture_screenshot(String screenshotName) {
    	logger.info("Capturing screenshot: " + screenshotName);
        ScreenshotUtils.takeScreenshot(DriverFactory.getDriver(), screenshotName);
    }

}
