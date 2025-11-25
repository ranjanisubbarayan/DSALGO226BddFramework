package driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		if (webDriver.get() == null) {
			webDriver.set(createDriver());
		}
		return webDriver.get();
	}

	private static WebDriver createDriver() {
		WebDriver driver = null;

		switch (getBrowserType()) {
		case "chrome": {
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(chromeoptions);
			break;
		}
		case "firefox": {
			FirefoxOptions firefoxoptions = new FirefoxOptions();
			firefoxoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new FirefoxDriver(firefoxoptions);
			break;
		}
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static String getBrowserType() {
		String browserType = null;
		try {

			Properties properties = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/properties/config.properties");
			properties.load(fis);
			browserType = properties.getProperty("browser").toLowerCase().trim();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return browserType;
	}

	public static void cleanupDriver() {
		webDriver.get().quit();
		webDriver.remove();
	}
}
