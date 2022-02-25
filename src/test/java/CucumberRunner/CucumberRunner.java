package CucumberRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/Features"}, glue={"StepDef"}, tags = "@selenium",plugin = {"html:target/cucumber-html-report.html","json:target/cucumber-reports/cucumber.json","junit:target/cucumber-reports/cucumber.xml"})
public class CucumberRunner {
}
