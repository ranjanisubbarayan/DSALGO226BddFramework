package pageObjects;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.ExcelSheetHandling;

public class LoginPage {
	
    private WebDriver driver;
    WebDriverWait wait;
    private Map<String, String> loginData;
   
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        PageFactory.initElements(driver, this); 
    }

    By loginUsername = By.id("id_username");
    By loginPassword = By.id("id_password");
    By loginBtn = By.xpath("//input[@value='Login']");
    By alertMsg = By.xpath("//div[@role='alert']");
    By loggedIn = By.xpath("//div[@role='alert']");
    By ishomePageDisplayed = By.xpath("//a[text()='NumpyNinja']");
	
 

   
    public void clickLoginButton() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn));
    	wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        driver.findElement(loginBtn).click();
    }    

    public void enterUsername(String username) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.presenceOfElementLocated(loginUsername));
    	wait.until(ExpectedConditions.elementToBeClickable(loginUsername));
        driver.findElement(loginUsername).sendKeys(username);
    }

    public void enterPassword(String password) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn));
    	wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        driver.findElement(loginPassword).sendKeys(password);
    }    
       
    public String getAlertMessage() {
        try {
        	return driver.findElement(alertMsg).getText();            
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isHomePageDisplayed() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ishomePageDisplayed));             
            return true;
        } catch (Exception e) {
            return false;
        }       
    }
    
    public void errorMessage(String expectedMessage) {
    	switch (expectedMessage) {
    	
        case "Home page displayed":
            Assert.assertTrue(isHomePageDisplayed(),
                    "Home page should be displayed but was NOT!");
            break;

        case "Please fill out this field":            
            String usernameFieldMsg = getUsernameValidationMessage();
            String passwordFieldMsg = getPasswordValidationMessage();
            Assert.assertTrue(!usernameFieldMsg.isEmpty() || !passwordFieldMsg.isEmpty(),
                    "validation message!");
            break;
        default:            
            String alertMsg = getAlertMessage();
            Assert.assertTrue(alertMsg.contains("Invalid"),
                    "Expected invalid login message, but got: " + alertMsg);
            break;
    }
    }    

    public String getUsernameValidationMessage() {
        WebElement username = driver.findElement(loginUsername);
        return (String)((JavascriptExecutor)driver).executeScript(
                "return arguments[0].validationMessage;", username);
    }

    public String getPasswordValidationMessage() {
        WebElement password = driver.findElement(loginPassword);
        return (String)((JavascriptExecutor)driver).executeScript(
                "return arguments[0].validationMessage;", password);
    }   
    
    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLoginButton();
    }
    
    public void loginUsingTestData(String testId) {
    	String path = Paths.get("src/test/resources/ExcelSheet/DsAlgoTestData.xlsx").toString();
        ExcelSheetHandling excel = new ExcelSheetHandling(path);
        loginData = excel.getRowData("Login", testId);
    }

    public void getDataFromExcel() {
    	enterUsername(loginData.get("username"));
    	enterPassword(loginData.get("password"));
        clickLoginButton();
    }
    
}
