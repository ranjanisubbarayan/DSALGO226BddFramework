package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class registerPage {
	
	private WebDriver driver;
	//registerPage registerpage;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	By register_link = By.xpath("//div[@id='navbarCollapse']/div[2]/ul/a[2]");
	By register_username = By.id("id_username");
	By register_password = By.id("id_password1");
	By register_confirm_password = By.id("id_password2");
	By register_button = By.xpath("//input[@type='submit']");
	By registerpage_displayed = By.xpath("/html/body/div[2]/div/div[2]/form/span[3]");
	By printErrormsg = By.xpath("//div[@class='alert alert-primary']");
	By registeredsuccess = By.xpath("/html/body/div[2]/text()");
	private String generatedUsername;
	
	public registerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void open_DSALGO_registerPage() {
		driver.get("https://dsportalapp.herokuapp.com/register");
	}
	
	public void click_register_link() {
		driver.findElement(register_link).click();
	}
	
	public void isregisterpageDisplayed() {
		driver.findElement(registerpage_displayed).isDisplayed();
		
	}
	
	
	
	public void safeClick(By locator) {
        for (int i = 0; i < 3; i++) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                element.click();
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println("Retrying click, stale element found (attempt " + (i + 1) + ")");
            }
        }
    }
	
	public void enter_registerButton() {
		driver.findElement(register_button).click();
		safeClick(register_button);
	}
	
	public void clickwith_allEmptyfield() {
		driver.findElement(register_button).click();
		

	}
	public void show_errormsgforEmptyfield() {
		WebElement username = driver.findElement(register_username);

		
		String message = (String) ((JavascriptExecutor) driver)
		        .executeScript("return arguments[0].validationMessage;", username);

		System.out.println("Validation message: " + message);
	}
	
	public void show_errormessageunder_pswBox() {
		
		WebElement password = driver.findElement(register_password);
		String message = (String) ((JavascriptExecutor) driver)
		        .executeScript("return arguments[0].validationMessage;", password);

		System.out.println("Validation message: " + message);
		
	}
	
	public void show_errormsg_underpswconfirmBox() {
		
		WebElement passwordconfirm = driver.findElement(register_confirm_password);
		String message = (String) ((JavascriptExecutor) driver)
		        .executeScript("return arguments[0].validationMessage;", passwordconfirm);

		System.out.println("Validation message: " + message);
	}
	
	public void print_Errormsg() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement alertMsg = wait.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert-primary')]")));
		String msg = alertMsg.getText();
		System.out.println(msg);

		String printerror = driver.findElement(printErrormsg).getText();
		System.out.println("Error Message  :  "+printerror);
		
	}
	
	public void enter_registerUsername(String username) {
		driver.findElement(register_username).sendKeys(username);
		//driver.findElement(register_username).clear();
		
	}
	public void enter_regPassword(String password) {
		driver.findElement(register_password).sendKeys(password);
		//driver.findElement(register_password).clear();
	}
	public void enter_regPwdconfirm(String passwordconfirm) {
		driver.findElement(register_confirm_password).sendKeys(passwordconfirm);
		//driver.findElement(register_confirm_password).clear();
	}
	
	public String getValidationMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(register_username));

	    // Use JavaScript to get the HTML5 validation message
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    String message = (String) js.executeScript("return arguments[0].validationMessage;", usernameField);
	    
	    System.out.println("Password validation message: " + message); 
	    return message;
    }
	
	public String getPasswordValidationMessage() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(register_password));

		    // Use JavaScript to get the HTML5 validation message
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    String message = (String) js.executeScript("return arguments[0].validationMessage;", passwordField);
		    
		    System.out.println("Password validation message: " + message); 
		    return message;
    }

	
	
	 public void generate_newUsername() {
		 generatedUsername = return_genarateNewUsername();
		    driver.findElement(register_username).sendKeys(generatedUsername);
		    System.out.println("Print GeneratedUsername  :  "+generatedUsername);
		    
	 }
	 
	 public static String return_genarateNewUsername() {
		 String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(0));
	        return "user" + timestamp;
		}
		 public String getGeneratedUsername() {
		        return generatedUsername;
		    }
		 
		 
		 public void print_successfullyRegistered() {
				String printsuccess =driver.findElement(registeredsuccess).getText();
				System.out.println("Registered Succesfully :  " + printsuccess );
			}

}

