package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.MyCloud;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class MyCloudSteps {
    private MyCloud myCloud;
    private WebDriver webDriver;

    public MyCloudSteps() {
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
    }

    @Given("^enter mail.ru -cloud$")
    public void enterSite() {
        webDriver.get("http://mail.ru");
        myCloud = new MyCloud(webDriver);
    }

    @When("^click cloud button$")
    public void clickAries (){
        myCloud.clickAriesButton();
    }

    @And("^return home page -cloud$")
    public void clickHome (){
        myCloud.returnHomePage();
    }

    @Then("^Good, test positive! -cloud$")
    public void finishProgram (){
        myCloud.exitProgram();
    }
}
