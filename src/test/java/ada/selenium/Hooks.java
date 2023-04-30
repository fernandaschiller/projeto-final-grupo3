package ada.selenium;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    private static WebDriver driverChrome;

//    @Before
//    public void setup(){
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driverChrome = new ChromeDriver(options);
//    }
//
//    @After
//    public void tearDown(){
//        driverChrome.quit();
//    }

    public static WebDriver getDriver(){
        return driverChrome;
    }
}