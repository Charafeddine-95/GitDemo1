package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//cucumber -> TestNG, junit
@CucumberOptions(features="src/test/java/cucumber", glue="stepDefinitions", monochrome = true, plugin = {"html:target/cucumber.html"}, tags = "@Regression")
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
