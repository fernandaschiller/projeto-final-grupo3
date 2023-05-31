package ada.selenium.stepDefinitions;

import ada.selenium.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DetalhesStepDefinitions {
    WebDriver driver = Hooks.getDriver();

    public DetalhesStepDefinitions() throws InterruptedException {
    }

    @Given("Que estou na página de um produto escolhido")
    public void que_usuario_acessa_pagina_produto() {
        driver.get("https://www.saraiva.com.br/seja-foda-/p");
    }

    @Then("a imagem do produto deve ser mostrada")
    public void deve_mostrar_a_imagem_do_produto_corretamente() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement imagemProduto = driver.findElement(By.cssSelector(".vtex-store-components-3-x-productImageTag.vtex-store-components-3-x-productImageTag--product-images.vtex-store-components-3-x-productImageTag--main.vtex-store-components-3-x-productImageTag--product-images--main"));
        Assertions.assertTrue(imagemProduto.isDisplayed(), "A imagem do produto não está sendo exibida corretamente.");
    }

    @When("Estiver no fim da página")
    public void que_o_usuario_rola_ate_o_fim_da_pagina() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    @Then("devem ser apresentados produtos relacionados")
    public void deve_mostrar_os_produtos_relacionados_com_o_produto_escolhido() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement produtosRelacionados = driver.findElement(By.cssSelector(".vtex-shelf-1-x-shelfContentContainer"));
        Assertions.assertTrue(produtosRelacionados.isDisplayed(), "Os produtos relacionados não estão sendo exibidos corretamente.");
    }

    @Then("deve ser apresentada uma descrição sobre o produto")
    public void deve_mostrar_a_descricao_do_produto_escolhido() {
        WebElement descricaoProduto = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".vtex-store-components-3-x-productDescriptionContainer")));
        Assertions.assertTrue(descricaoProduto.isDisplayed(), "A descrição do produto não está sendo exibida corretamente");
    }

    @Then("devem ser apresentadas as especificações do produto")
    public void deve_mostrar_as_especificacoes_do_produto_escolhido() {
        WebElement especificacaoProduto = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".vtex-flex-layout-0-x-flexColChild.pb0:nth-child(2)")));
        Assertions.assertTrue(especificacaoProduto.isDisplayed(), "As especificações do produto não está sendo exibidas corretamente");
    }

}
