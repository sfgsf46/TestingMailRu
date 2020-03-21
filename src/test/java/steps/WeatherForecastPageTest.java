package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features/buttonTest.feature"
        ,tags = {"@Forecast"}
)
public class WeatherForecastPageTest {
}
