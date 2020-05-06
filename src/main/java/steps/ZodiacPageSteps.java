package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.ZodiacPage;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class ZodiacPageSteps {
    private ZodiacPage ariesPage;
    private WebDriver webDriver;

    public ZodiacPageSteps() {
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
    }

    @Given("^enter mail.ru$")
    public void enterSite() {
        webDriver.get("http://mail.ru");
        ariesPage = new ZodiacPage(webDriver);
    }

    @When("^click aries page$")
    public void clickAries (){
        ariesPage.clickAriesButton();
    }

    @And("^return home page$")
    public void clickHome (){
        ariesPage.returnHomePage();
    }

    @Then("^Good, test positive!$")
    public void finishProgram (){
        ariesPage.exitProgram();
    }
}
