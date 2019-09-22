package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features/DealMaps.feature",
		glue="stepDefinations",
		monochrome=true,
		dryRun=false,
		tags= {"@TestTest"},
		plugin= {"pretty","html:target/HTMLReport"}
		)

public class TestRunner {

}
