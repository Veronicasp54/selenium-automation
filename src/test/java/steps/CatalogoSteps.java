package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.DriverManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CatalogoSteps {

    private WebDriver driver;
    private HomePage homePage;

    @Given("o usuário está autenticado na página inicial")
    public void autenticarUsuario() {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
//        driver.get("https://sauce-demo.myshopify.com/account");
        // Exemplo: adicionar múltiplos cookies
//        driver.manage().addCookie(new Cookie("localization", "BR"));
//        driver.manage().addCookie(new Cookie("cart_currency", "GBP"));
//        driver.manage().addCookie(new Cookie("_shopify_y", "e953b82c-3726-43ce-b6f6-73e274fd00fe"));
//        driver.manage().addCookie(new Cookie("_shopify_s", "5b337030-208e-417e-beb7-20e3c0086474"));
//        driver.manage().addCookie(new Cookie("_shopify_essential", "VALOR_COMPLETO_DO_COOKIE_AQUI"));

        // Depois de adicionar todos os cookies, recarregue a página
//        driver.navigate().refresh();
//        assertEquals("https://sauce-demo.myshopify.com/account", driver.getCurrentUrl());
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
