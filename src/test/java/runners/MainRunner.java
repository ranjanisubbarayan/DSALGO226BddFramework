package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;
import utilities.ExtentTestNGListener;


@Listeners(ExtentTestNGListener.class)

@CucumberOptions(features = "src/test/resources/features", 
             // tags = "@home or @register or @login or @Graph or @ArrayList or @smoke_L1",
				//tags = "@smoke_Ll",
               //  tags= "@Graph",
               // tags = "@home",
				glue= {"stepDefinitions","base"}, 
				monochrome=true, dryRun=false,
						plugin= {"pretty", "html:target/ranjani.html", "json:target/cucumber.json"})
			//plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
	

			//	plugin= {"pretty", "html:target/cucmber", "json:target/cucumber.json"})

			//	plugin= {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","html:target/ranani.html", "json:target/cucumber.json"})
                
		//plugin = { "pretty", "html:target/cucmber", "json:target/cucumber.json" })

// plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","html:target/ranani.html","json:target/cucumber.json" })

public class MainRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
