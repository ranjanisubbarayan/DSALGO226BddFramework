package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    //private static WebDriver driver;
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    private DriverFactory() {
    	
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
       
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-autofill-keyboard-accessory-view");
        options.addArguments("--disable-features=AutofillServerCommunication,AutofillProfileCleanup");
        options.addArguments("--disable-features=PasswordGeneration,PasswordManagerOnboarding");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-autofill-keyboard-accessory-view");
        options.addArguments("--disable-features=AutofillServerCommunication,AutofillProfileCleanup");
        options.addArguments("--disable-features=PasswordGeneration,PasswordManagerOnboarding");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--incognito");
        driver.set(new ChromeDriver(options));
        }
        return driver.get();
    }
    public static WebDriver initDriver(String browser) {
//    	switch (browser.toLowerCase()) {
//        case "chrome":
//            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
//            driver.set(new ChromeDriver());
//            break;
//
//        case "firefox":
//            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
//            driver.set(new FirefoxDriver());
//            break;
//
//        case "edge":
//            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver");
//            driver.set(new EdgeDriver());
//            break;
//
//        default:
//            throw new IllegalArgumentException("Invalid browser: " + browser);
//    }

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
            driver.set(new ChromeDriver());
            System.out.println("run test on chrome Driver");

        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver.set(new FirefoxDriver());
            System.out.println("run test on Firefox Driver");

        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver.set(new EdgeDriver());
            System.out.println("run test on edge Driver");
        }
            else {
                throw new RuntimeException("Invalid browser name: " + browser);
            }
        

        driver.get().manage().window().maximize();
        return driver.get();
    }


    public static void quitDriver() {
    WebDriver webdriver = driver.get();
        if (webdriver != null) {
            webdriver.quit();
            driver.remove();
        }
    }
}
