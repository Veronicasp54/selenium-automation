package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverManager;

import static org.junit.Assert.assertTrue;

public class LoginInvalidoSteps {

    LoginPage loginPage = new LoginPage(DriverManager.getDriver());

    @Given("que o usuário está na página de login")
    public void acessarLogin() {
        loginPage.navigateTo();
    }

    @When("o usuário insere o email {string}")
    public void usuarioInsereEmail(String email) {
        String emailInvalido = ConfigReader.getProperty(email);
        loginPage.preencherEmail(emailInvalido);
    }

    @And("o usuário insere a senha {string}")
    public void usuarioInsereASenha(String senha) {
        String senhaInvalida = ConfigReader.getProperty(senha);
        loginPage.preencherSenha(senhaInvalida);
        loginPage.clicarBotaoLoginHumano();
    }

    @Then("o sistema deve exibir a mensagem de erro {string}")
    public void verificarMensagemErro(String mensagemEsperada) {
        assertTrue(mensagemEsperada.contains(loginPage.getErrorMessage()));
    }


}
