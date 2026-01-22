package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "@target/rerun.txt",   
    glue = {"stepDefinitions", "base"},
    plugin = {
        "pretty",
        "html:target/rerun-html-report",
        "json:target/rerun.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }
)
public class RerunRunner extends AbstractTestNGCucumberTests {
}
