package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.LoginPage;
import utils.DriverManager;

public class Hooks {


    @Before
    public void beforeScenario() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.realizarLogin();

    }

    @After
    public void afterScenario() {
        DriverManager.quitDriver();
    }


}
