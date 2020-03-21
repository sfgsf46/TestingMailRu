package steps;

import applitools.Screenshots;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.WeatherForecastPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class WeatherForecastPageSteps {
    private WeatherForecastPage weatherForecastPage;
    private WebDriver webDriver;
    private Screenshots screenshots;
    private static final Logger logger = Logger.getLogger(WeatherForecastPageSteps.class);

    public WeatherForecastPageSteps()
    {
        logger.info("tests are starting.....");
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
        logger.info("page initialization finished");
    }

    @Given("^enter mail.ru -forecast$")
    public void enterSite() {
        webDriver.get("http://mail.ru");
        weatherForecastPage = new WeatherForecastPage(webDriver);
    }

    @When("^click forecast button$")
    public void clickWeatherForecat (){
        weatherForecastPage.clickForecastButton();
        logger.info("click forecast button");
    }

    @And("^return home page -forecast$")
    public void clickHome (){
        weatherForecastPage.returnHomePage();
    }

    @Then("^Good, test positive! -forecast$")
    public void finishProgram (){
        screenshots = new Screenshots(webDriver);
        screenshots.screenSite("screen forecast page");
        weatherForecastPage.exitProgram();
    }
}
