package stepDefinitions;

import static driver.DriverFactory.getDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import pageObjects.StackPage;
import pageObjects.homePage;

public class NFStackStep {
    
    long startTime;
    private WebDriver driver;
    LaunchPage launchPage;
    private StackPage stackPage;
     LoginPage loginpage;
     homePage homepage;
   

    public NFStackStep() {
    	this.driver = getDriver();
        this.launchPage = new LaunchPage(driver);
        this.stackPage = new StackPage(driver);  
    }	
    
    @Given("user is on Stack page")
    public void user_is_on_stack_page() {
    	String username = "TestNinja";
		String password = "C5Mha6FkdSAVEN@";
		homePage homepage = launchPage.clickGetStarted();

 	    if (!homepage.isUserLoggedIn()) {
 	        homepage.clickSignInLinkIfPresent();
 	        LoginPage loginPage = new LoginPage(driver);
             loginPage.enterUsername(username);
             loginPage.enterPassword(password);
             loginPage.clickLoginButton();
 	   	    }
 	   stackPage.clickStackGetStarted();
        Assert.assertTrue(stackPage.isStackPageDisplayed());
    }

  
    @Then("Stack page should load within {string} seconds")
    public void stack_page_should_load_within_seconds(String seconds) {
        long maxTime = Long.parseLong(seconds) * 1000;

        long loadTime = measureStackPageLoadTime();

        Assert.assertTrue(loadTime <= maxTime,
                "Stack page load time exceeded limit: " + loadTime + " seconds");
    }

    private long measureStackPageLoadTime() {
        long start = System.currentTimeMillis();
        stackPage.isStackPageDisplayed();
        long end = System.currentTimeMillis();
        return end - start;
    }

    @Then("all main stack operations buttons should be visible")
    public void all_main_stack_operations_buttons_should_be_visible() {
    	WebDriver driver = DriverFactory.getDriver();

        Assert.assertTrue(
            driver.findElement(By.xpath("//a[normalize-space()='Operations in Stack']")).isDisplayed(),
            "Operations in Stack not visible");

        Assert.assertTrue(
            driver.findElement(By.xpath("//a[normalize-space()='Implementation']")).isDisplayed(),
            "Implementation In not visible");
        Assert.assertTrue(
                driver.findElement(By.xpath("//a[normalize-space()='Applications']")).isDisplayed(),
                "Application In not visible");
        
    }

   
    @Then("Stack page should be loaded using HTTPS")
    public void stack_page_should_be_loaded_using_https() {
    	String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue(
	            currentUrl.startsWith("https"),
	            "Stack page is NOT loaded using HTTPS. URL: " + currentUrl
	    );
    }

  
    @When("user refreshes the Stack page")
    public void user_refreshes_the_stack_page() {
        driver.navigate().refresh();
    }

    @Then("Stack page should load without errors")
    public void stack_page_should_load_without_errors() {
    	Assert.assertNotNull(
	            driver.getTitle(),
	            "Stack page title is NULL after refresh"
	    );

	    System.out.println("Stack Page Title after refresh: " + driver.getTitle());
    }
}
