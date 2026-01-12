package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverManager;

import static org.junit.Assert.assertTrue;

public class LoginInvalidoSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("que o usuário está na página de login")
    public void acessarLogin() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.navigateTo();
    }

    @When("o usuário insere o email {string}")
    public void usuarioInsereEmail(String email) {
        loginPage.preencherEmail(email);
    }

    @And("o usuário insere a senha invalida {string}")
    public void usuarioInsereSenhaInvalida(String senha) {
        loginPage.preencherSenha(senha);
        loginPage.clicarBotaoLoginHumano();

    }

    @Then("o sistema deve exibir a mensagem de erro {string}")
    public void verificarMensagemErro(String mensagemEsperada) {
        String mensagem = loginPage.getErrorMessage();
        assertTrue(mensagem.contains(mensagemEsperada));
    }
}
