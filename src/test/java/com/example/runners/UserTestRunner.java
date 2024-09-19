package com.example.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/example/steps"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports/UserTestRunner.json", "junit:target/cucumber-reports/UserTestRunner.xml"},
        monochrome = true
)
public class UserTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

