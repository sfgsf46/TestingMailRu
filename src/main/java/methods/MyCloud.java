package methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyCloud {
    private static final int TIMEOUT = 15;
    private WebDriver webDriver;

    @FindBy(xpath = "(//div[@class=\"projects-item__body svelte-qyhth7\"])[1]")
    private WebElement cloudButton;

    @FindBy(xpath = "(//a[@class=\"footer__links-item\"])[3]")
    private WebElement buttonReturn;

    public MyCloud(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAriesButton() {
        (new WebDriverWait(webDriver, TIMEOUT))
                .until(ExpectedConditions.visibilityOf(cloudButton)).click();
    }

    public void returnHomePage() {
        (new WebDriverWait(webDriver, TIMEOUT))
                .until(ExpectedConditions.visibilityOf(buttonReturn)).click();
    }

    public void exitProgram() {
        webDriver.quit();
    }
}
