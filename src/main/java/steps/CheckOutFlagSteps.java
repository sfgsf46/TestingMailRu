package steps;

import applitools.Screenshots;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.CheckOutFlag;
import mySQL.MySQL;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class CheckOutFlagSteps {
    private CheckOutFlag checkOutFlag;
    private WebDriver webDriver;
    private Screenshots screenshots;
    private static final Logger logger = Logger.getLogger(CheckOutFlagSteps.class);

    public CheckOutFlagSteps()
    {
        logger.info("tests are starting.....");
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
        logger.info("page initialization finished");
    }

    @Given("^enter site -checkOutFlag$")
    public void enterSite() {
        checkOutFlag = new CheckOutFlag(webDriver);
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
        webDriver.get("http://mail.ru");
        checkOutFlag = new CheckOutFlag(webDriver);
    }

    @When("^messages panel -checkOutFlag$")
    public void registration() {
        checkOutFlag.enterLogin(MySQL.getLoginAndPasswordOfMySQL(2));
        checkOutFlag.enterPassword(MySQL.getLoginAndPasswordOfMySQL(3));
    }

    @And("^check out flag$")
    public void operationsClickFlag() {
        checkOutFlag.clickOutFlag();
        logger.info("check out flag");
    }

    @Then("^exit program -checkOutFlag$")
    public void exitDriver() {
        screenshots = new Screenshots(webDriver);
        screenshots.screenSite("screen out flag page");
        checkOutFlag.exitProgram();
    }
}
