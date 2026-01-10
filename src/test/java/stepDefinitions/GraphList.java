package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import pageObjects.LoginPage;
import pageObjects.homePage;
import utilities.DataDriven;
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
	
	@Given("The user logs into dsAlgo Portal with username {string} and password {string}")
	public void the_user_logs_into_ds_algo_portal_with_username_and_password(String username, String password) {

		
	    homePage homepage = launchPage.clickGetStarted();

	    if (!homepage.isUserLoggedIn()) {
	        homepage.clickSignInLinkIfPresent();
	        LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.clickLoginButton();

	   	    }
		logger.info("successfully logged into the dsalgo application");
	}

	@Given("The user should be on the Home Dashboard")
	public void the_user_should_be_on_the_home_dashboard() {
		logger.info("Successfully logged into the dsAlgo Home Dashboard");
	}
	

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

	@Then("The user chooses the Graph Topic link")
	public void the_user_chooses_the_graph_topic_link() {
		graphPage.clickGraphTopic();
	}

	@Then("The Graph Topic information page should load")
	public void the_graph_topic_information_page_should_load() {
		  Assert.assertTrue(
	                graphPage.isGraphTopicTextDisplayed(),
	                "Graph Topic page text not visible"
	        );
	}

	@Then("The user selects the Try Editor button on Graph Topic page")
	public void the_user_selects_the_try_editor_button_on_graph_topic_page() {
		graphPage.clickTryHere();
	}

	@Then("The Try Editor page for Graph Topic should display with a Run option")
	public void the_try_editor_page_for_graph_topic_should_display_with_a_run_option() {
		
		logger.info("The Try Editor page for Graph Topic should display with a Run option");
	}

	@When("The user is on the Try Editor page for Graph Topic")
	public void the_user_is_on_the_try_editor_page_for_graph_topic() {
		logger.info("The user is on the Try Editor page for Graph Topic");
	}

	@When("The user enters {string} into the editor and clicks Run")
	public void the_user_enters_into_the_editor_and_clicks_run(String graphInput) {
		
		graphPage.writeCodeAndRun(graphInput);

		
		alertMsg = graphPage.waitForAlertIfPresent();
		if (alertMsg != null) {
		    System.out.println("Alert detected: " + alertMsg);
		}
		else {
            System.out.println("⚠ No alert detected after clicking Run");
        }


	}

	@Then("An alert message should be shown for Graph Topic invalid execution")
	public void an_alert_message_should_be_shown_for_graph_topic_invalid_execution() {
		logger.info("An alert message should be shown for Graph Topic invalid execution");
	}

	@Then("The user chooses the Graph Representations link")
	public void the_user_chooses_the_graph_representations_link() {

		
		graphPage.getstartedGraph();
	
	   graphPage.clickGraphRepresentations();

	}

	@Then("The Graph Representations information page should load")
	public void the_graph_representations_information_page_should_load() {

		   Assert.assertTrue(
	                graphPage.isGraphRepresentationsTextDisplayed(),
	                "Graph Representations page text not visible"
	        );

	}

	@Then("The user selects the Try Editor button on Graph Representations page")
	public void the_user_selects_the_try_editor_button_on_graph_representations_page() {

		graphPage.clickTryHere();

	}

	@Then("The Try Editor page for Graph Representations should display with a Run option")
	public void the_try_editor_page_for_graph_representations_should_display_with_a_run_option() {
		graphPage.writeCodeAndRun("print(5 + 3)");
	
		graphPage.clickRunButton();

	}

	@When("The user is on the Try Editor page for Graph Representations")
	public void the_user_is_on_the_try_editor_page_for_graph_representations() {
		logger.info("The user is on the Try Editor page for Graph Representations");
	}

	@Then("An alert message should be shown for Graph Representations invalid execution")
	public void an_alert_message_should_be_shown_for_graph_representations_invalid_execution() {

		logger.info("An alert message should be shown for Graph Representations invalid execution");

	}
	@Then("The user write valid Linked List code in Editor and clicks the Run Button in Graph Page")
	public void the_user_write_valid_linked_list_code_in_editor_and_clicks_the_run_button() throws IOException {
		DataDriven d=new utilities.DataDriven();
		ArrayList<String> data=d.getData("Graph");
		graphPage.writeAndRunLinkedListCode((String) data.get(1));
	}
	
	@Then("The user should see output in the console for Graph Page")
	public void the_user_should_see_output_in_the_console() {
		logger.info("The user should see output in the console for Graph Page"+(driver.findElement(By.xpath("//pre[@id='output']")).getText()));
	}

}