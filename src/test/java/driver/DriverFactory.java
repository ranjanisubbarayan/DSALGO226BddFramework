package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import utilities.ConfigReader;

public class DriverFactory {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver;
        String browser = ConfigReader.getProperty("browser").toLowerCase().trim();

        switch (browser) {

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
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new ChromeDriver(chromeOptions);
            break;

        case "firefox":
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new FirefoxDriver(firefoxOptions);
            break;

        default:
            throw new IllegalArgumentException(
                    "Browser not supported: " + browser + 
                    " (check config.properties)"
            );
        }

        driver.manage().window().maximize();
        return driver;
    }

    public static void cleanupDriver() {
        if (webDriver.get() != null) {
            webDriver.get().quit();
            webDriver.remove();
        }
    }
}
