package com.example.safari;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", tags = "@SafariTeste", glue = "com.example.safari.steps", monochrome = false, dryRun = false, plugin = {
        "pretty", "html:target/cucumber-report.html"
})
public class SafariTeste {
}
