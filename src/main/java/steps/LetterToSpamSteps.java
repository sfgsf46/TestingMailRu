package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.LetterToSpam;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class LetterToSpamSteps {
    private LetterToSpam letterToSpam;
    private WebDriver webDriver;

    public LetterToSpamSteps() {
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
    }

    @Given("^enter mail.ru -check$")
    public void enterSite() {
        letterToSpam = new LetterToSpam(webDriver);
        webDriver.get("http://mail.ru");
    }

    @When("^messages panel -check$")
    public void registrations() {
        letterToSpam.enterLogin("sfgsf464646");
        letterToSpam.enterPassword("464646vk");
    }

    @And("^Moving of spam -check$")
    public void operations() {
        letterToSpam.markLetter();
        letterToSpam.clickSpam();
    }

    @Then("^Exit program -check$")
    public void exitDriver() {
        letterToSpam.exitProgram();
    }
}
