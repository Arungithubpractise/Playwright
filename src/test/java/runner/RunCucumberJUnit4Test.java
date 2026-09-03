package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"steps"},
    plugin = {"pretty", "html:target/cucumber-html-report.html"},
    monochrome = true
)
public class RunCucumberJUnit4Test {
    // This class will be discovered by JUnit and run Cucumber scenarios via the JUnit4 runner.
}
