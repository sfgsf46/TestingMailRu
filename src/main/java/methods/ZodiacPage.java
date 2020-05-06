package methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZodiacPage {
    private static final int TIMEOUT = 15;
    private WebDriver webDriver;

    @FindBy(xpath = "//div[@class=\"informers__item svelte-1dye7ra\"]")
    private WebElement ariesButton;

    @FindBy(xpath = "//a[@class=\"x-ph__link x-ph__link_first\"]")
    private WebElement buttonReturn;

    public ZodiacPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAriesButton() {
        (new WebDriverWait(webDriver, TIMEOUT))
                .until(ExpectedConditions.visibilityOf(ariesButton)).click();
    }

    public void returnHomePage() {
        (new WebDriverWait(webDriver, TIMEOUT))
                .until(ExpectedConditions.visibilityOf(buttonReturn)).click();
    }

    public void exitProgram() {
        webDriver.quit();
    }
}
