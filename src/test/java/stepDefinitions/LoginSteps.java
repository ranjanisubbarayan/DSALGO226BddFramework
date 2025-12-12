package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import driver.DriverFactory;
import utilities.ExcelSheetHandling;

import java.nio.file.Paths;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginSteps {

    WebDriver driver;
    LoginPage loginpage;

    private Map<String, String> loginData;

    public LoginSteps() {
        driver = DriverFactory.getDriver();
        loginpage = new LoginPage(driver);
    }

    @Given("user is on the Login page")
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        loginpage.openLoginPage();
    }

    @When("the user clicks the {string} link on the Home page")
    public void the_user_clicks_the_link_on_the_home_page(String linkText) {
        loginpage.clickSignInLink();
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
                Assert.assertTrue(loginpage.isHomePageDisplayed(),
                        "Home page should be displayed but was NOT!");
                break;

            case "Please fill out this field":
                
                String usernameFieldMsg = loginpage.getUsernameValidationMessage();
                String passwordFieldMsg = loginpage.getPasswordValidationMessage();

                Assert.assertTrue(!usernameFieldMsg.isEmpty() || !passwordFieldMsg.isEmpty(),
                        "Expected HTML required-field validation message!");
                break;

            default:
                
                String alertMsg = loginpage.getAlertMessage();
                Assert.assertTrue(alertMsg.contains("Invalid"),
                        "Expected invalid login message, but got: " + alertMsg);
                break;
        }
    }

    @Given("I read login test data for {string}")
    public void i_read_login_test_data_for(String testId) {
        String path = Paths.get("src", "test", "resources","ExcelSheet", "DsAlgoTestData.xlsx").toString();
        ExcelSheetHandling excel = new ExcelSheetHandling(path);
        loginData = excel.getRowData("Login", testId);
    }

    @When("I enter the login details from excel")
    public void i_enter_the_login_details_from_excel() {
        loginpage.openLoginPage();
        loginpage.enterUsername(loginData.get("username"));
        loginpage.enterPassword(loginData.get("password"));
        loginpage.clickLoginButton();
    }

    @Then("I should see the ExpectedResult")
    public void i_should_see_the_expected_result() {
        
    }
}
