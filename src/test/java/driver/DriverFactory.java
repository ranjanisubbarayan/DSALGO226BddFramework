package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
	
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static ThreadLocal<String> browserName = new ThreadLocal<>();

    public static void setBrowser(String browser) {
        browserName.set(browser);
    }
    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver(browserName.get()));
        }
        return webDriver.get();
    }

    private static WebDriver createDriver(String browser) {
     
        System.out.println(" Browser : " + browser);
        switch (browser.toLowerCase()) {

        case "chrome":
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(
                    "--disable-save-password-bubble",
                    "--disable-autofill-keyboard-accessory-view",
                    "--disable-features=AutofillServerCommunication,AutofillProfileCleanup",
                    "--disable-features=PasswordGeneration,PasswordManagerOnboarding",
                    "--start-maximized",
                    "--disable-notifications",
                    "--disable-infobars",
                    "--disable-extensions",
                    "--incognito"
            );
            return new ChromeDriver(chromeOptions);

        case "firefox": 
        	//webDriver.set(new FirefoxDriver());
        	FirefoxOptions firefoxOptions = new FirefoxOptions();
        	firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);            
            return new FirefoxDriver(firefoxOptions);

        case "edge":
        	//webDriver.set(new EdgeDriver());
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            return new EdgeDriver(edgeOptions);

        default:
            throw new IllegalArgumentException("Unsupported browser: " + browser);
    }
    }

    public static void cleanupDriver() {
        if (webDriver.get() != null) {
            webDriver.get().quit();
            webDriver.remove();
        }
    }
}
