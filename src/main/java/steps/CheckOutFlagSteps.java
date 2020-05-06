package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.CheckOutFlag;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class CheckOutFlagSteps {
    private CheckOutFlag checkOutFlag;
    private WebDriver webDriver;

    public CheckOutFlagSteps() {
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
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
        checkOutFlag.enterLogin("sfgsf464646");
        checkOutFlag.enterPassword("464646vk");
    }

    @And("^check out flag$")
    public void operationsClickFlag() {
        checkOutFlag.clickOutFlag();
    }

    @Then("^exit program -checkOutFlag$")
    public void exitDriver() {
        checkOutFlag.exitProgram();
    }
}
