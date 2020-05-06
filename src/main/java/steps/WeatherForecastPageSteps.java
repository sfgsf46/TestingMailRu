package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.WeatherForecastPage;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class WeatherForecastPageSteps {
    private WeatherForecastPage weatherForecastPage;
    private WebDriver webDriver;

    public WeatherForecastPageSteps() {
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
    }

    @Given("^enter mail.ru -forecast$")
    public void enterSite() {
        webDriver.get("http://mail.ru");
        weatherForecastPage = new WeatherForecastPage(webDriver);
    }

    @When("^click forecast button$")
    public void clickWeatherForecat (){
        weatherForecastPage.clickForecastButton();
    }

    @And("^return home page -forecast$")
    public void clickHome (){
        weatherForecastPage.returnHomePage();
    }

    @Then("^Good, test positive! -forecast$")
    public void finishProgram (){
        weatherForecastPage.exitProgram();
    }
}
