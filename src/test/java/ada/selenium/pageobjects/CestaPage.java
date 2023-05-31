package ada.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;
import java.util.NoSuchElementException;

public class CestaPage {
    WebDriver driver;
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



    public CestaPage(WebDriver driver)  {
        this.driver = driver;
    }

    public void fazerPesquisa (String termoBusca) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        caixaDePesquisa =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".vtex-styleguide-9-x-input")));
        caixaDePesquisa.sendKeys(termoBusca.toLowerCase(Locale.ROOT));
        caixaDePesquisa.sendKeys(Keys.RETURN);
    }

    public String colocaProdutosNaCesta() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
        botoesDeComprar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((botaoComprar1))));
//        botoesDeComprar = driver.findElement(By.xpath(botaoComprar1));
        botoesDeComprar.click();
        botoesDeComprar = driver.findElement(By.xpath(botaoComprar2));
        botoesDeComprar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        numeroDeProdutosNaCesta = driver.findElement(By.cssSelector(quantidadeDeProdutos));

        return numeroDeProdutosNaCesta.getText();
    }

    public WebElement retornaInfoProdutos() {
        produtosNaCesta = driver.findElement(By.cssSelector(produtos));
        return produtosNaCesta;
    }

    public void deletaProdutosNaCesta() {
        deletarNoCarrinho = driver.findElement(By.cssSelector(botaoDeletar));
        deletarNoCarrinho.click();
    }
}