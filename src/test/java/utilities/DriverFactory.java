package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static DriverFactory instance = new DriverFactory();

    private DriverFactory() {}

    public static DriverFactory getInstance() {
        return instance;
    }
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(initDriver("chrome")); 
        }
        return driver.get();
    }

    private static WebDriver initDriver(String browser) {
        WebDriver localDriver;
        switch(browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments(
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
                localDriver = new ChromeDriver(options);
                break;
            case "firefox":
                localDriver = new FirefoxDriver();
                break;
            case "edge":
                localDriver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser: " + browser);
        }
        localDriver.manage().window().maximize();
        return localDriver;
    }



    
    public void quitDriver() {

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
