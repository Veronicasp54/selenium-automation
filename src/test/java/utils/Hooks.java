package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.TakesScreenshot;
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
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .until(d -> d instanceof TakesScreenshot);

        Screenshot.saveScreenshot(DriverManager.getDriver(), scenario.getName() + ".png");
    }


    // este roda depois, para encerrar o driver
    @After(order = 0)
    public void afterAll() {
        DriverManager.quitDriver();
    }
}
