package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CatalogoPage;
import pages.HomePage;
import utils.DriverManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CatalogoSteps {

    private WebDriver driver;
    private HomePage homePage;
    private CatalogoPage catalogoPage;

    @Given("o usuário está autenticado na página inicial")
    public void autenticarUsuario() {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
        catalogoPage = new CatalogoPage(driver);
        homePage.navigateTo();
    }

    @When("o usuário clica no menu lateral {string}")
    public void clicarMenuLateral(String menu) {
        homePage.acessarLinkCatalogo();
    }

    @Then("o sistema deve direcionar para a página {string}")
    public void verificarPagina(String paginaEsperada) {
        String paginaAtual = homePage.getPaginaAtual();

        assertEquals(paginaAtual, paginaEsperada);

    }

    @And("a página deve exibir o título {string}")
    public void aPaginaDeveExibirOTitulo(String tituloEsperado) {
        String tituloAtual = catalogoPage.getTituloPaginaCatalogo();
        assertEquals(tituloAtual, tituloEsperado);
    }

    @And("deve existir pelo menos {int} produto listado no catálogo")
    public void deveExistirPeloMenosProdutoListadoNoCatalogo(int qtdMinima) {
        int qtdProdutos = catalogoPage.getQuantidadeProdutos();
        assertTrue(qtdProdutos >= qtdMinima);
    }
}
