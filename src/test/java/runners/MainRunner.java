package runners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.ExtentTestNGListener;

@Listeners(ExtentTestNGListener.class)

@CucumberOptions(features = "src/test/resources/features", 
                        tags = "(@home or @register or @Login or @Graph or @Stack or @ArrayList) and @nonfunctional",
                        glue= {"stepDefinitions","base"}, 
				        monochrome=true, dryRun=false,
						plugin= {"pretty", "html:target/ranjani.html", "json:target/cucumber.json"})
			
public class MainRunner extends AbstractTestNGCucumberTests {

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setBrowser(@Optional String browser) {
    
        if (browser != null && !browser.isBlank()) {
            System.setProperty("browser", browser);
        }       
    }
    
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
