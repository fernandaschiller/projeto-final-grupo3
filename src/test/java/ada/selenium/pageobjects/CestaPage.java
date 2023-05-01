package ada.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class CestaPage {

    private final WebDriver driver;
    WebDriverWait wait;

    String botaoComprar1 = "//*[@id=\"gallery-layout-container\"]/div[1]/section/a/article/div[4]/button";
    String botaoComprar2 ="//*[@id=\"gallery-layout-container\"]/div[2]/section/a/article/div[4]/button";
    String produtos = ".vtex-minicart-2-x-minicartProductListContainer";
    String quantidadeDeProdutos = ".vtex-minicart-2-x-minicartQuantityBadge";
    String botaoDeletar = ".vtex-product-list-0-x-deleteIcon";

    WebElement numeroDeProdutosNaCesta;
    WebElement deletarNoCarrinho;
    WebElement produtosNaCesta;
    WebElement botoesDeComprar;
    WebElement caixaDePesquisa ;


    public CestaPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver = driver;
    }

    public void fazerPesquisa (WebDriver driver, String termoBusca) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        caixaDePesquisa = driver.findElement(By.cssSelector(".vtex-styleguide-9-x-input"));
        wait.until(ExpectedConditions.elementToBeClickable(caixaDePesquisa));
        caixaDePesquisa.sendKeys(termoBusca.toLowerCase(Locale.ROOT));
        caixaDePesquisa.sendKeys(Keys.RETURN);
    }

    public String colocaProdutosNaCesta(String termoDeBusca) throws InterruptedException {
        Thread.sleep(4000);
        botoesDeComprar = driver.findElement(By.xpath(botaoComprar1));
        botoesDeComprar.click();
        botoesDeComprar = driver.findElement(By.xpath(botaoComprar2));
        botoesDeComprar.click();
        Thread.sleep(2000);
        numeroDeProdutosNaCesta = driver.findElement(By.cssSelector(quantidadeDeProdutos));

        return numeroDeProdutosNaCesta.getText();
    }

    public WebElement retornaInfoProdutos() throws InterruptedException {
        Thread.sleep(3000);
        produtosNaCesta = driver.findElement(By.cssSelector(produtos));
        Thread.sleep(3000);

        return produtosNaCesta;
    }

    public void deletaProdutosNaCesta() throws InterruptedException {
        Thread.sleep(5000);
        deletarNoCarrinho = driver.findElement(By.cssSelector(botaoDeletar));
        deletarNoCarrinho.click();
    }
}