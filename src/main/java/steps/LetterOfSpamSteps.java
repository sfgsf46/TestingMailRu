package steps;

import applitools.Screenshots;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.LetterOfSpam;
import mySQL.MySQL;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class LetterOfSpamSteps {
    private LetterOfSpam letterOfSpam;
    private WebDriver webDriver;
    private Screenshots screenshots;
    private static final Logger logger = Logger.getLogger(LetterOfSpamSteps.class);

    public LetterOfSpamSteps()
    {
        logger.info("tests are starting.....");
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
        logger.info("page initialization finished");
    }

    @Given("^enter mail.ru -checkOut$")
    public void enterSite() {
        webDriver.get("http://mail.ru");
        letterOfSpam = new LetterOfSpam(webDriver);
    }

    @When("^messages panel -checkOut$")
    public void messagesPanel() {
        letterOfSpam.enterLogin(MySQL.getLoginAndPasswordOfMySQL(2));
        letterOfSpam.enterPassword(MySQL.getLoginAndPasswordOfMySQL(3));
    }

    @And("^Moving of spam -checkOut$")
    public void operations() {
        letterOfSpam.goToSpam();
        letterOfSpam.markLetter();
        letterOfSpam.waitReturnOfSpam();
        logger.info("^Moving of spam");
    }

    @Then("^Exit program -checkOut$")
    public void exitDriver() {
        screenshots = new Screenshots(webDriver);
        screenshots.screenSite("screen return spam page");
        letterOfSpam.exitProgram();
    }
}
