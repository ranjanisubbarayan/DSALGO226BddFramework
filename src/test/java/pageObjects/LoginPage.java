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

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

  
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    
    @FindBy(xpath = "//div[@id='navbarCollapse']/div[2]/ul/a[3]")
    WebElement signInLink;

    @FindBy(id = "id_username")
    WebElement loginUsername;

    @FindBy(id = "id_password")
    WebElement loginPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginBtn;

    @FindBy(xpath = "//div[contains(@class,'alert-primary')]")
    WebElement alertMsg;

    @FindBy(xpath = "//div[contains(text(),'You are logged in')]")
    WebElement loggedInIndicator;

    @FindBy(xpath = "//a[text()='Sign out']")
    WebElement signOutLink;


   
    public void openLoginPage() {
        driver.get(ConfigReader.getProperty("loginUrl"));
    }

    public void clickSignInLink() {
        wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(loginUsername)).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(loginPassword)).sendKeys(password);
    }

    public boolean isUserLoggedIn() {
        try {
            return loggedInIndicator.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoggedIn() {
        try {
            wait.until(ExpectedConditions.visibilityOf(signOutLink));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getAlertMessage() {
        try {
            return alertMsg.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isHomePageDisplayed() {
        return driver.getCurrentUrl().contains("/home");
    }

    public String getUsernameValidationMessage() {
        return (String) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].validationMessage;", loginUsername);
    }

    public String getPasswordValidationMessage() {
        return (String) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].validationMessage;", loginPassword);
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLoginButton();
    }
}
