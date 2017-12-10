package steps;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.rzd.business_objects.User;
import ru.rzd.pageobjects.LoginPage;
import ru.rzd.pageobjects.MainPage;
import ru.rzd.util.AssertManager;

public class LoginFromMainPage {

    @Test
    public static void loginPage() {
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        loginPage = new LoginPage();
        mainPage.goToLoginPage();
        Assert.assertTrue(AssertManager.isElementPresent(loginPage.getButtonForgotPassword()));
        loginPage.oneCanLoginToWebsite(new User());
    }
}
