package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LaunchPage;
import pageObjects.homePage;

public class LauchPageSteps {

    WebDriver driver;
    LaunchPage launchPage;
    homePage homePage;
    
    public LauchPageSteps() {		
		this.driver = DriverFactory.getDriver(); 
		this.launchPage = new LaunchPage(driver);	    	
	}

    @Given("user is on the launch page")
    public void user_is_on_the_launch_page() {
        driver = DriverFactory.getDriver();
        launchPage = new LaunchPage(driver);
    }

    @When("user clicks on Get Started button")
    public void user_clicks_on_get_started_button() {
        homePage = launchPage.clickGetStarted();
    }

    @Then("user should be navigated to the home page")
    public void user_should_be_navigated_to_the_home_page() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }
}
