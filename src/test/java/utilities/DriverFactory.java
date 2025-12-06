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

    // ---------- FIXED MAIN DRIVER CREATION ----------
    public static WebDriver getDriver() {

        // FIX: ThreadLocal itself is never null → check driver.get()
        if (driver.get() == null) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-autofill-keyboard-accessory-view");
            options.addArguments("--disable-features=AutofillServerCommunication,AutofillProfileCleanup");
            options.addArguments("--disable-features=PasswordGeneration,PasswordManagerOnboarding");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--incognito");

            driver.set(new ChromeDriver(options));
        }

        return driver.get();
    }

    // Optional: Cross-browser initializer
    public WebDriver initDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
            System.out.println("run test on chrome Driver");

        } else if (browser.equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver());
            System.out.println("run test on Firefox Driver");

        } else if (browser.equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());
            System.out.println("run test on edge Driver");

        } else {
            throw new RuntimeException("Invalid browser name: " + browser);
        }

        driver.get().manage().window().maximize();
        return driver.get();
    }

    // ---------- QUIT DRIVER ----------
    public void quitDriver() {

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
