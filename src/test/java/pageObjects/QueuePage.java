package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import utilities.DriverFactory;

public class QueuePage {
	private WebDriver driver ;
	private WebDriverWait wait; 
	
	public QueuePage(WebDriver driver) {
	    this.driver = driver; 
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    PageFactory.initElements(driver, this); 
	} 

   
    @FindBy(xpath = "(//a[contains(text(),'Get Started')])[5]")
    public WebElement getStartedQueue;

    
    @FindBy(xpath =  "(//a[@class='list-group-item'])[1]")
    public WebElement implementationPython;

    @FindBy(xpath =  "(//a[@class='list-group-item'])[2]")
    public WebElement implementationDeque;

    @FindBy(xpath =  "(//a[@class='list-group-item'])[3]")
    public WebElement implementationArray;

    @FindBy(xpath =  "(//a[@class='list-group-item'])[4]")
    public WebElement queueOperations;

    @FindBy(xpath = "//a[text()='Practice Questions']")
    public WebElement practiceQuestions;

    @FindBy(xpath = "//a[text()='Implementation of Queue in Python']")
    public WebElement implementationPythonHeading;

    @FindBy(xpath = "//a[text()='Try here>>>']")
    public WebElement tryHereBtn;


    // Try Editor
    @FindBy(xpath = "(//form[@id='answer_form']/div/div/div[contains(@class,'CodeMirror')])[5]")
    public WebElement codeMirrorEditor;

    @FindBy(xpath = "//button[text()='Run']")
    public WebElement runBtn;

    @FindBy(id = "output")
    public WebElement outputConsole;
	
	
	
	public void openTryEditor() { 
		driver.get("https://dsportalapp.herokuapp.com/tryEditor"); 
		}
	
	 public void clickAction(String action) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    
		    WebElement element = null;

		    try {
		        switch (action) {
		            case "Getting Started":
		                element = wait.until(ExpectedConditions.elementToBeClickable(getStartedQueue));
		               
		                js.executeScript("arguments[0].click();", element);
		                //wait.until(ExpectedConditions.elementToBeClickable(getStartedQueue)).click();
		                
		                break;
		            case "Implementation of Queue in Python":
		            	element = wait.until(ExpectedConditions.elementToBeClickable(implementationPython));
		            	
		            	js.executeScript("arguments[0].click();", element);
		                //wait.until(ExpectedConditions.elementToBeClickable(implementationPython)).click();
		                break;
		            case "Implementation using collections.deque":
		                element = wait.until(ExpectedConditions.elementToBeClickable(implementationDeque));
		          
		                js.executeScript("arguments[0].click();", element);
		              //  wait.until(ExpectedConditions.elementToBeClickable(implementationDeque)).click();
		                break;
		            case "Implementation using array":
		                element = wait.until(ExpectedConditions.elementToBeClickable(implementationArray));
		            
		                js.executeScript("arguments[0].click();", element);
		              //  wait.until(ExpectedConditions.elementToBeClickable(implementationArray)).click();
		                break;
		            case "Queue Operations":
		                element = wait.until(ExpectedConditions.elementToBeClickable(queueOperations));
		             
		                js.executeScript("arguments[0].click();", element);
		               // wait.until(ExpectedConditions.elementToBeClickable(queueOperations)).click();
		                break;
		            case "Practice Questions":
		                element = wait.until(ExpectedConditions.elementToBeClickable(practiceQuestions));
		               
		                js.executeScript("arguments[0].click();", element);
		            ;
		                break;
		            case "Try Here":
		            	
		            	js.executeScript("arguments[0].click();", element);
		               
		                break;
		            case "Run without code":
		            case "Run with invalid code":
		            case "Run with valid code":
		            	
		                element = wait.until(ExpectedConditions.elementToBeClickable(runBtn));
		                wait.until(ExpectedConditions.elementToBeClickable(runBtn)).click();
		                break;
		            default:
		              
		        }

//		        // Scroll into view and click via JS
//		        js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", element);
//		        js.executeScript("arguments[0].click();", element);

		    } catch (Exception e) {
		        //throw new RuntimeException("Failed to perform action: " + action, e);
		    }
	    }
	
	public void click_Queue_Get_Started_button() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		WebElement stackBtn = wait.until(ExpectedConditions.elementToBeClickable( By.xpath("(//a[contains(text(),'Get Started')])[5]") ));
		 
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", stackBtn); 
		
		} 
		
	public void Click_Implementation_of_Queue_in_Python()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		WebElement stackBtn = wait.until(ExpectedConditions.elementToBeClickable( By.xpath("(//a[@class='list-group-item'])[1]") ));
		 
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", stackBtn); 
		
		} 
	
	public void click_Implementation_using_collections_deque() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		WebElement stackBtn = wait.until(ExpectedConditions.elementToBeClickable( By.xpath("(//a[@class='list-group-item'])[2]") ));
		 
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", stackBtn); 
		
		} 
	
	public void click_Implementation_using_array() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		WebElement stackBtn = wait.until(ExpectedConditions.elementToBeClickable( By.xpath("(//a[@class='list-group-item'])[3]") ));
		 
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", stackBtn); 		
	}
	
	public void click_Queue_Operations() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		WebElement stackBtn = wait.until(ExpectedConditions.elementToBeClickable( By.xpath("(//a[@class='list-group-item'])[4]") ));
		 
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", stackBtn); 
	}
	 
	public void enterCodeInEditor(String code) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    try {
       
        WebElement editorArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".CodeMirror")));
        WebElement cm = editorArea.findElement(By.cssSelector(".CodeMirror-code"));

        
        new Actions(driver).click(cm).perform();
        new Actions(driver)
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys(code)
                .perform();

        
        driver.findElement(By.xpath("//button[contains(text(),'Run')]")).click();

        
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            alert.accept();
            System.out.println("Alert displayed: " + alertText);
        } catch (TimeoutException e) {
           
            WebElement output = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));
            System.out.println("Code executed successfully. Output: " + output.getText());
        }

    } catch (Exception e) {
        
    }
	}

	 public boolean isAlertPresent() {
		 try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		        wait.until(ExpectedConditions.alertIsPresent());
		        return true;
		    } catch (Exception e) {
		        return false;
		    }
	    }

	    public String getAlertText() {
	        return driver.switchTo().alert().getText();
	    }

	    public void acceptAlert() {
	        driver.switchTo().alert().accept();
	    }

	    public String getConsoleOutput() {
	        try {
	            return outputConsole.getText().trim();
	        } catch (Exception e) {
	            return "";
	        }
	    }
	    public void waitForElementAndScroll(WebElement element, int timeoutSec) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
	        wait.until(ExpectedConditions.visibilityOf(element));
	        ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", element);
	    }
	
	    
	
}
