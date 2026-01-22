package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginValidoSteps {

    LoginPage loginPage = new LoginPage(DriverManager.getDriver());


    @Given("usuário está na página de login")
    public void usuarioNaPaginaDeLogin() {
        loginPage.navigateTo();
    }

    @When("o usuário insere email {string}")
    public void usuarioInsereEmail(String email) {

        String emailValido = ConfigReader.getProperty(email);
        loginPage.preencherEmail(emailValido);
    }

    @And("o usuário insere senha {string}")
    public void usuarioInsereSenha(String senha) {
        String senhaValida = ConfigReader.getProperty(senha);
        loginPage.preencherSenha(senhaValida);
    }

    @And("o usuário clica no botão Sign In")
    public void usuarioClicaNoBotao() {
        loginPage.clicarBotaoLoginHumano();
    }

    @Then("o sistema apresenta a página {string} com mensagem {string}")
    public void sistemaApresentaPagina(String paginaEsperada, String mensagemEsperada) {
        // Verifica se a página atual é a esperada
        String paginaAtual = loginPage.getPaginaAtual();
        assertEquals("Página exibida não corresponde à esperada", paginaEsperada, paginaAtual);
        // Verifica se a mensagem exibida contém o texto esperado
        String mensagemAtual = loginPage.getMensagemPosLogin();
        assertTrue("Mensagem exibida não contém o texto esperado. Esperado: " + mensagemEsperada + " | Atual: " + mensagemAtual, mensagemAtual.contains(mensagemEsperada));
    }
}
