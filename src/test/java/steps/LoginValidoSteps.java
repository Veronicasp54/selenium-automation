package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginValidoSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("usuário está na página de login")
    public void usuarioNaPaginaDeLogin() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://sauce-demo.myshopify.com/account");
        loginPage.navigateTo();
    }

    @When("o usuário insere email {string}")
    public void usuarioInsereEmail(String email) {
        loginPage.preencherEmail(email);
    }

    @And("o usuário insere senha {string}")
    public void usuarioInsereSenha(String senha) {
        loginPage.preencherSenha(senha);
    }

    @And("o usuário clica no botão Sign In")
    public void usuarioClicaNoBotao() {
        loginPage.clicarBotaoLogin();
    }

    @Then("o sistema apresenta a página {string}")
    public void sistemaApresentaPagina(String paginaEsperada) {
        String paginaAtual = loginPage.getPaginaAtual();
        assertEquals(paginaEsperada, paginaAtual);
        //  assertTrue(paginaAtual.contains(paginaEsperada));
    }
}
