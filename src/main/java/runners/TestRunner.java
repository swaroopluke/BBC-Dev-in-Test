package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/main/java/features/weather.feature",
		glue="stepDefinitions",
		strict=true,
		dryRun=false,
		monochrome = true,
		plugin={"pretty","html:test-output"}
		)
public class TestRunner {

}
