package steps;

import applitools.Screenshots;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.MyCloud;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class MyCloudSteps {
    private MyCloud myCloud;
    private WebDriver webDriver;
    private Screenshots screenshots;
    private static final Logger logger = Logger.getLogger(MyCloudSteps.class);

    public MyCloudSteps()
    {
        logger.info("tests are starting.....");
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
        logger.info("page initialization finished");
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
        logger.info("return home page");
    }

    @Then("^Good, test positive! -cloud$")
    public void finishProgram (){
        screenshots = new Screenshots(webDriver);
        screenshots.screenSite("screen myCloud page");
        myCloud.exitProgram();
    }
}
