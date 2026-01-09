package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;


public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String urlLogin = "https://sauce-demo.myshopify.com/account/login";

    @FindBy(id = "customer_email")
    private WebElement emailField;

    @FindBy(id = "customer_password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='customer_login']/div[5]/input")
    private WebElement loginButton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    // Construtor único
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // timeout de 10s
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        driver.get(urlLogin);
        wait.until(ExpectedConditions.visibilityOf(emailField)); // garante que o campo email esteja visível
    }

    // Realizar login
    public void preencherEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).clear();
        emailField.sendKeys(email);
    }

    public void preencherSenha(String senha) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).clear();
        passwordField.sendKeys(senha);
    }

    public void clicarBotaoLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

    }

    public void realizarLogin(){
        navigateTo();
        preencherEmail("veronicasp54@gmail.com");
        preencherSenha("testes123");
        clicarBotaoLogin();
    }


        // Obter mensagem de erro
    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
    }

    public String getPaginaAtual() {
        return driver.getCurrentUrl();
    }
}
