package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "src/test/java/Features",
                tags = "@productSearch",
                glue = "StepDefinitions",
                dryRun = false,
                monochrome = true,
                plugin = {"pretty", "html:target/test_output/cucumber.html", "json:target/test_output/cucumber.json",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class testRunner {
}
