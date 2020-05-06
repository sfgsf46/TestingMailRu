package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.LetterOfSpam;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class LetterOfSpamSteps {
    private LetterOfSpam letterOfSpam;
    private WebDriver webDriver;

    public LetterOfSpamSteps() {
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
    }

    @Given("^enter mail.ru -checkOut$")
    public void enterSite() {
        webDriver.get("http://mail.ru");
        letterOfSpam = new LetterOfSpam(webDriver);
    }

    @When("^messages panel -checkOut$")
    public void messagesPanel() {
        letterOfSpam.enterLogin("sfgsf464646");
        letterOfSpam.enterPassword("464646vk");
    }

    @And("^Moving of spam -checkOut$")
    public void operations() {
        letterOfSpam.goToSpam();
        letterOfSpam.markLetter();
        letterOfSpam.waitReturnOfSpam();
    }

    @Then("^Exit program -checkOut$")
    public void exitDriver() {
        letterOfSpam.exitProgram();
    }
}
