package steps;

import applitools.Screenshots;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.CorporationPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class CorporationPageSteps {
    private CorporationPage corporationPage;
    private WebDriver webDriver;
    private Screenshots screenshots;
    private static final Logger logger = Logger.getLogger(CorporationPageSteps.class);

    public CorporationPageSteps()
    {
        logger.info("tests are starting.....");
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
        logger.info("page initialization finished");
    }

    @Given("^enter mail.ru -corporation info$")
    public void enterSite() {
        webDriver.get("http://mail.ru");
        corporationPage = new CorporationPage(webDriver);
    }

    @When("^click corporation info button$")
    public void clickCorporation (){
        corporationPage.clickCorporationButton();
        logger.info("click corporation info button");
    }

    @Then("^Good, test positive! -corporation info$")
    public void finishProgram (){
        screenshots = new Screenshots(webDriver);
        screenshots.screenSite("screen corporation page");
        corporationPage.exitProgram();
    }
}
