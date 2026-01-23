package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CarrinhoPage {


    private final WebDriver driver;
    private WebDriverWait wait;
    private String urlHome = "https://sauce-demo.myshopify.com/";

    @FindBy(xpath = "//*[@id=\"minicart\"]/a[1]")
    private WebElement btnMinicart;

    @FindBy(xpath = "//*[@id=\"drawer\"]/div/form/div[1]/div[5]/a")
    private WebElement btnRemoveToCart;

    @FindBy(xpath = "//*[@id=\"drawer\"]/div/div/p")
    private WebElement mensagemCarrinho;

    @FindBy(id = "cart-target-desktop")
    private WebElement numeroProdutosCarrinho;

    @FindBy(xpath = "//*[@id=\"drawer\"]")
    private WebElement carrinhoProdutos;

    @FindBy(id ="drawer")
    private WebElement bannerCarrinho;

    public CarrinhoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public String getNumeroProdutosCarrinho() {
        wait.until(ExpectedConditions.textToBePresentInElement(numeroProdutosCarrinho, "1"));
        String texto = numeroProdutosCarrinho.getText().trim();
        texto = texto.replaceAll("[()]", "");
        System.out.println("Texto tratado do carrinho: " + texto); // imprime no console

        return texto;
    }

    public boolean carrinhoTemUmItem() {
        return getNumeroProdutosCarrinho().equals("1");
    }

    public void navigateTo() {
        driver.get(urlHome);
        wait.until(ExpectedConditions.visibilityOf(btnMinicart));
    }

    public void abrirCarrinho() {

        if (carrinhoTemUmItem()) {
            driver.navigate().refresh();
            btnMinicart.click();
            System.out.println("Carrinho aberto com item.");
        } else {
            System.out.println("Carrinho vazio, não foi aberto.");
        }


    }

    public void removerProduto() {

        wait.until(ExpectedConditions.visibilityOf(carrinhoProdutos));
        wait.until(ExpectedConditions.elementToBeClickable(btnRemoveToCart));
        btnRemoveToCart.click();
        System.out.println("btn removido selecionado.");


    }

    public String getMensagemCarrinhoVazio() {
        wait.until(ExpectedConditions.visibilityOf(bannerCarrinho));
        wait.until(ExpectedConditions.visibilityOf(mensagemCarrinho));

        //  wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemCarrinho));

        return mensagemCarrinho.getText();
    }
}
