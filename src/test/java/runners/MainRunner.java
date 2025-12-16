package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;
import utilities.ExtentTestNGListener;


@Listeners(ExtentTestNGListener.class)

@CucumberOptions(features = "src/test/resources/features", 
                     tags = "@home or @register or @Login or @Graph or @Stack or @ArrayList or @smoke_L1",
            		
				glue= {"stepDefinitions","base"}, 
				monochrome=true, dryRun=false,
						plugin= {"pretty", "html:target/ranjani.html", "json:target/cucumber.json"})
			
public class MainRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
