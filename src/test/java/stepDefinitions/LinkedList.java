package stepDefinitions;

import static driver.DriverFactory.getDriver;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LinkedListPage;
import pageObjects.LoginPage;
import utilities.DataDriven;

public class LinkedList {
	
	private WebDriver driver = getDriver();
	LoginPage loginpage = new LoginPage(driver);
	LinkedListPage linkedlistPage=new LinkedListPage(driver);
	

	@When("The user clicks the Get Started button")
	public void the_user_clicks_the_get_started_button() {
		linkedlistPage.getstartedLinkedList();
	}
	@Then("The user should be directed to Linked List Page")
	public void the_user_should_be_directed_to_linked_list_page() {
		linkedlistPage.verifyLinkedListPage();
	}
	
	@When("the user clicks the Introduction link")
	public void the_user_clicks_the_introduction_link() {
		linkedlistPage.clickIntroductionLink();
	}
	@When("the user clicks the Try Here button on the Introduction page")
	public void the_user_clicks_the_try_here_button_on_the_introduction_page() {
		linkedlistPage.clickTryHere();
	}

	@Then("The user write valid Linked List code in Editor and clicks the Run Button")
	public void the_user_write_valid_linked_list_code_in_editor_and_clicks_the_run_button() throws IOException {
		DataDriven d=new utilities.DataDriven();
		ArrayList data=d.getData("LinkedList");
	    linkedlistPage.writeAndRunLinkedListCode((String) data.get(1));
	    
	}

}
