package ada.selenium.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.CestaPage;
import pageobjects.HomePage;
import setup.Driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CestaStepDefinitions {
    WebDriver driver;
    String termoDeBusca = "celular";
    int cont = 0;


    @Before()
    public void setup() throws InterruptedException {
        Driver wdriver = new Driver();
        driver = wdriver.WebDriver();
        Thread.sleep(3000);
    }

    @After()
    public void closeBrowser() {
        driver.quit();
        driver.close();
    }

    @Given("fez a busca de um produto")
    public void busca() {
        HomePage homePage = new HomePage(driver);
        homePage.fazerPesquisa(termoDeBusca);
    }

    @When("ao comprar dois produtos")
    public void comprar() throws InterruptedException {
        CestaPage cestaPage = new CestaPage(driver);
        String numeroDeProdutos = cestaPage.colocaProdutosNaCesta(termoDeBusca);
        System.out.println(numeroDeProdutos);

    }
    @Then("ele se manterá na mesma página")
    public void manter() {
        CestaPage cestaPage = new CestaPage(driver);
        assertTrue(cestaPage.mesmaPagina());
    }

    @Then("a cesta exibe informações")
    public void infos() throws InterruptedException {
        CestaPage cestaPage = new CestaPage(driver);
        Thread.sleep(5000);
        WebElement produtosNaCesta = cestaPage.retornaInfoProdutos();
        String produtosNaCestaString;
        produtosNaCestaString = produtosNaCesta.getText().toLowerCase();

        String[] lines = produtosNaCestaString.split("\\r?\\n");
        for (String item : lines) {
            if (item.contains("celular")){
                System.out.println("Item na lista: " + item);
                cont++;
            }
        }
        Thread.sleep(3000);
        assertEquals(2, cont);
    }

    @Then("é possível deletar um produto")
    public void deletar() throws InterruptedException {
        CestaPage cestaPage = new CestaPage(driver);
        String numeroDeProdutos = cestaPage.colocaProdutosNaCesta(termoDeBusca);
        Thread.sleep(2000);
        cestaPage.deletaProdutosNaCesta();

        Thread.sleep(2000);
        WebElement produtosNaCesta = cestaPage.retornaInfoProdutos();
        String produtosNaCestaString;
        produtosNaCestaString = produtosNaCesta.getText().toLowerCase();

        String[] lines = produtosNaCestaString.split("\\r?\\n");
        for (String item : lines) {
            if (item.contains("celular")){
                System.out.println("Item na lista: " + item);
                cont++;
            }
        }
        Thread.sleep(2000);
        assertEquals(1, cont);
    }

}


