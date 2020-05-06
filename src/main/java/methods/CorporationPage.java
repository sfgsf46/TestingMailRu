package methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CorporationPage {
    private static final int TIMEOUT = 15;
    private WebDriver webDriver;

    @FindBy(xpath = "(//a[@class=\"footer__item i-color-warm-grey svelte-lh29he\"])[1]")
    private WebElement corporationButton;

    public CorporationPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCorporationButton() {
        (new WebDriverWait(webDriver, TIMEOUT))
                .until(ExpectedConditions.visibilityOf(corporationButton)).click();
    }

    public void exitProgram() {
        webDriver.quit();
    }
}
