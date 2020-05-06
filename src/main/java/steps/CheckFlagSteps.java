package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.CheckFlag;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class CheckFlagSteps {
    private CheckFlag checkFlag;
    private WebDriver webDriver;

    public CheckFlagSteps() {
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
    }

    @Given("^enter site -checkFlag$")
    public void enterSite() {
        webDriver.get("http://mail.ru");
        checkFlag = new CheckFlag(webDriver);
        checkFlag.enterLogin("sfgsf464646");
        checkFlag.enterPassword("464646vk");
    }

    @When("^messages panel -checkFlag$")
    public void registration() {
    }

    @And("^check flag$")
    public void operationsClickFlag() {
        checkFlag.clickFlag();
    }

    @Then("^exit program -checkFlag$")
    public void exitProgram() {
        checkFlag.exitProgram();
    }
}
