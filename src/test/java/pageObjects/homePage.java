package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class homePage {

    private WebDriver driver;

    private WebDriverWait wait;
    public homePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }  

    @FindBy(xpath = "//div[contains(text(),'You are not logged in')]")
    WebElement printerrormsg;

    @FindBy(xpath = "//button[text()='Get Started']")
    WebElement dsalgo_button;

    @FindBy(xpath = "//a[text()='Data Structures']")
    WebElement datastrct_dropdown;

    @FindBy(xpath = "//a[text()='Arrays']")
    WebElement array_dropdown;

    @FindBy(xpath = "//a[text()='Linked List']")
    WebElement linkedlist_dropdown;

    @FindBy(xpath = "//a[text()='Stack']")
    WebElement stack_dropdown;

    @FindBy(xpath = "//a[text()='Queue']")
    WebElement queue_dropdown;

    @FindBy(xpath = "//a[text()='Tree']")
    WebElement tree_dropdown;

    @FindBy(xpath = "//a[text()='Graph']")
    WebElement graph_dropdown;

    @FindBy(xpath = "//a[@href='data-structures-introduction']")
    WebElement ds_getstartbtn;

    @FindBy(xpath = "//a[@href='array']")
    WebElement ar_getstartbtn;

    @FindBy(xpath = "//a[@href='linked-list']")
    WebElement ll_getstartbtn;

    @FindBy(xpath = "//a[@href='stack']")
    WebElement stack_getstartbtn;

    @FindBy(xpath = "//a[@href='queue']")
    WebElement queue_getstartbtn;

    @FindBy(xpath = "//a[@href='tree']")
    WebElement tree_getstartbtn;

    @FindBy(xpath = "//a[@href='graph']")
    WebElement graph_getstartbtn;

    @FindBy(xpath = "//a[@href='/home']")
    WebElement homepageTitle;

    @FindBy(xpath = "//a[@href='/register']")
    WebElement regLink;

    @FindBy(xpath = "//a[@href='/login']")
    WebElement signinLink;

   
    public boolean isPageTitleDisplayed() {
        return homepageTitle.isDisplayed();
    }

    public boolean isRegAndSignInDisplayed() {
        return regLink.isDisplayed() && signinLink.isDisplayed();
    }

    private void safeClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void clickDropdownMenu() {
        datastrct_dropdown.click();
    }

    public void clickArrayDropdown() {
        safeClick(datastrct_dropdown);
        wait.until(ExpectedConditions.visibilityOf(array_dropdown));
        safeClick(array_dropdown);
       
    }

    public void clickLinkedListDropdown() {
    	datastrct_dropdown.click();
        linkedlist_dropdown.click();
        
    }

    public void clickStackDropdown() {
    	datastrct_dropdown.click();
        stack_dropdown.click();
    }

    public void clickQueueDropdown() {
    	datastrct_dropdown.click();
        queue_dropdown.click();
    }

    public void clickTreeDropdown() {
    	datastrct_dropdown.click();
        tree_dropdown.click();
    }

    public void clickGraphDropdown() {
        datastrct_dropdown.click();
        graph_dropdown.click();
    }

    public void clickDataStructureGetStarted() {
        ds_getstartbtn.click();
    }

    public void clickArrayGetStarted() {
        ar_getstartbtn.click();
    }

    public void clickLinkedListGetStarted() {
        ll_getstartbtn.click();
    }

    public void clickStackGetStarted() {
        stack_getstartbtn.click();
    }

    public void clickQueueGetStarted() {
        queue_getstartbtn.click();
    }

    public void clickTreeGetStarted() {
        tree_getstartbtn.click();
    }

    public void clickGraphGetStarted() {
        graph_getstartbtn.click();
    }

public void showError_msg() {
		
	 WebElement errorMsg = wait.until(ExpectedConditions.visibilityOf(printerrormsg));
	String text = errorMsg.getText();
	System.out.println(text);

	}


}
