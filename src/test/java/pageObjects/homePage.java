package pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {

    private WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

  

    @FindBy(xpath = "//div[@class='alert alert-primary']")
    WebElement printerrormsg;

    @FindBy(xpath = "//button[text()='Get Started']")
    WebElement dsalgo_button;

    @FindBy(xpath = "//div[@id='navbarCollapse']/div[1]/div/a")
    WebElement datastrct_dropdown;

    @FindBy(xpath = "//div[@id='navbarCollapse']/div[1]/div/div/a[1]")
    WebElement array_dropdown;

    @FindBy(xpath = "//div[@id='navbarCollapse']/div[1]/div/div/a[2]")
    WebElement linkedlist_dropdown;

    @FindBy(xpath = "//div[@id='navbarCollapse']/div[1]/div/div/a[3]")
    WebElement stack_dropdown;

    @FindBy(xpath = "//div[@id='navbarCollapse']/div[1]/div/div/a[4]")
    WebElement queue_dropdown;

    @FindBy(xpath = "//div[@id='navbarCollapse']/div[1]/div/div/a[5]")
    WebElement tree_dropdown;

    @FindBy(xpath = "//div[@id='navbarCollapse']/div[1]/div/div/a[6]")
    WebElement graph_dropdown;

    @FindBy(xpath = "(//div[@class='card h-100']/div/a)[1]")
    WebElement ds_getstartbtn;

    @FindBy(xpath = "(//div[@class='card h-100']/div/a)[2]")
    WebElement ar_getstartbtn;

    @FindBy(xpath = "(//div[@class='card h-100']/div/a)[3]")
    WebElement ll_getstartbtn;

    @FindBy(xpath = "(//div[@class='card h-100']/div/a)[4]")
    WebElement stack_getstartbtn;

    @FindBy(xpath = "(//div[@class='card h-100']/div/a)[5]")
    WebElement queue_getstartbtn;

    @FindBy(xpath = "(//div[@class='card h-100']/div/a)[6]")
    WebElement tree_getstartbtn;

    @FindBy(xpath = "(//div[@class='card h-100']/div/a)[7]")
    WebElement graph_getstartbtn;

    @FindBy(xpath = "//div[@class='bs-example']/nav/a")
    WebElement homepageTitle;

    @FindBy(xpath = "//div[@id='navbarCollapse']/div[2]/ul/a[2]")
    WebElement regLink;

    @FindBy(xpath = "//div[@id='navbarCollapse']/div[2]/ul/a[3]")
    WebElement signinLink;

    @FindBy(xpath = "/html/body/div[2]")
    WebElement errormsg;

    

    public void openDSAlgoPortal() {
        driver.get("https://dsportalapp.herokuapp.com/");
    }

    public void clickGetStartedbutton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(dsalgo_button))
                .click();
    }

    public boolean isPageTitleDisplayed() {
        return homepageTitle.isDisplayed();
    }

    public boolean isRegAndSignInDisplayed() {
        return regLink.isDisplayed() && signinLink.isDisplayed();
    }

    public void clickDropdownMenu() {
        datastrct_dropdown.click();
    }

    public void clickArrayDropdown() {
        array_dropdown.click();
    }

    public void clickLinkedListDropdown() {
        linkedlist_dropdown.click();
    }

    public void clickStackDropdown() {
        stack_dropdown.click();
    }

    public void clickQueueDropdown() {
        queue_dropdown.click();
    }

    public void clickTreeDropdown() {
        tree_dropdown.click();
    }

    public void clickGraphDropdown() {
        graph_dropdown.click();
    }

    public void clickDataStructureGetStarted() {
        ds_getstartbtn.click();
    }

    public void clickArrayGetStarted() {
        ar_getstartbtn.click();
    }

    public void clickLinkedListGetStarted() {
        ll_getstartbtn.click();
    }

    public void clickStackGetStarted() {
        stack_getstartbtn.click();
    }

    public void clickQueueGetStarted() {
        queue_getstartbtn.click();
    }

    public void clickTreeGetStarted() {
        tree_getstartbtn.click();
    }

    public void clickGraphGetStarted() {
        graph_getstartbtn.click();
    }

    public void showErrorMsg() {
        System.out.println("Error Message: " + errormsg.getText());
    }

}
