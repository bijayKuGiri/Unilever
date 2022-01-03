package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Feature/Magnum",
        //format={"json:target/cucumber.json"},
        //plugin = {"json:resources/cucumber.json","html:resources/cucumber.html"},

        glue = "Steps",
        plugin = {"pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        tags = "@template",
        monochrome = true
)
public class Runner_Template {
}
