package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
		// tags = "@Graph and @ArrayList",
		tags = "@smoke_Ll", glue = { "stepDefinitions", "base" }, monochrome = true, dryRun = false,
		// plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}

		plugin = { "pretty", "html:target/cucmber", "json:target/cucumber.json" })

// plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","html:target/ranani.html","json:target/cucumber.json" })

public class MainRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
