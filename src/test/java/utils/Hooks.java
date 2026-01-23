package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;

public class Hooks {

    @Before("not @loginInvalido and not @loginValido")
    public void beforeScenario() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.navigateTo();
    }

    @After(order = 1)
    public void afterScenario(io.cucumber.java.Scenario scenario) {
        WebDriver driver = DriverManager.getDriver();

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(d -> d instanceof TakesScreenshot);

        PageUtils pageUtils = new PageUtils(driver);
        pageUtils.esperarPaginaCarregarComAnimacoes();

        Screenshot.saveScreenshot(driver, scenario.getName() + ".png");
    }


    // este roda depois, para encerrar o driver
    @After(order = 0)
    public void afterAll() {
        DriverManager.quitDriver();
    }
}
