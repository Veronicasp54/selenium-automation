package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CarrinhoPage;
import pages.HomePage;
import utils.DriverManager;

import static org.junit.Assert.assertTrue;

public class RemoverProdutoCarrinhoSteps {

    private WebDriver driver;
    private CarrinhoPage carrinhoPage;
    private HomePage homePage;

    @Given("adicionou produto no carrinho")
    public void adicionouProdutoNoCarrinho() {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
        homePage.navigateTo();
        homePage.acessarLinkCatalogo();
        homePage.selecionarProduto();
        homePage.addProdutoCarrinho();
    }

    @And("o usuário selecionou a opção My Cart")
    public void usuarioSelecionaMyCart() {
        carrinhoPage = new CarrinhoPage(driver);
        carrinhoPage.abrirCarrinho();
    }

    @When("o usuário clica no link de remover ao lado do produto")
    public void usuarioRemoveProduto() {

        carrinhoPage.removerProduto();
    }

    @Then("o sistema apresentará a mensagem de que o carrinho está vazio {string}")
    public void verificarMensagemCarrinhoVazio(String mensagemEsperada) {
        String mensagem = carrinhoPage.getMensagemCarrinhoVazio();
        assertTrue(mensagem.contains(mensagemEsperada));
    }


}
