package stepDefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import pageObjects.homePage;
import pageObjects.registerPage;

public class NFRegisterStep {
	
	private WebDriver driver;
    private registerPage registerpage;
    private LaunchPage launchPage;
    private homePage homepage;
    LoginPage loginpage;
    
    public NFRegisterStep() {
        this.driver = DriverFactory.getDriver();
        this.launchPage = new LaunchPage(driver);
        this.registerpage = new registerPage(driver);
    }
	
	@Given("user is on Register page")
	public void user_is_on_register_page() {
		 homepage = launchPage.clickGetStarted(); 
		 loginpage = homepage.clickSignOut();  
		 registerpage = homepage.clickRegisterLink();
				
        Assert.assertTrue(registerpage.isRegisterPageDisplayed(), "Register page is not displayed"); 
	}

	@Then("Register page should load within {string} seconds")
	public void register_page_should_load_within_seconds(String seconds) {
		long maxTime = Long.parseLong(seconds);
        long start = System.currentTimeMillis();

        driver.navigate().refresh();

        long end = System.currentTimeMillis();
        long loadTime = (end - start) / 1000;
        Assert.assertTrue(loadTime <= maxTime, "Register page load exceeded " + maxTime + "s. Actual: " + loadTime + "s");
	}

	@Then("all input fields and submit button should be visible")
	public void all_input_fields_and_submit_button_should_be_visible() {
		Assert.assertTrue(registerpage.isUsernameFieldVisible(), "Username field is not visible");
		Assert.assertTrue(registerpage.isPasswordFieldVisible(), "Password field is not visible");
		Assert.assertTrue(registerpage.isConfirmPasswordFieldVisible(), "Confirm Password field is not visible");
		Assert.assertTrue(registerpage.isRegisterButtonVisible(), "Register button is not visible");

	}

	@Then("Register page should be loaded using HTTPS")
	public void register_page_should_be_loaded_using_https() {
		String url = driver.getCurrentUrl();
        Assert.assertTrue(url.startsWith("https://"), "Register page is not loaded over HTTPS");
		
	}

	@Then("user should be able to navigate Register page using keyboard")
	public void user_should_be_able_to_navigate_register_page_using_keyboard() throws InterruptedException {
		registerpage.register_username.sendKeys(Keys.TAB);
        Thread.sleep(200);
        String activeElementId = driver.switchTo().activeElement().getAttribute("id");
        Assert.assertEquals(activeElementId, "id_password1", "Keyboard navigation failed to move to password field");

      
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(200);
        activeElementId = driver.switchTo().activeElement().getAttribute("id");
        Assert.assertEquals(activeElementId, "id_password2", "Keyboard navigation failed to move to confirm password field");

  
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        Thread.sleep(200);
        WebElement active = driver.switchTo().activeElement();
        String activeValue = active.getAttribute("value"); // should be "Register"
        Assert.assertEquals(activeValue, "Register", "Keyboard navigation failed to move to register button");
	}

	@When("user refreshes the Register page")
	public void user_refreshes_the_register_page() {
		driver.navigate().refresh();
	}

	@Then("Register page should load without errors")
	public void register_page_should_load_without_errors() {
		String pageSource = driver.getPageSource();
        Assert.assertFalse(pageSource.contains("error"), "Page contains 'error'");
        Assert.assertFalse(pageSource.contains("404"), "Page contains '404'");
        Assert.assertFalse(pageSource.contains("500"), "Page contains '500'");
	}



}
