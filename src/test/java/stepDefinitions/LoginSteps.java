package stepDefinitions;

import io.cucumber.java.en.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.LoginPage;
//import pages.registerPage;
import driver.DriverFactory;

public class LoginSteps {

	WebDriver driver;
    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
    	
    	WebDriver driver = DriverFactory.getDriver(); // initialize driver
	    loginPage = new LoginPage(driver); 
    	loginPage.goTo();
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
    	loginPage.loginApplication(username, password);
   
    }

    @When("clicks on login button")
    public void clicks_on_login_button() {
    	System.out.println("user is logged into the application");

    }

    @Then("user should be navigated to the home page")
    public void user_should_be_navigated_to_the_home_page() {
    	
    	 Assert.assertTrue(loginPage.isLoggedIn(), "User login failed!");

    }

 
   
}
