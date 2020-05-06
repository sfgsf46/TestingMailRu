package steps;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses ({
        MyCloudTest.class,
        ZodiacPageTest.class,
        CorporationPageTest.class,
        SearchImagesTest.class,
        WeatherForecastPageTest.class
})
public class AllTest {
}
