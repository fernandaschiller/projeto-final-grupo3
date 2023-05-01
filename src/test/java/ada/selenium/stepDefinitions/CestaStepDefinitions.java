package ada.selenium.stepDefinitions;

import ada.selenium.MeuDriver;
import ada.selenium.pageobjects.CestaPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CestaStepDefinitions {

    private WebDriver meuDriver;
    String termoDeBusca = "celular";
    int cont = 0;


    @Before()
    public void setup() throws InterruptedException {
        MeuDriver wdriver = new MeuDriver();
        meuDriver = wdriver.WebDriver();
        Thread.sleep(3000);
    }

    @After()
    public void closeBrowser() {
        meuDriver.quit();
        meuDriver.close();
    }

    @Given("fez a busca de um produto")
    public void busca() {
        CestaPage cestaPage = new CestaPage(meuDriver);
        cestaPage.fazerPesquisa(meuDriver, termoDeBusca);
    }

    @When("ao comprar dois produtos")
    public void comprar() throws InterruptedException {
        CestaPage cestaPage = new CestaPage(meuDriver);
        String numeroDeProdutos = cestaPage.colocaProdutosNaCesta(termoDeBusca);
        System.out.println(numeroDeProdutos);

    }
    @Then("ficar na mesma pagina")
    public void manter() throws InterruptedException {
        assertTrue(meuDriver.getTitle().contains(termoDeBusca));
    }

    @Then("a cesta exibe informa��es")
    public void infos() throws InterruptedException {
        CestaPage cestaPage = new CestaPage(meuDriver);
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

    @Then("� poss�vel deletar um produto")
    public void deletar() throws InterruptedException {
        CestaPage cestaPage = new CestaPage(meuDriver);
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