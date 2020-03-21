package steps;

import applitools.Screenshots;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.CheckFlag;
import mySQL.MySQL;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class CheckFlagSteps {
    private CheckFlag checkFlag;
    private WebDriver webDriver;
    private Screenshots screenshots;
    private static final Logger logger = Logger.getLogger(CheckFlagSteps.class);

    public CheckFlagSteps()
    {
        logger.info("tests are starting.....");
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
        logger.info("page initialization finished");
    }

    @Given("^enter site -checkFlag$")
    public void enterSite() {
        webDriver.get("http://mail.ru");
        checkFlag = new CheckFlag(webDriver);
    }

    @When("^messages panel -checkFlag$")
    public void registration() {
        checkFlag.enterLogin(MySQL.getLoginAndPasswordOfMySQL(2));
        checkFlag.enterPassword(MySQL.getLoginAndPasswordOfMySQL(3));
    }

    @And("^check flag$")
    public void operationsClickFlag() {
        checkFlag.clickFlag();
        logger.info("check flag");
    }

    @Then("^exit program -checkFlag$")
    public void exitProgram() {
        screenshots = new Screenshots(webDriver);
        screenshots.screenSite("screen flag page");
        checkFlag.exitProgram();
    }
}
