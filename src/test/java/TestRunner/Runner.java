
package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Feature",
        //format={"json:target/cucumber.json"},
        //plugin = {"json:resources/cucumber.json","html:resources/cucumber.html"},

        glue = "Steps",
        plugin = {"pretty","json:target/cucumber.json","html:target/cucumber.html", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        //tags = "@SmokeTest",
        monochrome = true
)
public class Runner{

}
