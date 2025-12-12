package pageObjects;

import java.time.Duration;

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

    public StackPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//div[contains(text(),'You are logged in')]")
    private WebElement homePageMsg;

    @FindBy(xpath = "//h4[text()='Stack']")
    private WebElement stackPageHeader;

    @FindBy(xpath = "//a[contains(text(),'Get Started') and contains(@href,'stack')]")
    private WebElement stackGetStartedBtn;

    @FindBy(xpath = "//a[text()='Operations in Stack']")
    private WebElement operationsInStackLink;

    @FindBy(xpath = "//a[text()='Implementation']")
    private WebElement implementStackLink;

    @FindBy(xpath = "//a[text()='Applications']")
    private WebElement applicationStackLink;

    @FindBy(xpath = "//a[text()='Try Here']//parent::a | //a[text()='Try here>>>']")
    private WebElement tryHereButton;

    @FindBy(css = ".CodeMirror")
    private WebElement codeMirrorEditor;

    @FindBy(id = "output")
    private WebElement outputConsole;

    @FindBy(xpath = "//a[text()='Practice Questions']")
    private WebElement practiceQuestionsLink;

    @FindBy(xpath = "//button[contains(text(),'Run')]")
    private WebElement runButton;




    public void safeClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


 

    public void openStackPage() {
        driver.get("https://dsportalapp.herokuapp.com/stack/stack-applications/");
    }

    public boolean verifyIsOnStackPage() {
        waitForVisible(stackPageHeader);
        return stackPageHeader.isDisplayed();
    }

    public boolean verifyOperationsInStackVisible() {
        return operationsInStackLink.isDisplayed();
    }

    public void clickStackGetStarted() {
        safeClick(stackGetStartedBtn);
    }

    public void clickOperationsInStack() {
        scrollTo(operationsInStackLink);
        safeClick(operationsInStackLink);
    }

    public void clickImplementationStack() {
        safeClick(implementStackLink);
    }

    public void clickApplicationStack() {
        safeClick(applicationStackLink);
    }

    public void clickTryHere() {
        scrollTo(tryHereButton);
        safeClick(tryHereButton);
    }

    public void openTryEditorURL() {
        driver.get("https://dsportalapp.herokuapp.com/tryEditor");
    }


    public void enterCodeInEditor(String code) {
        waitForVisible(codeMirrorEditor);

        WebElement editor = codeMirrorEditor.findElement(By.cssSelector(".CodeMirror-code"));

        Actions actions = new Actions(driver);
        actions.click(editor)
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys(code)
                .perform();

        safeClick(runButton);

      
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert displayed: " + alert.getText());
            alert.accept();
        } catch (TimeoutException e) {
            waitForVisible(outputConsole);
            System.out.println("Code Output: " + outputConsole.getText());
        }
    }

    public void clickRunButton() {
        safeClick(runButton);

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert: " + alert.getText());
            alert.accept();
        } catch (TimeoutException e) {
            // No alert
        }
    }

  

    public void clickPracticeQuestions() {
        scrollTo(practiceQuestionsLink);
        safeClick(practiceQuestionsLink);
    }

    public void verifyPracticePage() {
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h3[contains(text(),'Practice Questions')]")
        ));
        Assert.assertTrue(header.isDisplayed(), "Practice Questions page is NOT displayed");
    }
}
