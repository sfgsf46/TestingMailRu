package apiTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private static final int TIMEOUT = 30;

    private WebDriver driver;
    private LoginPage loginPage;

    @FindBy(id = "index_email")
    private WebElement loginField;

    @FindBy(id = "index_pass")
    private WebElement passwordField;

    @FindBy(id = "index_login_button")
    private WebElement buttonEnter;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterLogin(String login) {
        (new WebDriverWait(driver, TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(loginField)).sendKeys(login);
    }

    public void enterPassword(String password) {
        (new WebDriverWait(driver, TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
        buttonEnter.click();
    }
}
