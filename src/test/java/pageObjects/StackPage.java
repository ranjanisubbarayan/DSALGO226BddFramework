package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StackPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public StackPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h4[text()='Stack']")
    WebElement stackHeader;

    @FindBy(xpath = "//a[normalize-space()='Operations in Stack']")
    WebElement linkOperations;

    @FindBy(xpath = "//a[normalize-space()='Implementation']")
    WebElement linkImplementation;

    @FindBy(xpath = "//a[normalize-space()='Applications']")
    WebElement linkApplications;

    @FindBy(xpath = "//a[@href='stack']")
    WebElement btnStackGetStarted;

    @FindBy(xpath = "//a[normalize-space()='Practice Questions']")
    WebElement linkPractice;

    @FindBy(xpath="//a[@href='/tryEditor']")
    WebElement btnTryHere;

    @FindBy(xpath = "//pre[@role='presentation']")
    WebElement codeEditor;

    @FindBy(xpath="//button[contains(text(),'Run')]")
    WebElement btnRun;

    @FindBy(xpath="//pre[@id='output']")
	WebElement console;

    public void clickStackGetStarted() {
    	btnStackGetStarted.click();
    }

    public void clickOperationsInStack() {
    	linkOperations.click();
    }

    public void clickImplementStackLink() {
    	linkImplementation.click();
    }

    public void clickApplicationStackLink() {
    	linkApplications.click();
    }

    public void clickPracticeQuestions() {
    	linkPractice.click();
    }

    public void clickTryHere() {
    	btnTryHere.click();
    }

    public void writeAndRunStackCode(String code) {
        Actions actions = new Actions(driver);
        actions.click(codeEditor).perform();
        actions.sendKeys(code).perform();
        btnRun.click();
    }

    public boolean isStackPageDisplayed() {
        return stackHeader.isDisplayed();
    }

    public boolean isTryEditorDisplayed() {
        return btnTryHere.isDisplayed();
    }

    public boolean isRunButtonDisplayed() {
        return btnRun.isDisplayed();
    }

    public String getOutput() {
        return console.getText();
    }

    public String waitForAlertIfPresent() {
        try {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String text = alert.getText();
            alert.accept();
            return text;
        } catch (Exception e) {
            return null;
        }
    }
}
