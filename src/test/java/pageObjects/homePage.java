package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {
	private WebDriver driver;
	private WebDriverWait wait; 
	
	public homePage(WebDriver driver)
	{
		this.driver = driver; 
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		PageFactory.initElements(driver, this); 
		} 
	
	By printerrormsg = By.xpath("//div[@class='alert alert-primary']");
	By dsalgo_button = By.xpath("//button[text()='Get Started']");
	By datastrct_dropdown =By.xpath("//div[@id='navbarCollapse']/div[1]/div/a"); 
	By array_dropdown = By.xpath("//div[@id='navbarCollapse']/div[1]/div/div/a[1]");
	By linkedlist_dropdown = By.xpath("//div[@id='navbarCollapse']/div[1]/div/div/a[2]");	
	By stack_dropdown = By.xpath("//div[@id='navbarCollapse']/div[1]/div/div/a[3]");
	By queue_dropdown = By.xpath("//div[@id='navbarCollapse']/div[1]/div/div/a[4]");
	By tree_dropdown = By.xpath("//div[@id='navbarCollapse']/div[1]/div/div/a[5]");
	By graph_dropdown = By.xpath("//div[@id='navbarCollapse']/div[1]/div/div/a[6]");
	
	By ds_getstartbtn = By.xpath("(//div[@class='card h-100']/div/a)[1]");
	By ar_getstartbtn = By.xpath("(//div[@class='card h-100']/div/a)[2]");
	By ll_getstartbtn = By.xpath("(//div[@class='card h-100']/div/a)[3]");
	By stack_getstartbtn = By.xpath("(//div[@class='card h-100']/div/a)[4]");
	By queue_getstartbtn = By.xpath("(//div[@class='card h-100']/div/a)[5]");
	By tree_getstartbtn = By.xpath("(//div[@class='card h-100']/div/a)[6]");
	By graph_getstartbtn = By.xpath("(//div[@class='card h-100']/div/a)[7]");
	
	By homepageTitle = By.xpath("//div[@class='bs-example']/nav/a");
	By regLink = By.xpath(" //div[@id='navbarCollapse']/div[2]/ul/a[2]");
	By signinLink = By.xpath(" //div[@id='navbarCollapse']/div[2]/ul/a[3]");
	By errormsg = By.xpath("/html/body/div[2]");
	
	
	public void openDSAlgoPortal() {
		
		driver.get("https://dsportalapp.herokuapp.com/");
	}	
	
	
	
	public void clickGetStartedbutton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dsalgo_button)).click();

	
	}
	
	public void isdisplayedPageTitle() {
		
		driver.findElement(homepageTitle).isDisplayed();
		
	}
	
	public void isdisplayedReg_Sign_link() {
		
		 driver.findElement(regLink).isDisplayed();
		driver.findElement(signinLink);
	}
	
	public void clickdropdown_menu() {
		
		driver.findElement(datastrct_dropdown).click();
		driver.findElement(array_dropdown).click();
			
	}
	public void click_array_dropdown() {
		driver.findElement(datastrct_dropdown).click();
		driver.findElement(array_dropdown).click();
		
	}
	
	public void click_linkedlist_dropdown() {
		
		driver.findElement(datastrct_dropdown).click();
		driver.findElement(linkedlist_dropdown).click();
	}
	
	public void click_stack_dropdown() {
		
		driver.findElement(datastrct_dropdown).click();
		driver.findElement(stack_dropdown).click();
	}
	
	public void click_queue_dropdown() {
		driver.findElement(datastrct_dropdown).click();
		driver.findElement(queue_dropdown).click();
		
	}
	
	public void click_tree_dropdown() {
		
		driver.findElement(datastrct_dropdown).click();
		driver.findElement(tree_dropdown).click();
		
	}
	 
	public void click_graph_dropdown() {
		
		driver.findElement(datastrct_dropdown).click();
		driver.findElement(graph_dropdown).click();
		
	}
	
	public void clickdatastrut_GetStarted_btn() {
		
		driver.findElement(ds_getstartbtn).click();	
	}
	
	public void clickarray_Getstarted_btn() {
		driver.findElement(ar_getstartbtn).click();
	}
	
	public void clicklinkdlist_Getstarted_btn() {
		driver.findElement(ll_getstartbtn).click();
	}
    public void clickstack_Getstarted_btn() {		
		
		driver.findElement(stack_getstartbtn).click();

	}
    public void clickqueue_Getstarted_btn() {
    	driver.findElement(queue_getstartbtn).click();
		
	}
    public void clicktree_Getstarted_btn() {
    	driver.findElement(tree_getstartbtn).click();
	}
    public void clickgraph_Getstarted_btn() {
    	driver.findElement(graph_getstartbtn).click();
		
	}
    
	
	public void showError_msg() {
		
		String printerror = driver.findElement(errormsg).getText();
		System.out.println("Error Message  :  "+printerror);
		
	}

	



}
