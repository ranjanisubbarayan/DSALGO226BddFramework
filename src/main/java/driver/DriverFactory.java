package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		if(webDriver.get()==null) {
			webDriver.set(createDriver());
		}
		return webDriver.get();
	}
	

	private static WebDriver createDriver() {
		WebDriver driver = null;

		String browserType = "chrome";
		switch (browserType) {
		case "chrome": {
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(chromeoptions);
			break;
		}
		case "firefox": {
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(chromeoptions);
			break;
		}
		}
		driver.manage().window().maximize();
		return driver;
	}
	public static void cleanupDriver() {
		webDriver.get().quit();
		webDriver.remove();
	}
}
