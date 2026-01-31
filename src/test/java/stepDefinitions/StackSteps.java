package stepDefinitions;

import static driver.DriverFactory.getDriver;
import java.io.IOException;
import java.util.List;
import utilities.ExcelSheetHandling;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import driver.DriverFactory;
import io.cucumber.java.en.*;
import pageObjects.StackPage;



public class StackSteps {

    private static final Logger logger = LogManager.getLogger(StackSteps.class);

    private WebDriver driver;
    private StackPage stackPage;

    public StackSteps() {
        this.driver = getDriver();
        this.stackPage = new StackPage(driver);
    }

@When("The user clicks the Get Started button in Stack Panel")
public void the_user_clicks_the_get_started_button_in_stack_panel() {
	stackPage.clickStackGetStarted();
    logger.info("Clicked Stack Get Started in the stack page");
}
    

    @Then("The user should be directed to Stack Page")
    public void the_user_should_be_directed_to_stack_page() {
        Assert.assertTrue(stackPage.isStackPageDisplayed(), "User is not on Stack Page");
    }

    @When("The user clicks {string} in Stack link page")
    public void the_user_clicks_in_stack_link_page(String StackLinks) {

        switch (StackLinks) {
            case "Operations in Stack":
                stackPage.clickOperationsInStack();
                break;

            case "Implementation":
                stackPage.clickImplementStackLink();
                break;

            case "Applications":
                stackPage.clickApplicationStackLink();
                break;
                
            case "Practice Questions":
                stackPage.clickPracticeQuestions();
                break;

            default:
                throw new IllegalArgumentException("Invalid Stack link: " + StackLinks);
        }
        logger.info("User Clicked Stack link in the stack page: " + StackLinks);
    }


    @When("The user clicks Try Here button after reaching Stack page")
    public void the_user_clicks_try_here_button_after_reaching_stack_page() {
        stackPage.clickTryHere();
    }

    @When("The user writes {string} for {string} in Editor and clicks the Run button in stack page")
    public void the_user_writes_for_in_editor_and_clicks_the_run_button_in_stack_page(String Code, String scenarioType)throws IOException {

        if ("invalidCode".equalsIgnoreCase(scenarioType)) {

            stackPage.writeAndRunStackCode(Code);
            String alertMsg = stackPage.waitForAlertIfPresent();

            if (alertMsg != null) {
                logger.info("Alert detected: " + alertMsg);
            } else {
                logger.warn("No alert detected after clicking Run");
            }

        } else {
        	ExcelSheetHandling excel =
			        new ExcelSheetHandling("src/test/resources/ExcelSheet/DsAlgoTestData.xlsx");

			List<String> data = excel.getCodeByColumn(Code);
			for (int i = 0; i < data.size(); i++) {
			    String line = data.get(i);
			    stackPage.writeAndRunStackCode(line);
			}
        }
    }

    @Then("The user should see output in the console for Stack Page")
    public void the_user_should_see_output_in_console() {
        String output = stackPage.getOutput();
        Assert.assertNotNull(output, "Expected output but got null");
        logger.info("user should see output in the console for Stackpage Page: " + output);
    }
    
    @Then("Stack page should load within {string} seconds")
    public void stack_page_should_load_within_seconds(String seconds) {
    	long maxTime = Long.parseLong(seconds);
        long startTime = System.currentTimeMillis();
        stackPage.waitForStackPage();
        long loadTime = (System.currentTimeMillis() - startTime) / 1000;
        Assert.assertTrue(loadTime <= maxTime,
                "Stack page load time exceeded limit: " + loadTime + " seconds");
    }

    @Then("all main stack operations buttons should be visible")
    public void all_main_stack_operations_buttons_should_be_visible() {
    	
       Assert.assertTrue(
        		stackPage.isOperationsInStackLinkDisplayed(),
            "Operations is Stack not visible");

        Assert.assertTrue(
        		stackPage.isImplementationLinkDisplayed(),
            "Implementation is not visible");
        Assert.assertTrue(
        		stackPage.isApplicationsLinkDisplayed(),
                "Application is not visible");
        
        Assert.assertTrue(
        		stackPage.isTryEditorDisplayed(),
                "Try here is not visible");
        
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
    	String pageSource = driver.getPageSource();

	    Assert.assertFalse(pageSource.contains("error"), "Stack page contains 'error'");
	    Assert.assertFalse(pageSource.contains("404"), "Stack page contains '404'");
	    Assert.assertFalse(pageSource.contains("500"), "Stack page contains '500'");
		
		Assert.assertNotNull(
	            driver.getTitle(),
	            "Stack page title is NULL after refresh"
	    );
}
}
