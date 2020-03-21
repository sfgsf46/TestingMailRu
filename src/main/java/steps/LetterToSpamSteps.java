package steps;

import applitools.Screenshots;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.CheckFlag;
import methods.LetterToSpam;
import mySQL.MySQL;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class LetterToSpamSteps {
    private LetterToSpam letterToSpam;
    private WebDriver webDriver;
    private Screenshots screenshots;

    @Given("^enter mail.ru -check$")
    public void enterSite() {
        letterToSpam = new LetterToSpam(webDriver);
//        webDriver = SingletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
        webDriver.get("http://mail.ru");
        letterToSpam = new LetterToSpam(webDriver);
    }

    @When("^messages panel -check$")
    public void registrations() {
        letterToSpam.enterLogin(MySQL.getLoginAndPasswordOfMySQL(2));
        letterToSpam.enterPassword(MySQL.getLoginAndPasswordOfMySQL(3));
    }

    @And("^Moving of spam -check$")
    public void operations() {
        letterToSpam.markLetter();
        letterToSpam.clickSpam();
    }

    @Then("^Exit program -check$")
    public void exitDriver() {
//        screenshots = new Screenshots(webDriver);
//        screenshots.screenSite("screen spam page");
        letterToSpam.exitProgram();
    }
}
