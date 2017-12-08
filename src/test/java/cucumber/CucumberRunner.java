package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = {"json:target/cucumber-report.json", "html:target/cucumber-report"},
                            features = {"src/test/resources/cucumber_features/FirstTest.feature"},
                            glue = {"steps"})

public class CucumberRunner  extends AbstractTestNGCucumberTests {

}
