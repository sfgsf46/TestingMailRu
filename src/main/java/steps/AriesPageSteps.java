package steps;

import applitools.Screenshots;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.AriesPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class AriesPageSteps {
    private static final Logger logger = Logger.getLogger(AriesPageSteps.class);
    private AriesPage ariesPage;
    private WebDriver webDriver;
    private Screenshots screenshots;

    public AriesPageSteps()
    {
        logger.info("tests are starting.....");
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
        logger.info("page initialization finished");
    }

    @Given("^enter mail.ru$")
    public void enterSite() {
        webDriver.get("http://mail.ru");
        ariesPage = new AriesPage(webDriver);
    }

    @When("^click aries page$")
    public void clickAries (){
        logger.info("click aries page");
        ariesPage.clickAriesButton();
    }

    @And("^return home page$")
    public void clickHome (){
        logger.info("return home page");
        ariesPage.returnHomePage();
    }

    @Then("^Good, test positive!$")
    public void finishProgram (){
        screenshots = new Screenshots(webDriver);
        screenshots.screenSite("screen aries page");
        ariesPage.exitProgram();
    }
}
