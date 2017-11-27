import ru.rzd.pageobjects.LoginPage;
import ru.rzd.pageobjects.MainPage;
import ru.rzd.util.AssertManager;
import ru.rzd.util.ConfigurationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginFromMainPage {

    private String loginName = ConfigurationManager.getProperty("user.login");
    private String password = ConfigurationManager.getProperty("user.password");
    private MainPage mainPage;
    private LoginPage loginPage;

    @BeforeTest
    public void initializer() {
        mainPage = new MainPage();
        loginPage = new LoginPage();
    }

    @Test
    public void loginPage() {
        mainPage.goToLoginPage();
        Assert.assertTrue(AssertManager.isElementPresent(loginPage.getButtonForgotPassword()));
        loginPage.oneCanLoginToWebsite(loginName, password);
    }
}
