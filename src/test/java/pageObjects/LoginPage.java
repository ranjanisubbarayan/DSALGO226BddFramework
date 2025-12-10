package pageObjects;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ConfigReader;
import utilities.LoggerLoad;

public class LoginPage {

	private static final Logger logger = LoggerLoad.getLogger(LoginPage.class);
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize wait here
        PageFactory.initElements(driver, this); 
    }

    By signInLink = By.xpath("//div[@id='navbarCollapse']/div[2]/ul/a[3]");
    By loginUsername = By.id("id_username");
    By loginPassword = By.id("id_password");
    By loginBtn = By.xpath("//input[@value='Login']");
    By alertMsg = By.xpath("//div[contains(@class,'alert-primary')]");
    private By loggedInIndicator = By.xpath("//div[contains(text(),'You are logged in')]");
	
   
    public void openLoginPage() {
    	logger.info("Open Login Page");
        driver.get(ConfigReader.getProperty("loginUrl"));
    }

    public void clickSignInLink() {
    	
        driver.findElement(signInLink).click();
    }

    public void clickLoginButton() {
    	logger.info("User enter Login Button");
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn));
    	wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        driver.findElement(loginBtn).click();
    }
    public boolean isUserLoggedIn() {
        return driver.findElements(loggedInIndicator).size() > 0;
    }

    public void enterUsername(String username) {
    	logger.info("Entering username: " + username);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.presenceOfElementLocated(loginUsername));
    	wait.until(ExpectedConditions.elementToBeClickable(loginUsername));
        driver.findElement(loginUsername).sendKeys(username);
    }

    public void enterPassword(String password) {
    	logger.info("Entering username: " + password);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn));
    	wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        driver.findElement(loginPassword).sendKeys(password);
    }
    
    public boolean isLoggedIn() {
    	try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sign out']")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public String getAlertMessage() {
        try {
            return driver.findElement(By.cssSelector("div.alert")).getText();
            
        } catch (Exception e) {
            return "";
        }
    }


    public String getAlertMessage1() {
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(alertMsg));
        return alert.getText();
    }

    public boolean isHomePageDisplayed() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='NumpyNinja']"))); 
            
            return true;
        } catch (Exception e) {
            return false;
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

    
}
