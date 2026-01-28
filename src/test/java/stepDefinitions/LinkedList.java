package stepDefinitions;

import static driver.DriverFactory.getDriver;

import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LinkedListPage;
import utilities.ExcelSheetHandling;

public class LinkedList {
	
	private static final Logger logger = LogManager.getLogger(GraphList.class);
	private WebDriver driver;
	private LinkedListPage linkedlistPage;
	
	public LinkedList() {
	    this.driver = getDriver();
	    this.linkedlistPage = new LinkedListPage(driver);
	}

	@When("The user clicks the Get Started button in Linkedlist")
	public void the_user_clicks_the_get_started_button() {
		linkedlistPage.getstartedLinkedList();
		
		logger.info("successfully logged into the dsalgo application");
	}
	@Then("The user should be directed to Linked List Page")
	public void the_user_should_be_directed_to_linked_list_page() {
		Assert.assertEquals(
                linkedlistPage.getLinkedListPageText(),
                "Linked List",
                "User is not on Linked List page"
        );
	}
	
	@When("The user clicks {string} in LinkedList page")
	public void the_user_clicks_link_in_linkedlist_page(String LinkedLinks) {

	    if (LinkedLinks.equalsIgnoreCase("Introduction")) {
	        linkedlistPage.clickIntroductionLink();

	    } else if (LinkedLinks.equalsIgnoreCase("Creating Linked List")) {
	        linkedlistPage.clickCreatingLink();

	    } else if (LinkedLinks.equalsIgnoreCase("Types of Linked List")) {
	        linkedlistPage.clicktypesLink();

	    } else if (LinkedLinks.equalsIgnoreCase("Implement Linked List in Python")) {
	        linkedlistPage.clickImplementingLink();

	    } else if (LinkedLinks.equalsIgnoreCase("Traversal")) {
	        linkedlistPage.clickTraversalLink();

	    } else if (LinkedLinks.equalsIgnoreCase("Insertion")) {
	        linkedlistPage.clickInsertionLink();

	    } else if (LinkedLinks.equalsIgnoreCase("Deletion")) {
	        linkedlistPage.clickDeletionLink();

	    } else {
	        throw new IllegalArgumentException("Invalid LinkedList link: " + LinkedLinks);
	    }
	}
	@When("the user clicks the Try Here button on the Linked page")
	public void the_user_clicks_the_try_here_button_on_the_introduction_page() {
		linkedlistPage.clickTryHere();
	}

	@When("The user writes {string} for {string} in Editor and clicks the Run button in LinkedList Page")
	public void the_user_writes_code_in_editor_and_clicks_the_run_button_linkedlist(String code, String scenarioType) throws IOException {

	    if ("invalidCode".equalsIgnoreCase(scenarioType)) {
	    	 linkedlistPage.writeAndRunLinkedListCode(code);
	         String alertMsg = linkedlistPage.waitForAlertIfPresent();

	         if (alertMsg != null) {
	             System.out.println("Alert detected: " + alertMsg);
	         } else {
	             System.out.println("No alert detected after clicking Run");
	         }

	     }  {
	        	ExcelSheetHandling excel =
				        new ExcelSheetHandling("src/test/resources/ExcelSheet/DsAlgoTestData.xlsx");

				List<String> data = excel.getCodeByColumn(code);
				for (int i = 0; i < data.size(); i++) {
				    String line = data.get(i);
				    linkedlistPage.writeAndRunLinkedListCode(line);
				}
	    
	    
	     }
	    }

	
	@Then("The user should see output in the console for Linkedlist Page")
	public void the_user_should_see_output_in_the_console() {
		
    	String output = linkedlistPage.getOutput();
		 Assert.assertNotNull(output, "Expected output in the console, but it was null");
		logger.info("user should see output in the console for LinkedList Page"+output);
	}
}
