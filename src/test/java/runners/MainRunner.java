package runners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import driver.DriverFactory;
import utilities.ConfigReader;




@CucumberOptions(features = "src/test/resources/features",
                       // tags = "(@home or @register or @Login or @Graph or @Stack or @ArrayList) and @nonfunctional",
                        tags ="@home",
                        glue= {"stepDefinitions"},
				        monochrome=true, dryRun=false,
						plugin= {"pretty", "html:target/ranjani.html", "json:target/cucumber.json" ,
								  "rerun:target/rerun.txt" ,
								 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
			
public class MainRunner extends AbstractTestNGCucumberTests {

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setBrowser(@Optional String browser) {
    
    	String browserName = browser == null ? ConfigReader.getProperty("browser") :browser;
    	DriverFactory.setBrowser(browserName);  
    }
    
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
