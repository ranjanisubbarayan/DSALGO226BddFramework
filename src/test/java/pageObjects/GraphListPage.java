package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class GraphListPage {
	
	WebDriver driver;

	public GraphListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//div[contains(text(),'You are logged in')]")
	WebElement verifyHomepage;

	
	@FindBy(xpath = "//a[@href='graph']")
	WebElement btnGraphGetstarted;

	@FindBy(xpath = "//div/h4[text()='Graph']")
	WebElement verifyGraphPage;



	//@FindBy(xpath = "//a[normalize-space()='Graph']")

	@FindBy(xpath = "//div//a[@href='graph']")
	//@FindBy(xpath = "//a[normalize-space()='Graph']")

	WebElement lnkGraphTopic;

	//@FindBy(xpath = "//div//a[@href='graph-representations']")
	@FindBy(xpath = "//a[normalize-space()='Graph Representations']")
	WebElement lnkGraphRepresentations;

	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement btnTryEditor;

	@FindBy(xpath = "//button[contains(text(),'Run')]")
	WebElement btnRun;

	
	@FindBy(xpath = "//p[contains(text(),'Graph') and not(contains(text(),'Representations'))]")
	WebElement verifyGraphTopicText;

	@FindBy(xpath = "//p[contains(text(),'Graph Representations')]")
	WebElement verifyGraphRepresentationsText;

	
	@FindBy(xpath = "//pre[@role='presentation']")
	WebElement writeCode;


	public void verifyHomePage() {
		Assert.assertEquals(verifyHomepage.getText(), "You are logged in");
	}

	public void getstartedGraph() {
		btnGraphGetstarted.click();
	}

	public void verifyGraphLandingPage() {
		Assert.assertEquals(verifyGraphPage.getText(), "Graph");
	}

	public void clickGraphTopic() {
		lnkGraphTopic.click();
	}

	public void clickGraphRepresentations() {
		lnkGraphRepresentations.click();
	}

	public void clickTryHere() {
		btnTryEditor.click();
	}
	
	public void clickRunButton() {
		btnRun.click();
	}

	public void verifyRunButtonPresent() {
		Assert.assertEquals(btnRun.getText(), "Run");
	}

	public void verifyGraphTopicText() {
		Assert.assertTrue(verifyGraphTopicText.isDisplayed(), "Graph topic text is not visible");
	}

	public void verifyGraphRepresentationsText() {
		Assert.assertTrue(verifyGraphRepresentationsText.isDisplayed(), "Graph Representations text is not visible");
	}

	
	public void writeCodeAndRun(String code) {
		Actions actions = new Actions(driver);
		actions.click(writeCode).perform();
		actions.sendKeys(code).perform();
		btnRun.click();
	}

	
	public String getAlertTextAndAccept() {
		Alert a = driver.switchTo().alert();
		String text = a.getText();
		a.accept();
		return text;
	}
	public String waitForAlertIfPresent() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	        String text = alert.getText();
	        alert.accept();
	        return text;
	    } catch (Exception e) {
	        return null; // No alert appeared
	    }
	}

	
	public String getConsoleOutput() {
		// Common pattern: output appears in a pre/div after Run; update if needed
		// Try a conservative locator used in dsportal tryEditor pages:
		WebElement output = driver.findElement(By.id("output"));
		return output.getText().trim();
	}
}
