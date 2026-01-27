package stepDefinitions;

import static driver.DriverFactory.getDriver;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArrayListPage;
import pageObjects.LaunchPage;
import pageObjects.LoginPage;
import pageObjects.homePage;
import utilities.ElementUtils;
import utilities.DataDriven;
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


    @Given("The user is in the Array page after Sign in")
    public void theUserIsInTheArrayPageAfterSignIn() {
        arraylistpage.getstartedArray();

    }

    @Given("The user is in the Home page after Sign in")
    public void the_user_is_in_the_home_page_after_sign_in() {
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

    @When("The user clicks Arrays in Python link")
    public void the_user_clicks_arrays_in_python_link() {
        arraylistpage.clickArraysInPython();
    }

    @Then("The user should be redirected to {string} page")
    public void the_user_should_be_redirected_to_arrays_in_python_page(String expectedTitle) {
        Assert.assertEquals(ElementUtils.getCurrentTitle(),expectedTitle);
    }

    @When("The user clicks Try Here button after reaching to arrays in python")
    public void the_user_clicks_try_here_button_in_arrays_in_python_page() {
        arraylistpage.clickArraysInPython();
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
        // validation missing
        logger.info("An alert message should be shown for Graph Topic invalid execution");
    }

    @When("The user writes {string} for {string} in Editor and clicks the Run button")
    public void the_user_writes_code_in_editor_and_clicks_the_run_button(String code, String scenarioType) throws IOException {

        if (scenarioType.contains("invalid")) {
            arraylistpage.writeCodeAndRun(code);
            alertMsg = arraylistpage.waitForAlertIfPresent();
            if (alertMsg != null) {
                System.out.println("Alert detected: " + alertMsg);
            } else {
                System.out.println("⚠ No alert detected after clicking Run");
            }
        }
		else{
			DataDriven d = new utilities.DataDriven();
			ArrayList<String> data = d.getData(code);
			arraylistpage.writeAndRunLinkedListCode(data.get(1).toString());
		}
    }

    @Then("The user should see output in the console for ArrayList Page")
    public void the_user_should_see_output_in_the_console() {

      // add assertion

        logger.info("The user should see output in the console for ArrayList Page" + arraylistpage.getOutput());
    }

}
