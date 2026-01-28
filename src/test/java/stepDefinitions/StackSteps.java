package stepDefinitions;

import static driver.DriverFactory.getDriver;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import io.cucumber.java.en.*;
import pageObjects.StackPage;
import utilities.DataDriven;

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
            DataDriven d = new DataDriven();
            ArrayList<String> data = d.getData(Code);
            for (int i = 1; i < data.size(); i++) 
            {
                stackPage.writeAndRunStackCode(data.get(i));
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
        long maxTime = Long.parseLong(seconds) * 1000;

        long loadTime = measureStackPageLoadTime();

        Assert.assertTrue(loadTime <= maxTime,
                "Stack page load time exceeded limit: " + loadTime + " seconds");
    }

    private long measureStackPageLoadTime() {
        long start = System.currentTimeMillis();
        stackPage.isStackPageDisplayed();
        long end = System.currentTimeMillis();
        return end - start;
    }

    @Then("all main stack operations buttons should be visible")
    public void all_main_stack_operations_buttons_should_be_visible() {
    	WebDriver driver = DriverFactory.getDriver();

        Assert.assertTrue(
            driver.findElement(By.xpath("//a[normalize-space()='Operations in Stack']")).isDisplayed(),
            "Operations in Stack not visible");

        Assert.assertTrue(
            driver.findElement(By.xpath("//a[normalize-space()='Implementation']")).isDisplayed(),
            "Implementation In not visible");
        Assert.assertTrue(
                driver.findElement(By.xpath("//a[normalize-space()='Applications']")).isDisplayed(),
                "Application In not visible");
        
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
    	Assert.assertNotNull(
	            driver.getTitle(),
	            "Stack page title is NULL after refresh"
	    );

	    System.out.println("Stack Page Title after refresh: " + driver.getTitle());
    }
}
