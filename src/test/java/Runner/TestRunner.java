package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features/Login.feature"},
        glue = {"StepDefns"},
        plugin = {"pretty","html: cucumber-reports/reports.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        publish = true
)


public class TestRunner {
}
