package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CarrinhoPage;
import pages.HomePage;
import utils.DriverManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdicionarProdutoCarrinhoSteps {

    private WebDriver driver;
    private CarrinhoPage carrinhoPage;
    private HomePage homePage;

    @Given("o usuário selecionou Catalogo no menu lateral")
    public void acessarMenuLateral() {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
        homePage.acessarLinkCatalogo();
        assertTrue(driver.getCurrentUrl().endsWith("collections/all"));
    }

    @When("o usuário seleciona um produto no Catologo")
    public void selecionarProdutoNoCatologo() {   // <-- precisa ser public
        homePage.selecionarProduto();
        assertEquals("https://sauce-demo.myshopify.com/products/flower-print-jeans", homePage.getPaginaAtual());
    }

    @And("o usuário clica no botão Add to Cart")
    public void addProdutoNoCarrinho() {
        homePage.addProdutoCarrinho();
    }

    @Then("o produto deve ser adicionado ao carrinho")
    public void verificarProdutoCarrinho() {
        carrinhoPage = new CarrinhoPage(driver);
        assertTrue(carrinhoPage.carrinhoTemUmItem());
    }
}
