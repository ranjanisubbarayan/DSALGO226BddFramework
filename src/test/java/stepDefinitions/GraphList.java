package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import pageObjects.LoginPage;
import pageObjects.GraphListPage;

import static driver.DriverFactory.getDriver;

public class GraphList{

	private WebDriver driver = getDriver();
	private LoginPage loginPage = new LoginPage(driver);
	private GraphListPage graphPage = new GraphListPage(driver);

	// -------------------- Background / Login --------------------
	@Given("The user logs into dsAlgo Portal with username {string} and password {string}")
	public void the_user_logs_into_ds_algo_portal_with_username_and_password(String username, String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		loginPage.goTo();
		loginPage.loginApplication(username, password);
	}

	@Given("The user should be on the Home Dashboard")
	public void the_user_should_be_on_the_home_dashboard() {
		graphPage.verifyHomePage();
	}

	@When("The user selects the Get Started option under the Graph section")
	public void the_user_selects_the_get_started_option_under_the_graph_section() {
		graphPage.getstartedGraph();
	}

	@Then("The Graph main page should appear")
	public void the_graph_main_page_should_appear() {
		graphPage.verifyGraphLandingPage();
	}

	@Then("The user chooses the Graph Topic link")
	public void the_user_chooses_the_graph_topic_link() {
		graphPage.clickGraphTopic();
	}

	@Then("The Graph Topic information page should load")
	public void the_graph_topic_information_page_should_load() {
		graphPage.verifyGraphTopicText();
	}

	@Then("The user selects the Try Editor button on Graph Topic page")
	public void the_user_selects_the_try_editor_button_on_graph_topic_page() {
		graphPage.clickTryHere();
	}

	@Then("The Try Editor page for Graph Topic should display with a Run option")
	public void the_try_editor_page_for_graph_topic_should_display_with_a_run_option() {
		
		
	}

	@When("The user is on the Try Editor page for Graph Topic")
	public void the_user_is_on_the_try_editor_page_for_graph_topic() {
		
	}

	@When("The user enters {string} into the editor and clicks Run")
	public void the_user_enters_into_the_editor_and_clicks_run(String graphInput) {
		graphPage.writeCodeAndRun(graphInput);
		graphPage.verifyRunButtonPresent();
	}

	@Then("An alert message should be shown for Graph Topic invalid execution")
	public void an_alert_message_should_be_shown_for_graph_topic_invalid_execution() {
//		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
//		alert.accept();
	}

	@Then("The user chooses the Graph Representations link")
	public void the_user_chooses_the_graph_representations_link() {

		
		graphPage.getstartedGraph();
		//graphPage.verifyGraphLandingPage();
	   graphPage.clickGraphRepresentations();

	}

	@Then("The Graph Representations information page should load")
	public void the_graph_representations_information_page_should_load() {

	    graphPage.verifyGraphRepresentationsText();

	}

	@Then("The user selects the Try Editor button on Graph Representations page")
	public void the_user_selects_the_try_editor_button_on_graph_representations_page() {

		graphPage.clickTryHere();

	}

	@Then("The Try Editor page for Graph Representations should display with a Run option")
	public void the_try_editor_page_for_graph_representations_should_display_with_a_run_option() {
		graphPage.writeCodeAndRun("print(5 + 3)");
		graphPage.verifyRunButtonPresent();

	}

	@When("The user is on the Try Editor page for Graph Representations")
	public void the_user_is_on_the_try_editor_page_for_graph_representations() {
	    
	}

	@Then("An alert message should be shown for Graph Representations invalid execution")
	public void an_alert_message_should_be_shown_for_graph_representations_invalid_execution() {

		

	}

}