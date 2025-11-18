package pageObjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='btn']")
	WebElement btnGetstarted;
	
	@FindBy(xpath="//a[@href='/login']")
	WebElement btnSignin;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement txtUsername;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnSubmit;
	
	public void loginApplication(String userName, String Password) {
		btnGetstarted.click();
		btnSignin.click();
		txtUsername.sendKeys(userName);
		txtPassword.sendKeys(Password);
		btnSubmit.click();
	}
	public void goTo() {
		driver.get("https://dsportalapp.herokuapp.com/");
	}
	
	public boolean isLoggedIn() {
        return driver.getCurrentUrl().contains("home");
    }

}

