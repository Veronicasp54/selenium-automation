package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.time.Duration;

public class PageUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    public PageUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // 1. Verifica se o DOM está pronto
    private void waitForPageLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = d ->
                ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete");
        wait.until(pageLoadCondition);
    }


    // 3. Verifica se não há loaders visíveis (exemplo: div com classe 'spinner' ou 'loading')
    private void waitForLoadersToDisappear() {
        ExpectedCondition<Boolean> loadersGone = d -> {
            try {
                return d.findElements(By.cssSelector(".spinner, .loading"))
                        .stream()
                        .noneMatch(WebElement::isDisplayed);
            } catch (Exception e) {
                return true;
            }
        };
        wait.until(loadersGone);
    }

    public void esperarPaginaCarregarComAnimacoes() {
        waitForPageLoad();
        waitForLoadersToDisappear();
    }
}
