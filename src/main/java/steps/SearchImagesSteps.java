package steps;

import applitools.Screenshots;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.SearchImages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class SearchImagesSteps {
    private SearchImages searchImages;
    private WebDriver webDriver;
    private Screenshots screenshots;
    private static final Logger logger = Logger.getLogger(SearchImagesSteps.class);

    public SearchImagesSteps()
    {
        logger.info("tests are starting.....");
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
        logger.info("page initialization finished");
    }

    @Given("^enter mail.ru -image$")
    public void enterSite() {
        webDriver.get("http://mail.ru");
        searchImages = new SearchImages(webDriver);
    }

    @When("^click image button$")
    public void clickWeatherForecat (){
        searchImages.clickSearchImage();
    }

    @And("^return home page -image$")
    public void clickHome (){
        searchImages.returnHomePage();
        logger.info("return home page");
    }

    @Then("^Good, test positive! -image$")
    public void finishProgram (){
        screenshots = new Screenshots(webDriver);
        screenshots.screenSite("screen image page");
        searchImages.exitProgram();
    }
}
