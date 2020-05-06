package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.SendMessage;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class SendMessageSteps {
    private SendMessage sendMessage;
    private WebDriver webDriver;

    public SendMessageSteps() {
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
    }

    @Given("^enter site -sendMessage$")
    public void enterSite() {
        webDriver.get("http://mail.ru");
        sendMessage = new SendMessage(webDriver);
    }

    @When("^messages panel -sendMessage$")
    public void messagesPanel() {
        sendMessage.enterLogin("sfgsf464646");
        sendMessage.enterPassword("464646vk");
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
