package pageObjects; 
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions; 
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert; 
public class StackPage { 
	
	private WebDriver driver;
	private WebDriverWait wait; 
	
	public StackPage(WebDriver driver)
	{
		this.driver = driver; 
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		PageFactory.initElements(driver, this); 
		} 
	
	By verifyHomepage = By.xpath("//div[contains(text(),'You are logged in')]"); 
	By verifyStackPageHeader = By.xpath("//h4[text()='Stack']"); 
	By btnStackGetStarted = By.xpath("//a[contains(text(),'Get Started') and contains(@href,'stack')]"); 
	//private By linkOperationInStack = By.xpath("//a[text()='Operations in Stack']"); 
	By linkOperationInStack = By.xpath("//a[text()='Operations in Stack']");
	By stackGetStartedBtn = By.xpath("//a[contains(text(),'Get Started') and contains(@href,'stack')]"); 
	By linkImplementStack = By.xpath("//a[text()='Implementation']"); 
	By linkApplicationStack = By.xpath("//a[text()='Applications']");
	By tryHereButton = By.xpath("//a[text()='Try Here']"); 
	//By btnRun = By.xpath("//button[text()='Run']");
	By codeEditor = By.xpath("//form[@id='answer_form']/div/div"); 
	By outputConsole = By.xpath("//pre[@id='output']"); 
	By practiceQuestionsLink = By.xpath("//a[text()='Practice Questions']"); 
	@FindBy (xpath="//button[contains(text(),'Run')]") 
	WebElement btnRun; 
	

	
	public void openStackPage() { 
		driver.get("https://dsportalapp.herokuapp.com/stack/stack-applications/"); 
		} 
	public void openTryEditor() { 
		driver.get("https://dsportalapp.herokuapp.com/tryEditor"); 
		}

	
	public boolean verifyHomePage() { 
		try { 
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
			wait.until(ExpectedConditions.urlContains("/home")); 
			// Or actual dashboard URL 
			return driver.getCurrentUrl().contains("/home"); 
			} catch (Exception e) {
				System.out.println("Home page verification failed: " + e.getMessage()); return false; 
				} } 
			public boolean verifyStackPage() 
		{ 
			try { return wait.until(ExpectedConditions.visibilityOfElementLocated(verifyStackPageHeader)).isDisplayed(); 
		} catch (TimeoutException e) { 
			return false; 
			}
		} public boolean verifyOperationsInStack()
		{ try { 
			return wait.until(ExpectedConditions.visibilityOfElementLocated(linkOperationInStack)).isDisplayed(); 
			} catch (TimeoutException e) { 
				return false; 
				} 
		}
		public void verifyImplementationPage() { 
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Implementation')]"))); 
			Assert.assertTrue(heading.isDisplayed(), "Implementation page is not displayed!");
			}
		public boolean verifyImplementStack() {
			try { 
				return wait.until(ExpectedConditions.visibilityOfElementLocated(linkImplementStack)).isDisplayed();
				} catch (TimeoutException e) { 
					return false;
					}
			}
		public boolean verifyApplicationStack() { 
				try { 
					return wait.until(ExpectedConditions.visibilityOfElementLocated(linkApplicationStack)).isDisplayed(); 
					} catch (TimeoutException e) { 
						return false;
						} 
				} 
		
		public boolean verifyOutput() { 
			try { 
				String text = wait.until(ExpectedConditions.visibilityOfElementLocated(outputConsole)).getText(); 
				return !text.isEmpty(); 
				} catch (TimeoutException e) { 
					return false;
					} 
			}
		public void verifyPracticePage() { 
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
			WebElement practiceHeader = wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//h3[contains(text(),'Practice Questions')]") )); 
			Assert.assertTrue(practiceHeader.isDisplayed(), "Practice Questions page is not displayed");
			} 
		public boolean isUserOnStackPage() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
			return wait.until(ExpectedConditions.urlContains("/stack/"));
			} 
		
		public void clickstack_Getstarted_btn() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
			WebElement stackBtn = wait.until(ExpectedConditions.elementToBeClickable( By.xpath("(//a[contains(text(),'Get Started')])[4]") ));
			 
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", stackBtn); 
			
			} 
		
		public void getStartedStack() { 
			
			wait.until(ExpectedConditions.elementToBeClickable(btnStackGetStarted)).click();
			} 
		
		public void clickOperationsInStack() { 
			
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
				WebElement operationsBtn = wait.until(ExpectedConditions.elementToBeClickable(linkOperationInStack)); 
				
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", operationsBtn); 
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", operationsBtn);
				} 
			
			public void clickImplementStackLink() { 
				 
				wait.until(ExpectedConditions.elementToBeClickable(linkImplementStack)).click();; 
				
				} 
			public void clickApplicationStackLink() {
				
				wait.until(ExpectedConditions.elementToBeClickable(linkApplicationStack)).click(); 
				}
			
			public void clickPracticeQuestions() { 

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
				
				WebElement practiceLink = wait.until(ExpectedConditions.elementToBeClickable( By.xpath("//a[normalize-space(.)='Practice Questions']") ));
				
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", practiceLink); 
				 
			}	
		
			public void clickTryhereofoperation() throws InterruptedException {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				JavascriptExecutor js = (JavascriptExecutor) driver;

				WebElement tryHereButton = wait.until(
				        ExpectedConditions.presenceOfElementLocated(
				                By.xpath("//a[text()='Try here>>>']"))
				);
				js.executeScript("arguments[0].scrollIntoView(true);", tryHereButton);
				js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", tryHereButton);

				Thread.sleep(500);

				js.executeScript("arguments[0].click();", tryHereButton);

			}
			public void clickTryHere()  {
				WebElement btn = driver.findElement(By.xpath("//a[text()='Try here>>>']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

			}

				public void verifyRunButton() {
				   
				    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				    try {
				        WebElement runBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
				            By.xpath("//button[contains(text(),'Run')]")
				        ));
				        if(runBtn.isDisplayed()) {
				            System.out.println("Run button is visible");
				        }
				    } catch (TimeoutException e) {
				        System.out.println("Run button not found inside iframe");
				        throw e;
				    } finally {
				        driver.switchTo().defaultContent(); // exit iframe after verification
				    }
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

				public void clickRunButton() {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					
					WebElement runButton = driver.findElement(By.xpath("//button[contains(text(),'Run')]"));					
     				js.executeScript("arguments[0].click();", runButton);

					
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
					try {
					    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
					    System.out.println("Alert Text: " + alert.getText());
					    alert.accept();  
					} catch (TimeoutException e) {
					    
					}
				}
		
	
}