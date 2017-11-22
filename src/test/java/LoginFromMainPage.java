import com.rzd.selenium.factory.BrowserFactory;
import com.rzd.selenium.pageobjects.LoginPage;
import com.rzd.selenium.pageobjects.MainPage;
import com.rzd.selenium.util.ConfigurationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginFromMainPage {

    private String userName = ConfigurationManager.getProperty("user.login");
    private String password = ConfigurationManager.getProperty("user.password");
    private String mainPageURL = ConfigurationManager.getProperty("page.main.url");
    private String loginPageURL = ConfigurationManager.getProperty("page.login.url");
    private MainPage mainPage;
    private LoginPage loginPage;


    @BeforeTest
    public void initializer() {
        mainPage = new MainPage();
        loginPage = new LoginPage();
    }

    @Test
    public void mainPage() {
        String expectedTitle = mainPageURL;
        String actualTitle = BrowserFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals(actualTitle, expectedTitle);
        mainPage.goToLoginPage();
    }

    @Test(priority = 2, dependsOnMethods = "mainPage")
    public void loginPage() {
        String expectedTitle = loginPageURL;
        String actualTitle = BrowserFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        loginPage.nameField(userName);
        loginPage.passwordField(password);
        loginPage.submitButton();
    }
}
