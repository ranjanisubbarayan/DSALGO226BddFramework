package stepDefinitions;

import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import pageObjects.homePage;
import utilities.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
    private WebDriver driver;
    private LoginPage loginpage;
    private LaunchPage launchPage;
    private homePage homepage;
    
    public LoginSteps() {
    	this.driver = DriverFactory.getDriver();
        this.launchPage = new LaunchPage(driver);
    }
    

    @Given("user is on the Login page")
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
    	homepage = launchPage.clickGetStarted(); 
    	loginpage = homepage.ClickSignOut();       
    	loginpage = homepage.clickSignInLink();
    }

    @When("the user clicks the {string} link on the Home page")
    public void the_user_clicks_the_link_on_the_home_page(String linkText) {    
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
    	  switch (expectedMessage) {
          case "Home page displayed":
              Assert.assertTrue(loginpage.isHomePageDisplayed(), "Home page should be displayed but was NOT!");
              break;

          case "Please fill out this field":
              String usernameMsg = loginpage.getUsernameValidationMessage();
              String passwordMsg = loginpage.getPasswordValidationMessage();
              Assert.assertTrue(!usernameMsg.isEmpty() || !passwordMsg.isEmpty(), 
                                "Expected browser validation message but found none.");
              break;

          default:
          String alert = loginpage.getAlertMessage();
          Assert.assertTrue(alert.contains("Invalid"), 
                            "Expected invalid login message, but got: " + alert);
          break;
  }
}
   

    @Given("I read login test data for {string}")
    public void i_read_login_test_data_for(String testId) {
    	if (loginpage == null) {
            homePage homepage = launchPage.clickGetStarted();
            loginpage = homepage.clickSignInLink();
        }
        loginpage.loginUsingTestData(testId);
    }

    @When("I enter the login details from excel")
    public void i_enter_the_login_details_from_excel() {
        loginpage.getDataFromExcel();
    }

    @Then("I should see the ExpectedResult")
    public void i_should_see_the_expected_result() {
        
    }
    @Then("I capture screenshot {string}")
    public void i_capture_screenshot(String screenshotName) {
        ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), screenshotName);
    }

}
