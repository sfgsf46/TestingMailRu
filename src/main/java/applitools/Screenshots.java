package applitools;

import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import patterns.SingletonWebDriver;

public class Screenshots {
    WebDriver webDriver;
    private EyesRunner runner;
    private Eyes eyes;

    public Screenshots(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
        this.webDriver = webdriver;
    }

    public void screenSite(String nameScreen) {
//        webDriver = SingletonWebDriver.getInstance();
        runner = new ClassicRunner();
        eyes = new Eyes(runner);
        eyes.setApiKey("DvLPhXDA105X9FuHxOujKthOVZHE9CYMoLtXl4mXWwnNs110");
        eyes.open(webDriver, "Finish project", nameScreen);
        eyes.checkWindow("App Window");
        eyes.closeAsync();
        eyes.abortIfNotClosed();
    }
}
