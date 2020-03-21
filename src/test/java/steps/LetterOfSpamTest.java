package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features/operationsSpam.feature"
        ,tags = "@OfSpam")
public class LetterOfSpamTest {
}
