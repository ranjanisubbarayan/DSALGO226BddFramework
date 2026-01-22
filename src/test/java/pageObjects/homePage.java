package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class homePage {

    private WebDriver driver;
    private WebDriverWait wait;
    JavascriptExecutor js;
    
    public homePage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    private By registerLink = By.xpath("//a[@href='/register']");
    private By loginLink = By.xpath("//a[@href='/login']");
    private By logoutLink = By.xpath("//a[@href='/logout']");
    private By homeTitle = By.xpath("//a[@href='/home']");
    private By getStartedButton = By.xpath(".//a[normalize-space()='Get Started']");
    private By errorMsg = By.xpath("//div[contains(text(),'You are not logged in')]");
    private By dropdownMenu = By.xpath("//a[contains(text(),'Data Structures')]");
    private By dropdownItems = By.xpath("//div[contains(@class,'dropdown-menu')]//a");
    private By dataStructureCard = By.xpath("//div[contains(@class,'card')]");
    private By cardTitle = By.xpath(".//h5[contains(@class,'card-title')]");
    private By signinlink = By.xpath("//a[normalize-space()='Sign in']");
    

    public void openDropdownOnly() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownMenu));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dropdownItems));
    }
    
    public List<String> getAllDropdownModules() {
    	return driver.findElements(dropdownItems)
                .stream()
                .map(e -> e.getText().trim())
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());
    }

    public void clickModuleFromDropdown(String moduleName) {
       
        List<WebElement> items = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownItems));
        for (WebElement item : items) {
            if (item.getText().trim().equalsIgnoreCase(moduleName.trim())) {
                item.click();
                return;
            }
        }
        throw new RuntimeException(" Module '" + moduleName + "' not found in dropdown");
        }
    
    private void scrollAndClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    
    public void waitForHomePageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeTitle));
    }
   
    public boolean isHomePageDisplayed() {
    	try {
            return driver.findElement(homeTitle).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isRegisterLinkDisplayed() {
        return driver.findElement(registerLink).isDisplayed();
    }

    public boolean isSignInLinkDisplayed() {
        return driver.findElement(loginLink).isDisplayed();
    }

    public boolean isUserLoggedIn() {
        return driver.findElements(logoutLink).size() > 0;
    }

    public registerPage clickRegisterLink() {
        scrollAndClick(driver.findElement(registerLink));
        return new registerPage(driver);
    }

    public LoginPage clickSignInLink() {
        scrollAndClick(driver.findElement(loginLink));
        return new LoginPage(driver);
    }

    public LoginPage clickSignOut() {
        List<WebElement> links = driver.findElements(logoutLink);
        if (!links.isEmpty()) scrollAndClick(links.get(0));
        return new LoginPage(driver);
    }

    public void clickAllDropdownModulesSafely() {
        String[] modules = {"Arrays", "Linked List", "Stack", "Queue", "Tree", "Graph"};
        for (String moduleName : modules) {
            clickModuleFromDropdown(moduleName);
            driver.navigate().back();
            waitForHomePageToLoad();
        }
    }
    
    public void clickGetStartedForModule(String moduleName) {

        List<WebElement> cards = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(dataStructureCard));
        for (WebElement card : cards) {
            WebElement title = card.findElement(cardTitle);
            String actualTitle = normalize(title.getText());
            String expectedTitle = normalize(moduleName);
            if (actualTitle.contains(expectedTitle)
                    || expectedTitle.contains(actualTitle)) {
                WebElement getStartedBtn = card.findElement(getStartedButton);
                scrollAndClick(getStartedBtn);
                return;
            }
        }
        throw new RuntimeException("Module '" + moduleName + "' not found in Data Structures cards.");
    }

    private String normalize(String text) {
        return text
                .toLowerCase()
                .replace("–", "-")   
                .replace("—", "-")   
                .replaceAll("\\s+", " ")
                .trim();
    }

    public String getWarningMessageText() {
    	try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
            String text = alert.getText();
            System.out.println("Alert displayed: " + text);
            return text;
        } catch (TimeoutException e) {
           
            try {
                WebElement alertFallback = driver.findElement(errorMsg);
                String text = alertFallback.getText();
                System.out.println("Alert found without waiting: " + text);
                return text;  
            } catch (NoSuchElementException ex) {
                System.out.println("Warning message still not found!");
                return "";  
            }
        }
    }
    
    public void clickSignInLinkIfPresent() {
        List<WebElement> signInLinks =
                driver.findElements(loginLink);        
        if (!signInLinks.isEmpty()) {
            signInLinks.get(0).click();
        }
    }

    public void navigateToHomePage() {
        driver.get("https://dsportalapp.herokuapp.com/home");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getStartedButton));
    }
    public boolean areImportantOptionsVisible() {
    	try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement getStarted = wait.until(ExpectedConditions.visibilityOfElementLocated(getStartedButton));
            WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(signinlink));
            return getStarted.isDisplayed() && signIn.isDisplayed();
        } catch (Exception e) {
        	System.out.println("Important home page options not visible: " + e.getMessage());
            return false;
        }
    }
    public void signOutIfLoggedIn() {
        try {
            List<WebElement> logoutLinks = driver.findElements(logoutLink);
            if (!logoutLinks.isEmpty()) {
                System.out.println("User is logged in. Signing out...");
                logoutLinks.get(0).click();

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.visibilityOfElementLocated(signinlink));

                System.out.println("Sign out completed.");
            } else {
                System.out.println("User is not logged in. No sign out needed.");
            }
        } catch (Exception e) {
            System.out.println("Exception while trying to sign out: " + e.getMessage());
        }
    }


}