package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendMessage {
    private static final int TIMEOUT = 15;
    private WebDriver webDriver;

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement buttonEnter;

    @FindBy(xpath = "//*[@id='PH_logoutLink']")
    private WebElement logoutLink;

    @FindBy(xpath = "//*[@id='mailbox:error']")
    public WebElement logoutLinkError;

    @FindBy(xpath = "//span[@class=\"compose-button__txt\"]")
    private WebElement writeLetter;

    @FindBy(xpath = "(//input[@class=\"container--H9L5q size_s--3_M-_\"])[1]")
    private WebElement toLetter;

    @FindBy(xpath = "(//input[@class=\"container--H9L5q size_s--3_M-_\"])[2]")
    private WebElement topicLetter;

    @FindBy(xpath = "//div[@role=\"textbox\"]")
    private WebElement containLetter;

    public SendMessage(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
        this.webDriver = webdriver;
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

    public void clickWriteLetter() {
        (new WebDriverWait(webDriver, TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(writeLetter)).click();
    }

    public void writeTo(String address) {
        (new WebDriverWait(webDriver, TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(toLetter)).sendKeys(address);
    }

    public void writeTopic(String topic) {
        (new WebDriverWait(webDriver, TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(topicLetter)).sendKeys(topic);
    }

    public void writeText(String text) {
        (new WebDriverWait(webDriver, TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(containLetter)).sendKeys(text);
    }

    public void sendMessage() {
        webDriver.findElement(By.xpath("//span[@title=\"Отправить\"]")).click();
    }

    public void exitProgram() {
        webDriver.quit();
    }
}
