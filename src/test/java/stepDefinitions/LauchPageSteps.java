package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.List;
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
    @When("user enters the correct DS Algo portal URL")
    public void user_enters_the_correct_ds_algo_portal_url() {
        launchPage.openLaunchPage();
    }
    
    @Then("user should be on the DS Algo Portal page with {string} title")
    public void user_should_be_on_ds_algo_portal_page_with_title(String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }
    
    @Then("user should be able to see the content text on the Launch page")
    public void user_should_be_able_to_see_the_content_text_on_launch_page(io.cucumber.datatable.DataTable dataTable) {
    	List<String> contentTexts = dataTable.asList();
    	for (String text : contentTexts) {
    	    Assert.assertTrue(
    	        launchPage.isContentTextDisplayed(text),
    	        "Content text not visible: " + text
    	    );
    	}
    }
    
    @Then("user should be able to see 1 button on the Launch page")
    public void user_should_be_able_to_see_one_button_on_launch_page() {
        Assert.assertEquals(launchPage.getButtonCount(), 1);
    }

    @Then("user should be able to see button")
    public void user_should_be_able_to_see_button() {
        Assert.assertTrue(launchPage.isGetStartedButtonDisplayed());
    }

    @Then("user should be able to see button with text {string}")
    public void user_should_be_able_to_see_button_with_text(String text) {
        Assert.assertEquals(launchPage.getGetStartedButtonText(), text);
    }
    
    //
    @When("user clicks on Get Started button")
    public void user_clicks_on_get_started_button() {
        homePage = launchPage.clickGetStarted();
    }
    
    @Then("User should navigate to home page with {string} title")
    public void user_should_navigate_to_home_page_with_title(String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }
    

  
    @Then("user should be navigated to the home page")
    public void user_should_be_navigated_to_the_home_page() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }
}
