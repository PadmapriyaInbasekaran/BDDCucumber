package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target\\report-folder"},
        monochrome = false,
        features = "src\\test\\java\\features\\login.feature",
        glue = "stepDefinition",
        dryRun = false
        //tags = "smoke"
)
public class login {
}
