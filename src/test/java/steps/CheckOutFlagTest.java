package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features/checkFlag.feature"
        ,tags = {"@CheckOut"}
)
public class CheckOutFlagTest {
}
