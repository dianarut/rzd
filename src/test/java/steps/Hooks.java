package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import static steps.LoginFromMainPage.loginPage;

public class Hooks {
    @Before
    public void beforeScenario(){
        loginPage();
    }

    @After
    public void afterScenario(){
    }
}