package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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



}
