package ada.selenium.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuscaStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    @Before()
    public void setup() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

    @Given("^que o usuário acesse a página home '(.+)'$")
    public void que_usuario_acessa_pagina_home(String url) {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class^=\"_lgpdy-banner _lgpdy-v-bottom\"] [class^=\"_lgpdy-cta-accept\"]"))).click();
        Assertions.assertTrue(driver.getTitle().contains("Saraiva"));
    }

    @Then("deve exibir caixa de pesquisa")
    public void deve_exibir_caixa_pesquisa() {
        Assertions.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class^=\"vtex-input-prefix__group\"]"))).isDisplayed());
    }

    @When("usuário clicar na caixa de pesquisa")
    public void usuario_clicar_caixa_de_pesquisa() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class^=vtex-input] input"))).click();
    }

    @And("^usuário digitar '(.+)' na caixa de pesquisa$")
    public void usuario_digitar_produto_caixa_pesquisa(String produto) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class^=vtex-input] input"))).sendKeys(produto + Keys.ENTER);
    }

    @Then("deve exibir uma tela com os resultados relevantes da busca realizada na mesma guia")
    public void deve_exibir_tela_com_resultados() {
        Assertions.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gallery-layout-container"))).isDisplayed());
    }

    @Then("deve exibir sugestão dos termos mais buscados")
    public void deve_exibir_sugestao_dos_termos_mais_buscados() {
        Assertions.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class^=\"vtex-search-2-x-biggy-autocomplete\"]"))).isDisplayed());
    }

    @Then("deve exibir uma mensagem de erro informando que nenhum resultado foi encontrado")
    public void deve_exibir_mensagem_de_erro_informando_que_nenhum_resultado_foi_encontrado() {
        Assertions.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class^=\"vtex-search-result-3-x-searchNotFoundOops\"]"))).isDisplayed());
    }

    @And("deve ser possível verificar a quantidade de produtos retornados, no canto superior direito da tela")
    public void deve_ser_possivel_verificar_quantidade_produtos_retornados() {
        Assertions.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class^=\"vtex-search-result-3-x-totalProductsMessage\"]"))).isDisplayed());
    }

    @And("a opção de filtro deve estar disponível")
    public void opcao_de_filtro_deve_estar_disponivel() {
        Assertions.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class^=\"vtex-search-result-3-x-filterMessage\"]"))).isDisplayed());
    }

    @And("^usuário digitar '(.+)' na caixa de pesquisa mas não apertar enter$")
    public void usuario_digitar_produto_caixa_pesquisa_sem_enter(String produto) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class^=vtex-input] input"))).sendKeys(produto);
    }

    @Then("deve aparecer a mensagem 'SEM SUGESTÕES'")
    public void deve_aparecer_sem_sugestoes() {
        Assertions.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class^=\"vtex-search-2-x-itemListTitle\"]"))).isDisplayed());
    }

    @And("deve ser possível clicar em um item sugerido nos termos mais buscados")
    public void deve_ser_possível_clicar_no_item_sugerido() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ol li:nth-child(1)"))).click();
    }
}