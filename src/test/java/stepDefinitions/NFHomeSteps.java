package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.homePage;

public class NFHomeSteps {

    homePage homePage;
    long startTime;
    long endTime;

    @Given("The user opens the DS Algo Portal Home page")
    public void the_user_opens_the_ds_algo_portal_home_page() {
        startTime = System.currentTimeMillis();
        DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/");
        homePage = new homePage(DriverFactory.getDriver());
        endTime = System.currentTimeMillis();
    }

    @Then("The Home page should load within {string} seconds")
    public void the_home_page_should_load_within_seconds(String seconds) {
        long loadTime = (endTime - startTime) / 1000;
        long expectedTime = Long.parseLong(seconds);

        System.out.println("Page Load Time: " + loadTime + " seconds");
        assertEquals("Home page load time exceeded limit",
                loadTime <= expectedTime);
    }

    @Then("The Get Started button should be visible")
    public void the_get_started_button_should_be_visible() {
        assertTrue(homePage.isGetStartedButtonDisplayed());
    }

    @Then("The Sign in link should be visible")
    public void the_sign_in_link_should_be_visible() {
        assertTrue(homePage.isdatastrucureDisplayed());
    }

    @Then("The Register link should be visible")
    public void the_register_link_should_be_visible() {
        assertTrue(homePage.isRegisterLinkDisplayed());
    }
}
