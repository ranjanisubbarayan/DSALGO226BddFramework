package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import pageObjects.homePage;

public class NFLoginStep {

    WebDriver driver;
    LoginPage loginpage;
    private LaunchPage launchPage;
    private homePage homepage;

    public NFLoginStep() {
        this.driver = DriverFactory.getDriver();
        this.launchPage = new LaunchPage(driver);
    }

    @Given("user is on Login page")
    public void user_is_on_login_page() {
    	homepage = launchPage.clickGetStarted(); 
    	loginpage = homepage.clickSignOut();       
    	loginpage = homepage.clickSignInLink();
    }

    @Then("Login page should load within {string} seconds")
    public void login_page_should_load_within_seconds(String seconds) {
    	 long maxTime = Long.parseLong(seconds);
         long start = System.currentTimeMillis();

         driver.navigate().refresh(); 
         long end = System.currentTimeMillis();
         long loadTime = (end - start) / 1000;

         Assert.assertTrue(loadTime <= maxTime,
                 "Page load exceeded " + maxTime + " seconds. Actual: " + loadTime + " seconds");
         Assert.assertTrue(loginpage.isPageLoadedCompletely(), "Page did not fully load (readyState != complete)"); }

    @Then("all login fields and buttons should be visible")
    public void all_login_fields_and_buttons_should_be_visible() {
    	Assert.assertTrue(loginpage.loginUsername.isDisplayed(), "Username field is not visible");
        Assert.assertTrue(loginpage.loginPassword.isDisplayed(), "Password field is not visible");
        Assert.assertTrue(loginpage.loginBtn.isDisplayed(), "Login button is not visible");
    }

    @Then("Login page should be loaded using HTTPS")
    public void login_page_should_be_loaded_using_https() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.startsWith("https://"), "Page is not loaded over HTTPS");
    }

    @Then("user should be able to navigate Login page using keyboard")
    public void user_should_be_able_to_navigate_login_page_using_keyboard() throws InterruptedException {
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
