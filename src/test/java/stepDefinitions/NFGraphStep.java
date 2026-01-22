package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import driver.DriverFactory;
import pageObjects.GraphListPage;
import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import pageObjects.homePage;

public class NFGraphStep {

   
    private WebDriver driver;
	LaunchPage launchPage;
	private GraphListPage graphPage;

    public NFGraphStep() {
    	this.driver = DriverFactory.getDriver();
        this.launchPage = new LaunchPage(driver);
        this.graphPage = new GraphListPage(driver);
    }

    @Given("user is on Graph page")
    public void user_is_on_graph_page() {
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
        graphPage.getstartedGraph();
        Assert.assertTrue(graphPage.getGraphLandingPageText().contains("Graph"), "Graph page not displayed");
    }

    @Then("Graph page should load within {string} seconds")
    public void graph_page_should_load_within_seconds(String seconds) {
        long maxTime = Long.parseLong(seconds);
        long start = System.currentTimeMillis();

        driver.navigate().refresh();

        long end = System.currentTimeMillis();
        long loadTime = (end - start) / 1000;
        Assert.assertTrue(loadTime <= maxTime, "Graph page load exceeded " + maxTime + "s. Actual: " + loadTime + "s");
    }

    @Then("all Graph page elements should be visible")
    public void all_graph_page_elements_should_be_visible() {
        Assert.assertTrue(graphPage.isRunButtonDisplayed(), "Run button is not visible");
        Assert.assertTrue(graphPage.isGraphTopicTextDisplayed(), "Graph topic text is not visible");
        Assert.assertTrue(graphPage.isGraphRepresentationsTextDisplayed(), "Graph Representations text is not visible");
    }

    @Then("Graph page should be loaded using HTTPS")
    public void graph_page_should_be_loaded_using_https() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.startsWith("https://"), "Graph page is not loaded over HTTPS");
    }
    
    @Then("all main graph operations buttons should be visible")
    public void all_main_graph_operations_buttons_should_be_visible() {
    	graphPage.clickTryHereIfVisible();
		Assert.assertTrue(
	            graphPage.isRunButtonDisplayed(),
	            "Run button is not visible in Graph module"
	    );
    }


    @Then("user should be able to navigate Graph page using keyboard")
    public void user_should_be_able_to_navigate_graph_page_using_keyboard() throws InterruptedException {
        
        graphPage.clickGraphTopic(); 
        Thread.sleep(200);

        WebElement active = driver.switchTo().activeElement();
        Assert.assertTrue(active.isDisplayed(), "Keyboard focus did not move to Graph topic");

        active.sendKeys(Keys.TAB);
        Thread.sleep(200);
        active = driver.switchTo().activeElement();
        Assert.assertTrue(active.isDisplayed(), "Keyboard focus did not move to Graph Representations");

        active.sendKeys(Keys.TAB);
        Thread.sleep(200);
        active = driver.switchTo().activeElement();
        String btnValue = active.getAttribute("value");
        Assert.assertEquals(btnValue, "Try here", "Keyboard focus did not move to Try Editor button");
    }

    @When("user refreshes the Graph page")
    public void user_refreshes_the_graph_page() {
        driver.navigate().refresh();
    }

    @Then("Graph page should load without errors")
    public void graph_page_should_load_without_errors() {
        String pageSource = driver.getPageSource();
        Assert.assertFalse(pageSource.contains("error"), "Page contains 'error'");
        Assert.assertFalse(pageSource.contains("404"), "Page contains '404'");
        Assert.assertFalse(pageSource.contains("500"), "Page contains '500'");
    }
}
