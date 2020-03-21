package patterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonWebDriver {
    private static WebDriver webDriver;

    public SingletonWebDriver(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public WebDriver getInstance (){
        System.setProperty("webdriver.chrome.driver",
                "D:\\Java\\Automation course\\driver\\chromedriver.exe");
        if(webDriver == null) {
            webDriver = new ChromeDriver();
        }
        return webDriver;
    
    }
}
