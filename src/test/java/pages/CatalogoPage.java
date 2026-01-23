package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CatalogoPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Construtor único
    public CatalogoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // timeout de 10s
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"product-1\"]/img")
    private WebElement imgCatalogo;

    @FindBy(xpath = "//h1[text()='Products']")
    private WebElement tituloPaginaCatalogo;

    @FindBy(css = "section.product-grid div.four.columns")
    private List<WebElement> listaProdutos;

    public List<WebElement> getProdutos() {
        return listaProdutos;
    }

    public int getQuantidadeProdutos() {
        System.out.println("Quantidade de produtos: " + listaProdutos.size());
        return getProdutos().size();
    }


    public String getTituloPaginaCatalogo() {
        wait.until(ExpectedConditions.visibilityOf(tituloPaginaCatalogo));
        return tituloPaginaCatalogo.getText();
    }

}
