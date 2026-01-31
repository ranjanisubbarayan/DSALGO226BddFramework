
package stepDefinitions;

import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import pageObjects.homePage;
import utilities.ElementUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private static final Logger logger = LogManager.getLogger(LoginSteps.class);
    private WebDriver driver;
    private LoginPage loginpage;
    private LaunchPage launchPage;
    private homePage homepage;
    
    public LoginSteps() {
    	this.driver = DriverFactory.getDriver();
        this.launchPage = new LaunchPage(driver);
    }
   
    @Given("user is on the Login page")
    public void user_is_on_the_login_page() {
    	homepage = launchPage.clickGetStarted(); 
    	loginpage = homepage.clickSignOut();       
    	
    }

    @When("the user clicks the {string} link on the Home page")
    public void the_user_clicks_the_link_on_the_home_page(String linkText) {    
    	if (homepage == null) {
	        homepage = new homePage(DriverFactory.getDriver());
	    }

	    if (linkText.equalsIgnoreCase("Sign in")) {
	        loginpage = homepage.clickSignInLink();
	    }
            }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginpage.clickLoginButton();
    }

    @Then("the Sign in form should be displayed")
    public void the_sign_in_form_should_be_displayed() {  
    	String actualpageTitle = ElementUtils.getCurrentTitle();
    	String expectedTitle = "Login";
    	System.out.println("Page Title:"+ actualpageTitle);
    	Assert.assertEquals(actualpageTitle, expectedTitle, 
    		    "Page title mismatch!");
        logger.info("User successfully landed on Login page");
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_credentials(String username, String password) {
    	launchPage = new LaunchPage(driver);
 		loginpage = homepage.clickSignInLink();
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
    	String expectedResult = loginpage.getExpectedResult().trim();

        switch (expectedResult) {
            case "You are logged in":
                Assert.assertTrue(loginpage.isHomePageDisplayed(),
                    "Expected Home page to be displayed, but it was NOT!");
                break;

            case "Please fill out this field":
                String usernameMsg = loginpage.getUsernameValidationMessage();
                String passwordMsg = loginpage.getPasswordValidationMessage();
                Assert.assertTrue(!usernameMsg.isEmpty() || !passwordMsg.isEmpty(),
                    "Expected browser validation message but found none.");
                break;

            default: 
                String alert = loginpage.getAlertMessage();
                Assert.assertTrue(alert.contains(expectedResult),
                    "Expected alert message: [" + expectedResult + "] but got: [" + alert + "]");
                break;
        }        
        
    }

    @Then("Login page should load within {string} seconds")
    public void login_page_should_load_within_seconds(String seconds) {
    	loginpage = homepage.clickSignInLink();
    	 long maxTime = Long.parseLong(seconds);
         long start = System.currentTimeMillis();
         driver.navigate().refresh(); 
         long end = System.currentTimeMillis();
         long loadTime = (end - start) / 1000;

         Assert.assertTrue(loadTime <= maxTime,
                 "Page load exceeded " + maxTime + " seconds. Actual: " + loadTime + " seconds");
         Assert.assertTrue(loginpage.isPageLoadedCompletely(), "Page did not fully load "); }

    @Then("all login fields and buttons should be visible")
    public void all_login_fields_and_buttons_should_be_visible() {
    	loginpage = homepage.clickSignInLink();
    	Assert.assertTrue(loginpage.loginUsername.isDisplayed(), "Username field is not visible");
        Assert.assertTrue(loginpage.loginPassword.isDisplayed(), "Password field is not visible");
        Assert.assertTrue(loginpage.loginBtn.isDisplayed(), "Login button is not visible");
    }

    @Then("Login page should be loaded using HTTPS")
    public void login_page_should_be_loaded_using_https() {
    	loginpage = homepage.clickSignInLink();
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.startsWith("https://"), "Page is not loaded over HTTPS");
    }

    @Then("user should be able to navigate Login page using keyboard")
    public void user_should_be_able_to_navigate_login_page_using_keyboard() throws InterruptedException {
    	loginpage = homepage.clickSignInLink();
    	loginpage.loginUsername.sendKeys(Keys.TAB);
    	Thread.sleep(200);
        String activeElementId = driver.switchTo().activeElement().getAttribute("id");
        Assert.assertEquals(activeElementId, "id_password", "Keyboard navigation failed to move to password field");

        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(200);
        activeElementId = driver.switchTo().activeElement().getAttribute("value");
        Assert.assertEquals(activeElementId, "Login", "Keyboard navigation failed to move to login button");
    }

    @When("user refreshes the Login page")
    public void user_refreshes_the_login_page() {
        driver.navigate().refresh();
    }

    @Then("Login page should load without errors")
    public void login_page_should_load_without_errors() {
        String pageSource = driver.getPageSource();
        Assert.assertFalse(pageSource.contains("error"));
        Assert.assertFalse(pageSource.contains("404"));
        Assert.assertFalse(pageSource.contains("500"));
    }
}
