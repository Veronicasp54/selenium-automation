package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.HomePage;

public class Hooks {


    @Before("not @loginInvalido and not @loginValido")
    public void beforeScenario() {
       HomePage homePage = new HomePage(DriverManager.getDriver());
        homePage.navigateTo();

    }

    @After
    public void afterScenario() {

        DriverManager.quitDriver();
    }


}
