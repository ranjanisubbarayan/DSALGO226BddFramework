package pageObjects;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ArrayListPage {
	
	WebDriver driver;

	public ArrayListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy (xpath="//div[contains(text(),'You are logged in')]")
	WebElement VerifyHomepage;
	
	@FindBy (xpath="//a[@href='array']")
	WebElement btnArrayGetstarted;
	
	@FindBy (xpath="//div/h4[text()='Array']")
	WebElement verifyArrayspage;
	
	@FindBy (xpath="//a[contains(text(),'Arrays in Python')]")
	WebElement lnkArraysInPython;
	
	@FindBy (xpath="//a[@href='/tryEditor']")
	WebElement btnTryEditor;
	
	@FindBy (xpath="//button[contains(text(),'Run')]")
	WebElement btnRun;
	
	@FindBy (xpath="//p[contains(text(),'Arrays in Python')]")
	WebElement verifyArraysInPython;
	
	@FindBy (xpath="//pre[@role='presentation']")
	WebElement codeEditor;
	
	public void writeCodeAndRun(String code) {
		Actions actions = new Actions(driver);
		actions.click(codeEditor).perform();
		actions.sendKeys(code).perform();
		btnRun.click();
	}

	
	public void verifyHomePage() {
		Assert.assertEquals(VerifyHomepage.getText(), "You are logged in");
	}
	public void verifyArrayPage() {
		Assert.assertEquals(verifyArrayspage.getText(), "Array");
	}
	public void getstartedArray() {
		btnArrayGetstarted.click();
	}
	public void clickArraysInPython() {
		lnkArraysInPython.click();
	}
	public void clickTryHere() {
		btnTryEditor.click();
	}
	public void verifyRunButton() {
		Assert.assertEquals(btnRun.getText(), "Run");
	}
	public void verifyArraysInPythonText() {
		Assert.assertEquals(verifyArraysInPython.getText(), "Arrays in Python");
	}
	public void writeAndRunLinkedListCode(String code) throws IOException {
		Actions action=new Actions(driver);
		action.click(codeEditor).perform();
		action.sendKeys(code).perform();
		btnRun.click();
	}
	public String waitForAlertIfPresent() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	        String text = alert.getText();
	        alert.accept();
	        return text;
	    } catch (Exception e) {
	        return null; 
	    }
	}
}
