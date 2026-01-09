package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage{

    private WebDriver driver;
    private WebDriverWait wait;
    private final String urlHome = "https://sauce-demo.myshopify.com/";

    @FindBy(xpath = "//*[@id=\"add\"]")
    private WebElement btnAddCart;

    @FindBy(id="customer_login_link")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/li[2]/a")
    private WebElement linkCatalogo;

    @FindBy(xpath = "//*[@id=\"product-1\"]/img")
    private WebElement imgProduct;

    // Construtor único
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // timeout de 10s
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        driver.get(urlHome);
        wait.until(ExpectedConditions.visibilityOf(linkCatalogo)); // garante que o campo email esteja visível
    }
    public void acessarLinkCatalogo(){
        linkCatalogo.click();
    }

    public String getPaginaAtual() {
        return driver.getCurrentUrl();
    }

    public void selecionarProduto() {
        linkCatalogo.click();
        imgProduct.click();
    }

    public void addProdutoCarrinho() {
        btnAddCart.click();
    }
}




