package steps;

import applitools.Screenshots;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.SendMessage;
import mySQL.MySQL;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class SendMessageSteps {
    private SendMessage sendMessage;
    private WebDriver webDriver;
    private Screenshots screenshots;
    private static final Logger logger = Logger.getLogger(SendMessageSteps.class);

    public SendMessageSteps()
    {
        logger.info("tests are starting.....");
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
        logger.info("page initialization finished");
    }

    @Given("^enter site -sendMessage$")
    public void enterSite() {
        webDriver.get("http://mail.ru");
        sendMessage = new SendMessage(webDriver);
    }

    @When("^messages panel -sendMessage$")
    public void messagesPanel() {
        sendMessage.enterLogin(MySQL.getLoginAndPasswordOfMySQL(2));
        sendMessage.enterPassword(MySQL.getLoginAndPasswordOfMySQL(3));
    }

    @And("^write panel$")
    public void writePanel() {
        sendMessage.clickWriteLetter();
    }

    @And("^done write$")
    public void doneWrite() {
        sendMessage.writeTo("sfgsf@tut.by");
        sendMessage.writeTopic("Александр Григорьевич Лукашенко");
        sendMessage.writeText("Какое-то послание от президента Республики Беларусь");
        screenshots = new Screenshots(webDriver);
        screenshots.screenSite("screen send message");
    }

    @And("^send message$")
    public void sendMessage() {
        sendMessage.sendMessage();
    }

    @Then("^ok! no error, exit from the program -sendMessage$")
    public void exitDriver() {
        sendMessage.exitProgram();
    }
}
