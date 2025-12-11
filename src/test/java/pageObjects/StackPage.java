package pageObjects; 
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions; 
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.ConfigReader;
import utilities.ExcelSheetHandling; 
public class StackPage { 
	
	private WebDriver driver;
	private WebDriverWait wait; 

	private Map<String, String> stackphyTryEditData;
	
	public StackPage(WebDriver driver)
	{
		this.driver = driver; 
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		PageFactory.initElements(driver, this); 
		} 
	
	By verifyHomepage = By.xpath("//div[@class='alert alert-primary']"); 
	By verifyStackPageHeader = By.xpath("//h4[text()='Stack']"); 
	By verifyOpertioninStack = By.xpath("//p[text()='Operations in Stack']");
	By verifyImplementinStack = By.xpath("//p[text()='Implementation']");
	By verifyApplicationStack = By.xpath("//p[text()='Applications']");
	By verifyTryEditorPage = By.xpath("//button[text()='Run']");
	By btnStackGetStarted = By.xpath("(//a[contains(text(),'Get Started')])[4]"); 
	By linkOperationInStack = By.xpath("//a[text()='Operations in Stack']");
	By linkImplementStack = By.xpath("//a[text()='Implementation']"); 
	By linkApplicationStack = By.xpath("//a[text()='Applications']");
	By tryHereButton = By.xpath("//a[text()='Try here>>>']"); 
	By codeEditor = By.xpath("//div[@class='CodeMirror-scroll']"); 
	By run = By.xpath("//button[text()='Run']");
	By outputConsole = By.id("output"); 
	By practiceQuestionsLink = By.xpath("//a[text()='Practice Questions']"); 
		
	public void openStackPage() { 
		driver.get(ConfigReader.getProperty("stackUrl")); 
		} 
	public void redirectedOperationinStackPage() { 
		driver.get("https://dsportalapp.herokuapp.com/stack/operations-in-stack/"); 
		}
	public class SessionManager {
	    public static boolean isLoggedIn = false;
	}
	

	public void practicePage() {
		driver.get("https://dsportalapp.herokuapp.com/stack/practice"); 
	}

	public void verifyHomePage() {
		 Assert.assertTrue( driver.findElement(verifyHomepage).isDisplayed(), "You are logged in" );
	}
	
	public void verifyStackPage() {
		driver.get(ConfigReader.getProperty("stackUrl"));
		Assert.assertTrue(driver.findElement(verifyStackPageHeader).isDisplayed(), "Stack");
		
	}
	public void verifyOperationInStack() {
		Assert.assertTrue(driver.findElement(verifyOpertioninStack).isDisplayed(), "Operations in Stack");
	}
	public void verifyImplementInStack() {
	  //  driver.get("https://dsportalapp.herokuapp.com/implementation"); 
		Assert.assertTrue(driver.findElement(verifyImplementinStack).isDisplayed(), "Implementation");
	}
	public void verifyApplicationInStack() {
		//driver.get("https://dsportalapp.herokuapp.com/applications");
		Assert.assertTrue(driver.findElement(verifyApplicationStack).isDisplayed(), "Applications");
	}
	public void verifyTryEditorPage() {
		//driver.get("https://dsportalapp.herokuapp.com/tryEditor");
		Assert.assertTrue(driver.findElement(verifyTryEditorPage).isDisplayed(), "Run");
	}
	public void openTryEditorPage() {
		driver.get("https://dsportalapp.herokuapp.com/tryEditor");
	}
				
		public void clickstack_Getstarted_btn() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
			WebElement stackBtn = wait.until(ExpectedConditions.elementToBeClickable(btnStackGetStarted));
			 
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", stackBtn); 
			
			} 
		
			
		public void clickOperationsInStack() { 
			
			driver.findElement(linkOperationInStack).click();
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
				WebElement tryHereBtn = driver.findElement(tryHereButton);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tryHereBtn);
				Thread.sleep(500);

				js.executeScript("arguments[0].click();", tryHereBtn);

			}
			public void clickTryHere()  {
				WebElement btn = driver.findElement(tryHereButton);
			
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

			}

				public void clickRunButton() {
				   
				    driver.findElement(run).click();
				}

				public void enterCodeInEditor(String code) {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			    try {
			       
			        WebElement editorArea = wait.until(ExpectedConditions.visibilityOfElementLocated(codeEditor));
			        WebElement cm = editorArea.findElement(By.cssSelector(".CodeMirror-code"));

			        
			        new Actions(driver).click(cm).perform();
			        new Actions(driver)
			                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
			                .sendKeys(Keys.DELETE)
			                .sendKeys(code)
			                .perform();

			        
			        driver.findElement(run).click();

			        
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
				public void errorMessageinAlertWindow() {
					 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
						Alert alert = null;

						try {
						   
						    alert = wait.until(ExpectedConditions.alertIsPresent());
						    
						   
						    String alertMsg = alert.getText();
						    System.out.println("Alert Message: " + alertMsg); 
						    alert.accept();
						   				    
						} catch (TimeoutException e) {
						    
						    System.out.println("No native alert appeared.");
						   
						}
				}
				public void readDataFromExcel(String testId) {
					String path = Paths.get("src/test/resources/ExcelSheet/DsAlgoTestData.xlsx").toString();
				    ExcelSheetHandling excel = new ExcelSheetHandling(path);

				    System.out.println("Reading Excel Sheet: phythonTryEditor, testId=" + testId);

				    stackphyTryEditData = excel.getRowData("phythonTryEditor", testId);

				    if (stackphyTryEditData == null || stackphyTryEditData.isEmpty()) {
				        throw new RuntimeException("Excel returned EMPTY/NULL data for sheet 'phythonTryEditor' and testId: " + testId);
				    }

				    System.out.println("Loaded Excel row: " + stackphyTryEditData);
				}

				public void getDataFromExcel() {
					openTryEditorPage();

				    String valid = stackphyTryEditData.get("Valid Input");
				    String invalid = stackphyTryEditData.get("Invalid Input");
				    
				    if (valid != null && !valid.isEmpty()) {
				        enterCodeInEditor(valid);
				    }
				    else if (invalid != null && !invalid.isEmpty()) {
				        enterCodeInEditor(invalid);
				    }
				    else {
				        throw new RuntimeException("Both Valid Input and Invalid Input columns are empty in Excel!");
				    }
				}
						
				public void seeOutput() {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			    	String output = wait.until(ExpectedConditions.visibilityOfElementLocated(outputConsole)).getText();
			       	System.out.println(output);
				}
	
}