package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.SearchImages;
import org.openqa.selenium.WebDriver;
import patterns.SingletonWebDriver;

public class SearchImagesSteps {
    private SearchImages searchImages;
    private WebDriver webDriver;

    public SearchImagesSteps() {
        SingletonWebDriver singletonWebDriver = new SingletonWebDriver(webDriver);
        webDriver = singletonWebDriver.getInstance();
        webDriver.manage().window().maximize();
    }

    @Given("^enter mail.ru -image$")
    public void enterSite() {
        webDriver.get("http://mail.ru");
        searchImages = new SearchImages(webDriver);
    }

    @When("^click image button$")
    public void clickWeatherForecat (){
        searchImages.clickSearchImage();
    }

    @And("^return home page -image$")
    public void clickHome (){
        searchImages.returnHomePage();
    }

    @Then("^Good, test positive! -image$")
    public void finishProgram (){
        searchImages.exitProgram();
    }
}
