package stepDefinitions;

import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import driver.DriverFactory;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import utilities.ExcelSheetHandling;
import pageObjects.GraphListPage;
import pageObjects.LaunchPage;


public class GraphList{
	
	private static final Logger logger = LogManager.getLogger(GraphList.class);


	private WebDriver driver;
	LaunchPage launchPage;
	private GraphListPage graphPage;

	public GraphList() {
		this.driver = DriverFactory.getDriver();
        this.launchPage = new LaunchPage(driver);
        this.graphPage = new GraphListPage(driver);
	}
	
	private String alertMsg = null;
	
	@When("The user selects the Get Started option under the Graph section")
	public void the_user_selects_the_get_started_option_under_the_graph_section() {
		graphPage.getstartedGraph();
	}

	@Then("The Graph main page should appear")
	public void the_graph_main_page_should_appear() {
	     Assert.assertEquals(
	                graphPage.getGraphLandingPageText(),
	                "Graph",
	                "Graph landing page is not displayed"
	        );
	}

	@When("The user chooses {string} link in Graph Page")
	public void the_user_chooses_dynamic_graph_link(String graphLink) {

	    if (graphLink.equalsIgnoreCase("Graph")) {
	        graphPage.clickGraphTopic();

	    } else if (graphLink.equalsIgnoreCase("Graph Representations")) {
	        graphPage.clickGraphRepresentations();

	    } else {
	        throw new IllegalArgumentException("Invalid Graph link: " + graphLink);
	    }
	}

	@Then("The {string} information page should load")
	public void the_graph_information_page_should_load(String graphLink) {

	    if (graphLink.equalsIgnoreCase("Graph")) {

	        Assert.assertTrue(
	            graphPage.isGraphTopicTextDisplayed(),
	            "Graph Topic page text not visible"
	        );

	    } else if (graphLink.equalsIgnoreCase("Graph Representations")) {

	        Assert.assertTrue(
	            graphPage.isGraphRepresentationsTextDisplayed(),
	            "Graph Representations page text not visible"
	        );

	    } else {
	        throw new IllegalArgumentException("Invalid Graph page: " + graphLink);
	    }
	}


	@When("The user selects the Try Editor button on Graph Topic page")
	public void the_user_selects_the_try_editor_button_on_graph_topic_page() {
		graphPage.clickTryHere();
	}


	@When("The user enters {string} into the editor and clicks Run")
	public void the_user_enters_into_the_editor_and_clicks_run(String graphInput) {
		
		graphPage.writeCodeAndRun(graphInput);

		
		alertMsg = graphPage.waitForAlertIfPresent();
		if (alertMsg != null) {
		    System.out.println("Alert detected: " + alertMsg);
		}
		else {
            System.out.println("No alert detected after clicking Run");
        }


	}
	 @Then("An alert message should be shown for Graph Topic invalid execution")
	    public void the_user_should_see_an_error_message_in_alert_window() {
		 Assert.assertNotNull( alertMsg,"Expected an alert message for invalid execution, but no alert was shown" );
	        logger.info("An alert message should be shown for invalid execution");
	    }
	
	@When("The user write valid code in Editor and clicks the Run Button in Graph Page")
	public void the_user_write_valid_linked_list_code_in_editor_and_clicks_the_run_button() throws IOException {
		
		ExcelSheetHandling excel =
		        new ExcelSheetHandling("src/test/resources/ExcelSheet/DsAlgoTestData.xlsx");

		List<String> data = excel.getCodeByColumn("Graph");
		for (int i = 0; i < data.size(); i++) {
		    String line = data.get(i);
		    graphPage.writeAndRunGraphListCode(line);
		}
		
	}
	
	@Then("The user should see output in the console for Graph Page")
	public void the_user_should_see_output_in_the_console() {
		String output = graphPage.getOutput();
		 Assert.assertNotNull(output, "Expected output in the console, but it was null");
		logger.info("The user should see output in the console for Graph Page"+graphPage.getOutput());
	}
	
	 @Then("Graph page should load within {string} seconds")
	    public void graph_page_should_load_within_seconds(String seconds) {
	        long maxTime = Long.parseLong(seconds);
	        long start = System.currentTimeMillis();
	        graphPage.waitForGraphPage();
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