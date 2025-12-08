package pageObjects;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.DataDriven;

public class LinkedListPage {
	private WebDriver driver;

	public LinkedListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy (xpath="//a[@href='linked-list']")
	WebElement btnLinkedListGetstarted;
	
	@FindBy (xpath="//div/h4[text()='Linked List']")
	WebElement verifyLinkedListPage;
	
	@FindBy (xpath="//a[contains(text(),'Introduction')]")
	WebElement linkIntroduction;
	
	@FindBy (xpath="//a[@href='/tryEditor']")
	WebElement btnTryEditor;
	
	@FindBy (xpath="//pre[@role='presentation']")
	WebElement codeEditor;
	
	@FindBy (xpath="//button[contains(text(),'Run')]")
	WebElement btnRun;
	
	public void getstartedLinkedList() {
		btnLinkedListGetstarted.click();
	}
	public void verifyLinkedListPage() {
		Assert.assertEquals(verifyLinkedListPage.getText(), "Linked List");
	}
	public void clickIntroductionLink() {
		linkIntroduction.click();
	}
	public void clickTryHere() {
		btnTryEditor.click();
	}
	
	public void writeAndRunLinkedListCode(String code) throws IOException {
		Actions action=new Actions(driver);
		action.click(codeEditor).perform();
		action.sendKeys(code).perform();
		btnRun.click();
	}
	
}
