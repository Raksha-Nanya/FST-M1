package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features",
    glue = {"stepDefintions"},
    plugin = {"pretty","html:target/cucumber-reports/reports" },
    monochrome = true
    //tags = "@activity5"
)

public class ActivitiesRunner {
    //empty
} 
