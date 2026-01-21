package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final int DELAY_MS = 5000;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "customer_email")
    private WebElement emailField;

    @FindBy(id = "customer_password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit' and @value='Sign In']")
    private WebElement loginButton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;


    public void navigateTo() {
        String urlLogin = "https://sauce-demo.myshopify.com/account/login";
        driver.get(urlLogin);
        wait.until(ExpectedConditions.visibilityOf(emailField)); // garante que o campo email esteja visível
    }

    // Realizar login
    public void preencherEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).clear();
        digitarComoHumano(emailField, email);
    }

    public void preencherSenha(String senha) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).clear();
        digitarComoHumano(passwordField, senha);

    }

    public void clicarBotaoLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        clicarBotaoLoginHumano();
    }

//    public void realizarLogin(){
//        navigateTo();
//        preencherEmail("veronicasp54@gmail.com");
//        preencherSenha("testes123");
//        clicarBotaoLogin();
//    }


    // Obter mensagem de erro
    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
    }

    public String getPaginaAtual() {
        return driver.getCurrentUrl();
    }

    private void digitarComoHumano(WebElement campo, String texto) {
        WebElement elemento = wait.until(ExpectedConditions.visibilityOf(campo));
        elemento.clear();

        for (char c : texto.toCharArray()) {
            elemento.sendKeys(String.valueOf(c));
            Duration delay = Duration.ofMillis(DELAY_MS);
            new WebDriverWait(driver, delay).until(d -> true);
        }
    }


    public void clicarBotaoLoginHumano() {
        WebElement botao = wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        Actions actions = new Actions(driver);
        actions.moveToElement(botao)
                .pause(Duration.ofMillis(200)) // simula tempo de reação
                .click()
                .perform();
    }

}

