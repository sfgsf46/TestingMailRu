package methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WeatherForecastPage {
    private static final int TIMEOUT = 15;
    private WebDriver webDriver;

    @FindBy(xpath = "//p[@class=\"weather__desc i-font-md i-link-deco svelte-15u5l1c\"]")
    private WebElement forecastButton;

    @FindBy(xpath = "//a[@class=\"x-ph__link x-ph__link_first\"]")
    private WebElement buttonReturn;

    public WeatherForecastPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickForecastButton() {
        (new WebDriverWait(webDriver, TIMEOUT))
                .until(ExpectedConditions.visibilityOf(forecastButton)).click();
    }

    public void returnHomePage() {
        (new WebDriverWait(webDriver, TIMEOUT))
                .until(ExpectedConditions.visibilityOf(buttonReturn)).click();
    }

    public void exitProgram() {
        webDriver.quit();
    }
}
