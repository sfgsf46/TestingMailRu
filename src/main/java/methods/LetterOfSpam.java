package methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LetterOfSpam {
    private static final int TIMEOUT = 15;
    private WebDriver webDriver;

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement buttonEnter;

    @FindBy(xpath = "/html/body/div[5]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div" +
            "/div/div/a[1]/div[3]/button/div")
    private WebElement markLetter;

    @FindBy(xpath = "(//div[@class=\"nav__folder-name\"])[7]")
    private WebElement enterSpam;

    @FindBy(xpath = "/html/body/div[5]/div/div[1]/div[1]/div/div[1]/div[2]/div[2]/table/tbody/tr/td/span[2]/div[3]")
    private WebElement returnOfSpam;

    public LetterOfSpam(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
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

    public void markLetter() {
        (new WebDriverWait(webDriver, TIMEOUT))
                .until(ExpectedConditions.visibilityOf(markLetter)).click();
    }

    public void goToSpam() {
        (new WebDriverWait(webDriver, TIMEOUT))
                .until(ExpectedConditions.visibilityOf(enterSpam)).click();
    }

    public void waitReturnOfSpam() {
        (new WebDriverWait(webDriver, TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(returnOfSpam)).click();
    }

    public void exitProgram() {
        webDriver.quit();
    }
}
