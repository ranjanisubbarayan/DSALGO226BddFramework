package utilities;

import org.openqa.selenium.WebDriver;

import pages.GraphPage;
import pages.LoginPage;
import pages.QueuePage;
import pages.StackPage;
import pages.homePage;
import pages.registerPage;

public class baseTest {
	
	public WebDriver driver;
	private homePage homepage;
	private registerPage registerpage;
	private LoginPage loginPage;
	private QueuePage queuePage;
	private StackPage stackPage;
	private GraphPage graphPage;
	
	 public WebDriver getDriver() {
		 if(driver == null) {
			 driver = DriverFactory.getDriver();
		 }
	        return driver;
	    }
	 
	public homePage getHomepage() {
		if(homepage == null) {
			homepage = new homePage(getDriver());
		}
		return homepage;
	}

	public LoginPage getLoginPage() {
		if(loginPage == null) {
			loginPage = new LoginPage(getDriver());
		}
		return loginPage;
	}
	public QueuePage getQueuepage() {
		if(queuePage == null) {
			queuePage = new QueuePage(getDriver());
		}
		return queuePage;
		
	
	}
	
	public GraphPage getGraphpage() {
		if(graphPage == null) {
			graphPage = new GraphPage();
		}
		return graphPage;
	}
	
	public StackPage getStackPage() {
		if(stackPage == null) {
			stackPage = new StackPage();
		}
		return stackPage;
	}
}
