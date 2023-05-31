package ada.selenium.stepDefinitions;

import ada.selenium.Hooks;
import ada.selenium.pageobjects.CestaPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CestaStepDefinitions {

    WebDriver driver = Hooks.getDriver();
    CestaPage cestaPage = new CestaPage(driver);
    String termoDeBusca = "celular";
    int cont = 0;

    public CestaStepDefinitions() {
    }

    @Given("fez a busca de um produto")
    public void busca() {
        cestaPage.fazerPesquisa(termoDeBusca);
    }

    @When("ao comprar dois produtos")
    public void comprar() {
        String numeroDeProdutos = cestaPage.colocaProdutosNaCesta();
        System.out.println(numeroDeProdutos);

    }
    @Then("ficar na mesma pagina")
    public void manter()  {
        assertTrue(driver.getTitle().contains(termoDeBusca));
    }

    @Then("a cesta exibe informações")
    public void infos()  {
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
        assertEquals(2, cont);
    }

    @Then("é possível deletar um produto")
    public void deletar() {
        String numeroDeProdutos = cestaPage.colocaProdutosNaCesta();
        cestaPage.deletaProdutosNaCesta();

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
        assertEquals(1, cont);
    }


}