package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.DriverManager;

import static org.junit.Assert.assertEquals;

public class CatalogoSteps {

    private WebDriver driver;
    private HomePage homePage;

    @Given("o usuário está autenticado na página inicial")
    public void autenticarUsuario() {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
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
}
