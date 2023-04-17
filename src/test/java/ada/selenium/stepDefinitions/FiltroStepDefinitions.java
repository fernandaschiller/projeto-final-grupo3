package ada.selenium.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FiltroStepDefinitions {

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

    @Given("que usuario acessa pagina home")
    public void que_usuario_acessa_pagina_home() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("clicar em alguma categoria")
    public void clicar_em_alguma_categoria() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("deve redirecionar para a pagina de produtos da categoria selecionada")
    public void deve_redirecionar_para_a_pagina_de_produtos_da_categoria_selecionada() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("deve redirecionar para o resultado na mesma aba")
    public void deve_redirecionar_para_o_resultado_na_mesma_aba() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Given("um usuario acessa a pagina de resultados por categoria")
    public void um_usuario_acessa_a_pagina_de_resultados_por_categoria() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("selecionar algum criterio de ordenacao")
    public void selecionar_algum_criterio_de_ordenacao() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("deve ordenar resultados conforme criterio")
    public void deve_ordenar_resultados_conforme_criterio() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    
}
