package ada.selenium.stepDefinitions;

import ada.selenium.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FiltroStepDefinitions {

    WebDriver driver = Hooks.getDriver();

    @Given("que o usuario acesse a pagina home {string}")
    public void queOUsuarioAcesseAPaginaHome(String url) throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(3000);
        Assertions.assertTrue(driver.getTitle().contains("Saraiva"));
    }


    @When("passar o mouse na opcao Categorias")
    public void passarOMouseNaOpcaoCategorias() {
        WebElement menuCategoria = driver.findElement(By.cssSelector("[class^=\"lojasaraivanew-mega-menu-2-x-triggerContainer pointer\"]"));
        Actions acao = new Actions(driver);
        acao.moveToElement(menuCategoria).perform();
    }

    @Then("deve exibir menu de categorias")
    public void deveExibirMenuDeCategorias() {
        Assertions.assertTrue(driver.findElement(By.cssSelector("[class^=\"slick-track\"]")).isDisplayed());
    }

    @When("clicar na categoria em alguma categoria")
    public void clicarNaCategoriaEmAlgumaCategoria(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class^=\"lojasaraivanew-mega-menu-2-x-triggerContainer pointer\"]"))).click();
    }


    @Then("deve redirecionar para o resultado na mesma aba")
    public void deveRedirecionarParaOResultadoNaMesmaAba(){
        String abaAntesDeClicar = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/div/div[2]/section/div/div/nav/ul/div/div/div/div[1]/div/li/div"))).click();

        String abaDepoisDeClicar = driver.getWindowHandle();

        Assertions.assertEquals(abaDepoisDeClicar, abaAntesDeClicar);

    }

    @When("clicar na categoria Livros")
    public void clicarNaCategoriaLivros() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class^=\"lojasaraivanew-mega-menu-2-x-triggerContainer pointer\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/div/div[2]/section/div/div/nav/ul/div/div/div/div[1]/div/li/div"))).click();
    }

    @When("clicar na categoria Papelaria")
    public void clicarNaCategoriaPapelaria() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class^=\"lojasaraivanew-mega-menu-2-x-triggerContainer pointer\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/div/div[2]/section/div/div/nav/ul/div/div/div/div[2]/div/li/div"))).click();
    }

    @When("clicar na categoria Presentes")
    public void clicarNaCategoriaPresentes() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class^=\"lojasaraivanew-mega-menu-2-x-triggerContainer pointer\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/div/div[2]/section/div/div/nav/ul/div/div/div/div[3]/div/li/div"))).click();
    }

    @When("clicar na categoria Brinquedos")
    public void clicarNaCategoriaBrinquedos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class^=\"lojasaraivanew-mega-menu-2-x-triggerContainer pointer\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/div/div[2]/section/div/div/nav/ul/div/div/div/div[4]/div/li/div"))).click();
    }

    @When("clicar na categoria Bebê")
    public void clicarNaCategoriaBebe() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class^=\"lojasaraivanew-mega-menu-2-x-triggerContainer pointer\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/div/div[2]/section/div/div/nav/ul/div/div/div/div[5]/div/li/div"))).click();
    }

    @Then("deve redirecionar para a pagina de produtos da categoria '(.+)'$")
    public void deveRedirecionarParaAPaginaDeProdutosDaCategoriaLivros(String categoria) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement categoriaExibida = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/div[4]/div/div/section/div[2]/div/div[1]/section/div/div[1]/div/div/div[1]/h1")));
        String nomeDaCategoria = categoriaExibida.getAttribute("textContent");
        Assertions.assertEquals(categoria, nomeDaCategoria);
    }

    @When("passar o mouse sobre a categoria Livros")
    public void passarOMouseSobreACategoriaLivros() throws InterruptedException {
        Actions acao = new Actions(driver);
        WebElement menuCategoria = driver.findElement(By.cssSelector("[class^=\"lojasaraivanew-mega-menu-2-x-triggerContainer pointer\"]"));
        acao.moveToElement(menuCategoria).perform();
        Thread.sleep(3000);
        WebElement categoriaLivros = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/div/div[2]/section/div/div/nav/ul/div/div/div/div[1]/div/li/div"));
        acao.moveToElement(categoriaLivros).perform();
    }

    @When("passar o mouse sobre a categoria Papelaria")
    public void passarOMouseSobreACategoriaPapelaria() throws InterruptedException {
        Actions acao = new Actions(driver);
        WebElement menuCategoria = driver.findElement(By.cssSelector("[class^=\"lojasaraivanew-mega-menu-2-x-triggerContainer pointer\"]"));
        acao.moveToElement(menuCategoria).perform();
        Thread.sleep(3000);
        WebElement categoriaPapelaria = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/div/div[2]/section/div/div/nav/ul/div/div/div/div[2]/div/li/div"));
        acao.moveToElement(categoriaPapelaria).perform();
    }

    @When("passar o mouse sobre a categoria Presentes")
    public void passarOMouseSobreACategoriaPresentes() throws InterruptedException {
        Actions acao = new Actions(driver);
        WebElement menuCategoria = driver.findElement(By.cssSelector("[class^=\"lojasaraivanew-mega-menu-2-x-triggerContainer pointer\"]"));
        acao.moveToElement(menuCategoria).perform();
        Thread.sleep(3000);
        WebElement categoriaPresentes = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/div/div[2]/section/div/div/nav/ul/div/div/div/div[3]/div/li/div"));
        acao.moveToElement(categoriaPresentes).perform();
    }

    @When("passar o mouse sobre a categoria Brinquedos")
    public void passarOMouseSobreACategoriaBrinquedos() throws InterruptedException {
        Actions acao = new Actions(driver);
        WebElement menuCategoria = driver.findElement(By.cssSelector("[class^=\"lojasaraivanew-mega-menu-2-x-triggerContainer pointer\"]"));
        acao.moveToElement(menuCategoria).perform();
        Thread.sleep(3000);
        WebElement categoriaBrinquedos = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/div/div[2]/section/div/div/nav/ul/div/div/div/div[4]/div/li/div"));
        acao.moveToElement(categoriaBrinquedos).perform();
    }

    @When("passar o mouse sobre a categoria Bebe")
    public void passarOMouseSobreACategoriaBebe() throws InterruptedException {
        Actions acao = new Actions(driver);
        WebElement menuCategoria = driver.findElement(By.cssSelector("[class^=\"lojasaraivanew-mega-menu-2-x-triggerContainer pointer\"]"));
        acao.moveToElement(menuCategoria).perform();
        Thread.sleep(3000);
        WebElement categoriaBebe = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/div/div[2]/section/div/div/nav/ul/div/div/div/div[5]/div/li/div"));
        acao.moveToElement(categoriaBebe).perform();
    }

    @Then("deve exibir a subcategoria de {string}")
    public void deveExibirASubcategoriaDeLivros(String categoriaSelecionada) {
        WebElement primeiroItemSubcategoriaLivros = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[3]/div/div[2]/section/div/div/nav/div/div[1]/div[1]/div[1]/a"));
        String pathNameDoElemento = primeiroItemSubcategoriaLivros.getAttribute("pathname");
        Assertions.assertTrue(pathNameDoElemento.toLowerCase().startsWith("/" + categoriaSelecionada.toLowerCase()));
    }

    @Given("um usuario acessa a pagina de resultados por categoria {string}")
    public void umUsuarioAcessaAPaginaDeResultadosPorCategoria(String url) throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(3000);
    }

    @When("clicar em ordenar")
    public void clicarEmOrdenar() {
        WebElement botaoOrdenar = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[4]/div/div/section/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]"));
        Actions acao = new Actions(driver);
        acao.moveToElement(botaoOrdenar).click().perform();
    }

    @Then("deve exibir as opcoes de ordenar resultados")
    public void deveExibirAsOpcoesDeOrdenarResultados() throws InterruptedException {
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement opcoesDeOrdenarResultados = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div/div[4]/div/div/section/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/button[1]")));
        Assertions.assertTrue(opcoesDeOrdenarResultados.isDisplayed());
    }

    @When("selecionar algum criterio de ordenacao")
    public void selecionar_algum_criterio_de_ordenacao() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement botaoOrdenar = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[4]/div/div/section/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]"));
        Actions acao = new Actions(driver);
        acao.moveToElement(botaoOrdenar).click().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/div[4]/div/div/section/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/button[4]"))).click();
    }

    @Then("deve ordenar resultados conforme criterio")
    public void deve_ordenar_resultados_conforme_criterio() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> descontosDosProdutosExibidos = driver.findElements(By.cssSelector("[class^=\"vtex-product-price-1-x-savingsPercentage vtex-product-price-1-x-savingsPercentage--summaryPercentage\"]"));

        List<Double> descontosEmValoresDouble = new ArrayList<>();
        for (WebElement desconto : descontosDosProdutosExibidos) {
            String descontoDoProduto = desconto.getAttribute("textContent").replace("%", "");
            descontosEmValoresDouble.add(Double.parseDouble(descontoDoProduto));
        }

        for (int i = 0; i < descontosEmValoresDouble.size() - 1; i++) {
            assert descontosEmValoresDouble.get(i) >= descontosEmValoresDouble.get(i + 1);
        }
    }

    @When("selecionar criterio de ordenacao por descontos")
    public void selecionarCriterioDeOrdenacaoPorDescontos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement botaoOrdenar = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[4]/div/div/section/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]"));
        Actions acao = new Actions(driver);
        acao.moveToElement(botaoOrdenar).click().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/div[4]/div/div/section/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/button[4]"))).click();
    }

    @Then("deve ordenar resultados conforme criterio desconto de forma decrescente")
    public void deveOrdenarResultadosConformeCriterioDescontoDeFormaDecrescente() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> descontosDosProdutosExibidos = driver.findElements(By.cssSelector("[class^=\"vtex-product-price-1-x-savingsPercentage vtex-product-price-1-x-savingsPercentage--summaryPercentage\"]"));

        List<Double> descontosEmValoresDouble = new ArrayList<>();
        for (WebElement desconto : descontosDosProdutosExibidos) {
            String descontoDoProduto = desconto.getAttribute("textContent").replace("%", "");
            descontosEmValoresDouble.add(Double.parseDouble(descontoDoProduto));
        }

        for (int i = 0; i < descontosEmValoresDouble.size() - 1; i++) {
            assert descontosEmValoresDouble.get(i) >= descontosEmValoresDouble.get(i + 1);
        }
    }

    @When("selecionar criterio de ordenacao por menor preco")
    public void selecionarCriterioDeOrdenacaoPorMenorPreco() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement botaoOrdenar = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[4]/div/div/section/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]"));
        Actions acao = new Actions(driver);
        acao.moveToElement(botaoOrdenar).click().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/div[4]/div/div/section/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/button[6]"))).click();
    }

    @Then("deve ordenar resultados conforme preco de forma crescente")
    public void deveOrdenarResultadosConformePrecoDeFormaCrescente() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> precosDosProdutosExibidos = driver.findElements(By.cssSelector("[class^=\"vtex-product-price-1-x-sellingPriceValue\"]"));

        List<Double> precosEmValoresDouble = new ArrayList<>();
        for (WebElement precos : precosDosProdutosExibidos) {
            String precoDoProduto = precos.getAttribute("textContent").replaceAll("[^0-9,.]", "").replace(".", "").replace(",", ".");
            precosEmValoresDouble.add(Double.parseDouble(precoDoProduto));
        }

        for (int i = 0; i < precosEmValoresDouble.size() - 1; i++) {
            assert precosEmValoresDouble.get(i) <= precosEmValoresDouble.get(i + 1);
        }

    }

    @When("selecionar criterio de ordenacao por maior preco")
    public void selecionarCriterioDeOrdenacaoPorMaiorPreco() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement botaoOrdenar = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[4]/div/div/section/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]"));
        Actions acao = new Actions(driver);
        acao.moveToElement(botaoOrdenar).click().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/div[4]/div/div/section/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/button[5]"))).click();
    }

    @Then("deve ordenar resultados conforme preco de forma decrescente")
    public void deveOrdenarResultadosConformePrecoDeFormaDecrescente() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> precosDosProdutosExibidos = driver.findElements(By.cssSelector("[class^=\"vtex-product-price-1-x-sellingPriceValue\"]"));

        List<Double> precosEmValoresDouble = new ArrayList<>();
        for (WebElement precos : precosDosProdutosExibidos) {
            String precoDoProduto = precos.getAttribute("textContent").replaceAll("[^0-9,.]", "").replace(".", "").replace(",", ".");
            precosEmValoresDouble.add(Double.parseDouble(precoDoProduto));
        }

        for (int i = 0; i < precosEmValoresDouble.size() - 1; i++) {
            assert precosEmValoresDouble.get(i) >= precosEmValoresDouble.get(i + 1);
        }
    }

    @When("selecionar criterio de ordenacao por A a Z")
    public void selecionarCriterioDeOrdenacaoPorAAZ() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement botaoOrdenar = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[4]/div/div/section/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]"));
        Actions acao = new Actions(driver);
        acao.moveToElement(botaoOrdenar).click().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/div[4]/div/div/section/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/button[7]"))).click();
    }

    @Then("deve ordenar resultados conforme ordem alfabetica crescente")
    public void deveOrdenarResultadosConformeOrdemAlfabeticaCrescente() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> nomesDosProdutosExibidos = driver.findElements(By.cssSelector("[class^=\"vtex-product-price-1-x-sellingPriceValue\"]"));

        List<String> nomesDosProdutos = new ArrayList<>();
        for (WebElement nomes : nomesDosProdutosExibidos) {
            String nomeDoProduto = nomes.getAttribute("textContent");
            nomesDosProdutos.add(nomeDoProduto);
        }

        for (int i = 0; i < nomesDosProdutos.size() - 1; i++) {
            int isOrdemAlfabetica = nomesDosProdutos.get(i).compareTo(nomesDosProdutos.get(i + 1));
            assert isOrdemAlfabetica > 0;
        }
    }

    @When("selecionar criterio de ordenacao por Z a A")
    public void selecionarCriterioDeOrdenacaoPorZAA() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement botaoOrdenar = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[4]/div/div/section/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]"));
        Actions acao = new Actions(driver);
        acao.moveToElement(botaoOrdenar).click().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/div[4]/div/div/section/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/button[8]"))).click();
    }

    @Then("deve ordenar resultados conforme ordem alfabetica decrescente")
    public void deveOrdenarResultadosConformeOrdemAlfabeticaDecrescente() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> nomesDosProdutosExibidos = driver.findElements(By.cssSelector("[class^=\"vtex-product-price-1-x-sellingPriceValue\"]"));

        List<String> nomesDosProdutos = new ArrayList<>();
        for (WebElement nomes : nomesDosProdutosExibidos) {
            String nomeDoProduto = nomes.getAttribute("textContent");
            nomesDosProdutos.add(nomeDoProduto);
        }

        for (int i = 0; i < nomesDosProdutos.size() - 1; i++) {
            int isOrdemAlfabetica = nomesDosProdutos.get(i).compareTo(nomesDosProdutos.get(i + 1));
            assert isOrdemAlfabetica < 0;
        }
    }
    }
