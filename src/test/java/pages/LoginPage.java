package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String urlLogin = "https://sauce-demo.myshopify.com/account/login";
    private final String urlAccount = "https://sauce-demo.myshopify.com/account";

    @FindBy(id = "customer_email")
    private WebElement emailField;

    @FindBy(id = "customer_password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit' and @value='Sign In']")
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
        //emailField.sendKeys(email);
        digitarComoHumano(emailField, email);
    }

    public void preencherSenha(String senha) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).clear();
       // passwordField.sendKeys(senha);
        digitarComoHumano(passwordField, senha);

    }

    public void clicarBotaoLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        clicarBotaoLoginHumano();
        String urlAtual = driver.getCurrentUrl();
        assertEquals("https://sauce-demo.myshopify.com/account", urlAtual);


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

    private void digitarComoHumano(WebElement campo, String texto) {
        wait.until(ExpectedConditions.visibilityOf(campo)).clear();
        for (char c : texto.toCharArray()) {
            campo.sendKeys(String.valueOf(c));
            try {
                Thread.sleep(150 + (int)(Math.random() * 150));
                // espera entre 150–300ms aleatório
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void clicarBotaoLoginHumano() {
        // 1. Espera o botão estar clicável
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        // 2. Pequena pausa aleatória (simulando tempo de reação humana)
        try { Thread.sleep(800); } catch (InterruptedException e) {}

        // 3. Move o mouse até o elemento e clica
        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton)
                .pause(Duration.ofMillis(200)) // Pausa com o mouse sobre o botão
                .click()
                .perform();
    }



}

