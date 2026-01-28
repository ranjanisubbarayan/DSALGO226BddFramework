package stepDefinitions;

import static driver.DriverFactory.getDriver;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArrayListPage;
import pageObjects.LaunchPage;
import utilities.ElementUtils;
import utilities.ExcelSheetHandling;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ArraysList {

    private static final Logger logger = LogManager.getLogger(ArraysList.class);

    private WebDriver driver;
    LaunchPage launchPage;
    private ArrayListPage arraylistpage;
    private String alertMsg = null;

    public ArraysList() {
        this.driver = getDriver();
        this.launchPage = new LaunchPage(driver);
        this.arraylistpage = new ArrayListPage(driver);
    }

    @Given("The user is in the Home page after Sign in")
    public void the_user_is_in_the_home_page_after_sign_in() {
    	// Login handled by Hook page in @Before 
        logger.info("successfully logged into the Homepage of the application");
    }

    @When("The user clicks the Get Started button in Array Panel")
    public void the_user_clicks_the_button_in_array_panel() {
        arraylistpage.getstartedArray();
        logger.info("successfully logged into the array module");
    }

    @Then("The user should be directed to Array Page")
    public void the_user_should_be_directed_to_Array_page() {
        Assert.assertEquals(
                arraylistpage.getArrayPageText(),
                "Array",
                "User is not on Array Page"
        );
        arraylistpage.clickArraysInPython();
    }

    @When("The user clicks {string} in link page")
    public void the_user_clicks_arrays_in_python_link(String ArrayLinks) {
    	  if (ArrayLinks.equalsIgnoreCase("Arrays in Python")) {
    	        arraylistpage.clickArraysInPython();

    	    } else if (ArrayLinks.equalsIgnoreCase("Arrays Using List")) {
    	        arraylistpage.clickArraysUsingList();

    	    } else if (ArrayLinks.equalsIgnoreCase("Basic Operations in Lists")) {
    	        arraylistpage.clickBasicOperationArray();

    	    } else if (ArrayLinks.equalsIgnoreCase("Applications of Array")) {
    	        arraylistpage.clickApplicationofArray();

    	    } else if (ArrayLinks.equalsIgnoreCase("Practice Questions")) {
    	        arraylistpage.clickPracticeQue();

    	    } else {
    	        throw new IllegalArgumentException("Invalid Array link: " + ArrayLinks);
    	    }
    }

    @Then("The user should be redirected to {string} page")
    public void the_user_should_be_redirected_to_arrays_in_python_page(String expectedTitle) {
        Assert.assertEquals(ElementUtils.getCurrentTitle(),expectedTitle);
    }

    @When("The user clicks Try Here button after reaching to arrays in python")
    public void the_user_clicks_try_here_button_in_arrays_in_python_page() {
        arraylistpage.clickTryHere();
    }

    @Then("The user should be redirected to a page having a {string}")
    public void the_user_should_be_redirected_to_a_page_having_a_try_editor_with_a_run_button_to_test(String expectedURLText) {
        Assert.assertTrue(ElementUtils.getCurrentURL().contains(expectedURLText));
    }

    @Then("The user should see a Run button in try editor")
    public void the_user_should_be_see_a_run_button_to_test() {
        Assert.assertTrue(
                arraylistpage.isRunButtonDisplayed(),
                "Run button is not displayed"
        );
    }

    @Then("The user should see an error message in alert window")
    public void the_user_should_see_an_error_message_in_alert_window() {
    	Assert.assertNotNull( alertMsg,"Expected an alert message for invalid execution, but no alert was shown" );
        logger.info("An alert message should be shown for invalid execution");
    }

    @When("The user writes {string} for {string} in Editor and clicks the Run button")
    public void the_user_writes_code_in_editor_and_clicks_the_run_button(String code, String scenarioType) throws IOException {

        if (scenarioType.contains("invalid")) {
            arraylistpage.writeCodeAndRun(code);
            alertMsg = arraylistpage.waitForAlertIfPresent();
            if (alertMsg != null) {
                System.out.println("Alert detected: " + alertMsg);
            } else {
                System.out.println("No alert detected after clicking Run");
            }
        }
		else{
			
			ExcelSheetHandling excel =
			        new ExcelSheetHandling("src/test/resources/ExcelSheet/DsAlgoTestData.xlsx");

			List<String> data = excel.getCodeByColumn(code);
			for (int i = 0; i < data.size(); i++) {
			    String line = data.get(i);
			    arraylistpage.writeAndRunArrayListCode(line);
			}

		}
    }

    @Then("The user should see output in the console for ArrayList Page")
    public void the_user_should_see_output_in_the_console() {

    	String output = arraylistpage.getOutput();
		 Assert.assertNotNull(output, "Expected output in the console, but it was null");

        logger.info("The user should see output in the console for ArrayList Page" + arraylistpage.getOutput());
    }
    

	@Then("Array page should load within {string} seconds")
	public void array_page_should_load_within_seconds(String seconds) {
		long maxTime = Long.parseLong(seconds);

        long startTime = System.currentTimeMillis();
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
