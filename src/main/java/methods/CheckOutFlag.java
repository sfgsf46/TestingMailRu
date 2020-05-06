package methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutFlag {
    private static final int TIMEOUT = 15;
    private WebDriver webDriver;

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement buttonEnter;

    @FindBy(xpath = "//button[@title=\"Снять флажок\"]")
    private WebElement checkOutFlagOne;

    public CheckOutFlag(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterLogin(String login) {
        (new WebDriverWait(webDriver, TIMEOUT))
                .until(ExpectedConditions.visibilityOf(loginField)).sendKeys(login);
        buttonEnter.click();
    }

    public void enterPassword(String password) {
        (new WebDriverWait(webDriver, TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
        buttonEnter.click();
    }

    public void clickOutFlag() {
        for (int i = 0; i <= 2; i=i+1){
            (new WebDriverWait(webDriver, TIMEOUT))
                    .until(ExpectedConditions.visibilityOf(checkOutFlagOne)).click();
        }
    }

    public void exitProgram() {
        webDriver.quit();
    }
}

