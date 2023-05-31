package ada.selenium;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Collections;

public class Hooks {
    private static WebDriver driver;
    private ChromeOptions options;

    @Before
    public void setup() throws InterruptedException {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//        options.addArguments("--window-size=1024,768");
        driver = WebDriverManager.chromedriver().capabilities(options).create();
        driver.manage().window().maximize();
        driver.get("https://www.saraiva.com.br/");
        Thread.sleep(3000);
    }

//    @After
//    public void tearDown(){
//        driver.close();
//        driver.quit();
//    }

    public static WebDriver getDriver()  {
        return driver;
    }
}