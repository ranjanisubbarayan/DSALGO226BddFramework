package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchPage {	
	private WebDriver driver;
	private WebDriverWait wait;
	private By getStartedButton = By.xpath("//a[@href='/home']"); 

    public LaunchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public homePage clickGetStarted() {
        try {
            WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(getStartedButton));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);

            wait.until(ExpectedConditions.elementToBeClickable(btn));

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

        } catch (TimeoutException e) {
            throw new RuntimeException("Get Started button not found or not clickable!", e);
        }

        return new homePage(driver);
    }
    public boolean isPageLoaded() {
        try {
            WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(getStartedButton));
            return btn.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

 

}
