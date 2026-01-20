package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;

public class Hooks {

    @Before("not @loginInvalido and not @loginValido")
    public void beforeScenario() {
        HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.navigateTo();
    }

    // este roda após cada cenário
    @After(order = 1)
    public void afterScenario(io.cucumber.java.Scenario scenario) {
        try {
            Thread.sleep(2000);
            // espera 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Screenshot.saveScreenshot(DriverManager.getDriver(), scenario.getName() + ".png");
    }

    // este roda depois, para encerrar o driver
    @After(order = 0)
    public void afterAll() {
        DriverManager.quitDriver();
    }
}
