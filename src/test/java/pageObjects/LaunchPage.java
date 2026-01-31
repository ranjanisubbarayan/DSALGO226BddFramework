package pageObjects;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ConfigReader;

import java.util.List; 

public class LaunchPage {	
	 WebDriver driver;
	 WebDriverWait wait;
	  @FindBy(xpath = "//h1")
	  WebElement pageTitleText;

	  @FindBy(xpath = "//p")
	  List<WebElement> contentTexts;
	 
	  @FindBy(xpath = "//a")
	  List<WebElement> allLinks;
	    
	  @FindBy(xpath = "//button")
      WebElement getStartedButton;

    public LaunchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
       
    }
    
    public void openLaunchPage() {
    	 driver.get(ConfigReader.getProperty("baseUrl"));
    }
    
    public boolean isContentTextDisplayed(String expectedText) {
        for (WebElement text : contentTexts) {
            if (text.getText().trim().equalsIgnoreCase(expectedText.trim())) {
                return text.isDisplayed();
            }
        }
        return false;
    }
    
    public int getButtonCount() {
        int count = 0;
        for (WebElement link : allLinks) {
            if (link.getText().equalsIgnoreCase("Get Started")) {
                count++;
            }
        }
        return count;
    }

    public boolean isGetStartedButtonDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(getStartedButton));
        return getStartedButton.isDisplayed();
    }
    
    public String getGetStartedButtonText() {
        wait.until(ExpectedConditions.visibilityOf(getStartedButton));
        return getStartedButton.getText().trim();
    }
    public homePage clickGetStarted() {
        try {
            wait.until(ExpectedConditions.visibilityOf(getStartedButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getStartedButton);
            wait.until(ExpectedConditions.elementToBeClickable(getStartedButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getStartedButton);
        } catch (TimeoutException e) {
            throw new RuntimeException("Get Started button not found or not clickable!", e);
        }
        return new homePage(driver);
    }
    
 
}
