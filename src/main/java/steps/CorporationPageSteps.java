package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.CorporationPage;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class CorporationPageSteps {
    private CorporationPage corporationPage;
    private WebDriver webDriver;

    public CorporationPageSteps() {
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
    }

    @Given("^enter mail.ru -corporation info$")
    public void enterSite() {
        webDriver.get("http://mail.ru");
        corporationPage = new CorporationPage(webDriver);
    }

    @When("^click corporation info button$")
    public void clickCorporation (){
        corporationPage.clickCorporationButton();
    }

    @Then("^Good, test positive! -corporation info$")
    public void finishProgram (){
        corporationPage.exitProgram();
    }
}
