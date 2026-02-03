package runners;


import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;





@CucumberOptions(features = "src/test/resources/features",
                        tags = "(@home or @register or @Login or @Graph or @Stack or @ArrayList) and @nonfunctional",
                      //  tags ="@nonfunctional",
                        glue= {"stepDefinitions"},
				        monochrome=true, dryRun=false,
						plugin= {"pretty", "html:target/ranjani.html", "json:target/cucumber.json" ,
								  "rerun:target/rerun.txt" ,
								 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
			
public class MainRunner extends AbstractTestNGCucumberTests {

    
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
