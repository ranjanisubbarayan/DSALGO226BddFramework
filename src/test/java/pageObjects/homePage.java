package pageObjects;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ConfigReader;


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

    @FindBy(xpath = "//div[@id='navbarCollapse']/div[1]/div/a")
    WebElement datastrct_dropdown;

    @FindBy(xpath = "//a[@href='/array']")
    WebElement array_dropdown;

    @FindBy(xpath = "//div[@id='navbarCollapse']/div[1]/div/div/a[2]")
    WebElement linkedlist_dropdown;

    @FindBy(xpath = "//div[@id='navbarCollapse']/div[1]/div/div/a[3]")
    WebElement stack_dropdown;

    @FindBy(xpath = "//div[@id='navbarCollapse']/div[1]/div/div/a[4]")
    WebElement queue_dropdown;

    @FindBy(xpath = "//div[@id='navbarCollapse']/div[1]/div/div/a[5]")
    WebElement tree_dropdown;

    @FindBy(xpath = "//div[@id='navbarCollapse']/div[1]/div/div/a[6]")
    WebElement graph_dropdown;

    @FindBy(xpath = "(//div[@class='card h-100']/div/a)[1]")
    WebElement ds_getstartbtn;

    @FindBy(xpath = "(//div[@class='card h-100']/div/a)[2]")
    WebElement ar_getstartbtn;

    @FindBy(xpath = "(//div[@class='card h-100']/div/a)[3]")
    WebElement ll_getstartbtn;

    @FindBy(xpath = "(//div[@class='card h-100']/div/a)[4]")
    WebElement stack_getstartbtn;

    @FindBy(xpath = "(//div[@class='card h-100']/div/a)[5]")
    WebElement queue_getstartbtn;

    @FindBy(xpath = "(//div[@class='card h-100']/div/a)[6]")
    WebElement tree_getstartbtn;

    @FindBy(xpath = "(//div[@class='card h-100']/div/a)[7]")
    WebElement graph_getstartbtn;

    @FindBy(xpath = "//div[@class='bs-example']/nav/a")
    WebElement homepageTitle;

    @FindBy(xpath = "//div[@id='navbarCollapse']/div[2]/ul/a[2]")
    WebElement regLink;

    @FindBy(xpath = "//div[@id='navbarCollapse']/div[2]/ul/a[3]")
    WebElement signinLink;

    public void openDSAlgoPortal() {
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    public void clickGetStartedbutton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(dsalgo_button))
                .click();
    }

    public boolean isPageTitleDisplayed() {
        return homepageTitle.isDisplayed();
    }

    public boolean isRegAndSignInDisplayed() {
        return regLink.isDisplayed() && signinLink.isDisplayed();
    }

    private void safeClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void clickDropdownMenu() {
        datastrct_dropdown.click();
    }

    public void clickArrayDropdown() {
    	
    	//wait.until(ExpectedConditions.presenceOfElementLocated(array_dropdown)); // ensures DOM is ready
        wait.until(ExpectedConditions.visibilityOf(array_dropdown));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(array_dropdown)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", array_dropdown);
        }
    	 safeClick(datastrct_dropdown);
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
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement errorMsg = wait.until(ExpectedConditions.visibilityOf(printerrormsg));
	String text = errorMsg.getText();
	System.out.println(text);

	}


}
