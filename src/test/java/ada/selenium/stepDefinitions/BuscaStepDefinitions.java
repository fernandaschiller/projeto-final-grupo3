package ada.selenium.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

//    @After()
//    public void closeBrowser() {
//        driver.quit();
//    }

    @Given("que o usuario acesse a pagina")
    public void que_usuario_acessa_pagina_home() {
        driver.get("https://www.saraiva.com.br/");
    }

    @When("ao efetuar busca de produto")
    public void efetuar_busca_de_produto() throws InterruptedException {
        Thread.sleep(3000);
        String busca = "vtex-styleguide-9-x-input";
        driver.findElement(By.className(busca)).sendKeys("celular");
        driver.findElement(By.className(busca)).sendKeys(Keys.RETURN);

    }

    @Then("levar a tela de resultados")
    public void tela_de_resultados() throws InterruptedException {
        Thread.sleep(3000);
        Assertions.assertTrue(driver.getTitle().contains("celular"));
        System.out.println("-----------------");
        System.out.println(driver.getTitle());
        System.out.println("-----------------");
    }

}


