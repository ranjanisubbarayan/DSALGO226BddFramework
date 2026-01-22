package stepDefinitions;

import static driver.DriverFactory.getDriver;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArrayListPage;
import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import pageObjects.homePage;

public class NFArray {
	
	private WebDriver driver;
	LaunchPage launchPage;
	private ArrayListPage arraylistpage;
	
	public NFArray() {
	    this.driver = getDriver(); 
	    this.launchPage = new LaunchPage(driver);
	    this.arraylistpage = new ArrayListPage(driver);
	}

	@Given("user is on Array page")
	public void user_is_on_array_page() {
		String firstname = "TestNinja";
		String password = "C5Mha6FkdSAVEN@";
		homePage homepage = launchPage.clickGetStarted();

	    if (!homepage.isUserLoggedIn()) {
	        homepage.clickSignInLinkIfPresent();

	        LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUsername(firstname);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();
	    }
	    Assert.assertNotNull(driver, "Driver is NULL");

        arraylistpage.getstartedArray();

        Assert.assertEquals(
                arraylistpage.getArrayPageText(),
                "Array",
                "Array page not loaded"
        );
	}

	@Then("Array page should load within {string} seconds")
	public void array_page_should_load_within_seconds(String seconds) {
		long maxTime = Long.parseLong(seconds);

        long startTime = System.currentTimeMillis();
        driver.get("https://dsportalapp.herokuapp.com/array/");
        arraylistpage.waitForArrayPage();
        long loadTime = (System.currentTimeMillis() - startTime) / 1000;

        Assert.assertTrue(loadTime <= maxTime,
                "Array page load time exceeded limit: " + loadTime + " seconds");
	}

	@Then("all main array operations buttons should be visible")
	public void all_main_array_operations_buttons_should_be_visible() {
		arraylistpage.clickTryHereIfVisible();
		Assert.assertTrue(
	            arraylistpage.isRunButtonDisplayed(),
	            "Run button is not visible in Array module"
	    );
	}

	@Then("Array page should be loaded using HTTPS")
	public void array_page_should_be_loaded_using_https() {
		String currentUrl = driver.getCurrentUrl();
	    Assert.assertTrue(
	            currentUrl.startsWith("https"),
	            "Array page is NOT loaded using HTTPS. URL: " + currentUrl
	    );
	}

	@When("user refreshes the Array page")
	public void user_refreshes_the_array_page() {
		driver.navigate().refresh();
	}

	@Then("Array page should load without errors")
	public void array_page_should_load_without_errors() {
		Assert.assertNotNull(
	            driver.getTitle(),
	            "Array page title is NULL after refresh"
	    );

	    System.out.println("Array Page Title after refresh: " + driver.getTitle());
	}


}
