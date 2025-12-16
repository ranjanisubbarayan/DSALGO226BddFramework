package pageObjects;

import java.time.Duration;
import java.util.Map;
import java.nio.file.Paths;

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

    public StackPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

  

    @FindBy(xpath = "//div[@class='alert alert-primary']")
    WebElement verifyHomepage;

    @FindBy(xpath = "//h4[text()='Stack']")
    WebElement verifyStackPageHeader;

    @FindBy(xpath = "//p[text()='Operations in Stack']")
    WebElement verifyOpertioninStack;

    @FindBy(xpath = "//p[text()='Implementation']")
    WebElement verifyImplementinStack;

    @FindBy(xpath = "//p[text()='Applications']")
    WebElement verifyApplicationStack;

    @FindBy(xpath = "//button[text()='Run']")
    WebElement run;

    @FindBy(xpath = "(//a[contains(text(),'Get Started')])[4]")
    WebElement btnStackGetStarted;

    @FindBy(xpath = "//a[text()='Operations in Stack']")
    WebElement linkOperationInStack;

    @FindBy(xpath = "//a[text()='Implementation']")
    WebElement linkImplementStack;

    @FindBy(xpath = "//a[text()='Applications']")
    WebElement linkApplicationStack;

    @FindBy(xpath = "//a[text()='Try here>>>']")
    WebElement tryHereButton;

    @FindBy(xpath = "//div[@class='CodeMirror-scroll']")
    WebElement codeEditor;

    @FindBy(id = "output")
    WebElement outputConsole;

    @FindBy(xpath = "//a[text()='Practice Questions']")
    WebElement practiceQuestionsLink;

 

    public void openStackPage() {
        driver.get(ConfigReader.getProperty("stackUrl"));
    }

    public void redirectedOperationinStackPage() {
        driver.get("https://dsportalapp.herokuapp.com/stack/operations-in-stack/");
    }

    public void practicePage() {
        driver.get("https://dsportalapp.herokuapp.com/stack/practice");
    }

    public void verifyHomePage() {
        Assert.assertTrue(verifyHomepage.isDisplayed(), "You are logged in");
    }

    public void verifyStackPage() {
        Assert.assertTrue(verifyStackPageHeader.isDisplayed(), "Stack");
    }

    public void verifyOperationInStack() {
        Assert.assertTrue(verifyOpertioninStack.isDisplayed(), "Operations in Stack");
    }

    public void verifyImplementInStack() {
        Assert.assertTrue(verifyImplementinStack.isDisplayed(), "Implementation");
    }

    public void verifyApplicationInStack() {
        Assert.assertTrue(verifyApplicationStack.isDisplayed(), "Applications");
    }

    public void verifyTryEditorPage() {
        Assert.assertTrue(run.isDisplayed(), "Run");
    }

    public void openTryEditorPage() {
        driver.get("https://dsportalapp.herokuapp.com/tryEditor");
    }

    public void clickstack_Getstarted_btn() {
        wait.until(ExpectedConditions.elementToBeClickable(btnStackGetStarted));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnStackGetStarted);
    }

    public void clickOperationsInStack() {
        linkOperationInStack.click();
    }

    public void clickImplementStackLink() {
        wait.until(ExpectedConditions.elementToBeClickable(linkImplementStack)).click();
    }

    public void clickApplicationStackLink() {
        wait.until(ExpectedConditions.elementToBeClickable(linkApplicationStack)).click();
    }

    public void clickPracticeQuestions() {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", practiceQuestionsLink);
        practiceQuestionsLink.click();
    }

    public void clickTryhereofoperation() throws InterruptedException {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", tryHereButton);
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tryHereButton);
    }

    public void clickTryHere() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tryHereButton);
    }

    public void clickRunButton() {
        run.click();
    }

    public void enterCodeInEditor(String code) {

        try {
            wait.until(ExpectedConditions.visibilityOf(codeEditor));
            WebElement cm = codeEditor.findElement(By.cssSelector(".CodeMirror-code"));

            Actions actions = new Actions(driver);
            actions.click(cm)
                   .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                   .sendKeys(Keys.DELETE)
                   .sendKeys(code)
                   .perform();

            run.click();

            try {
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                System.out.println("Alert displayed: " + alert.getText());
                alert.accept();
            } catch (TimeoutException e) {
                System.out.println("Output: " + outputConsole.getText());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void errorMessageinAlertWindow() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert Message: " + alert.getText());
            alert.accept();
        } catch (TimeoutException e) {
            System.out.println("No native alert appeared.");
        }
    }

    public void readDataFromExcel(String testId) {
        String path = Paths.get("src/test/resources/ExcelSheet/DsAlgoTestData.xlsx").toString();
        ExcelSheetHandling excel = new ExcelSheetHandling(path);

        stackphyTryEditData = excel.getRowData("phythonTryEditor", testId);

        if (stackphyTryEditData == null || stackphyTryEditData.isEmpty()) {
            throw new RuntimeException("Excel returned EMPTY/NULL data for testId: " + testId);
        }
    }

    public void getDataFromExcel() {
        openTryEditorPage();

        String valid = stackphyTryEditData.get("Valid Input");
        String invalid = stackphyTryEditData.get("Invalid Input");

        if (valid != null && !valid.isEmpty()) {
            enterCodeInEditor(valid);
        } else if (invalid != null && !invalid.isEmpty()) {
            enterCodeInEditor(invalid);
        } else {
            throw new RuntimeException("Both Valid Input and Invalid Input are empty");
        }
    }

    public void seeOutput() {
        System.out.println(outputConsole.getText());
    }
}
