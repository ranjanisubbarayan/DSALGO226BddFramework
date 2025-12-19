package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchPage {
	
	private WebDriver driver;
	private WebDriverWait wait;

    @FindBy(xpath = "//button[text()='Get Started']")
    private WebElement getStartedBtn;

    public LaunchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public homePage clickGetStarted() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getStartedBtn);
        return new homePage(driver);
    }

 

}
