package ada.selenium.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuscaStepDefinitions {
    WebDriver driver;
    @Before()
    public void setup() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

    @Given("^que o usuário acesse a página '(.+)'$")
    public void que_usuario_acessa_pagina_home(String url){
        driver.get(url);
        Assertions.assertTrue(driver.getTitle().contains("Saraiva"));
    }
}
