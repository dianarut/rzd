import com.rzd.selenium.factory.BrowserFactory;
import com.rzd.selenium.util.ConfigurationManager;
import org.testng.Assert;
import com.rzd.selenium.pageobjects.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseScheduleOfLongDistanceTrainsTest{
    private String from = ConfigurationManager.getProperty("movement.base.from");
    private String to = ConfigurationManager.getProperty("movement.base.to");
    private String loginPageTitle = ConfigurationManager.getProperty("page.login.title");
    private String passengerMainTitle = ConfigurationManager.getProperty("page.passengerMain.title");

    @BeforeTest
    public void goToMainPage() {
        BrowserFactory.getInstance().getDriver().get(ConfigurationManager.getProperty("driver.start"));
    }

    @Test
    public void baseScheduleLDTrainsTest_MainPage() {
        String actualTitle = BrowserFactory.getInstance().getDriver().getTitle();
        String expectedTitle = loginPageTitle;
        Assert.assertEquals(actualTitle, expectedTitle);
        MainPage mainPage = new MainPage();
        mainPage.clickPassengersButton();
    }

    @Test(dependsOnMethods = "baseScheduleLDTrainsTest_MainPage")
    public void baseScheduleLDTrainsTest_PassengerMainPage() {
        String actualTitle = BrowserFactory.getInstance().getDriver().getTitle();
        String expectedTitle = passengerMainTitle;
        Assert.assertEquals(actualTitle, expectedTitle);
        PassengerMainPage passengerMainPage = new PassengerMainPage();
        passengerMainPage.clickBasicScheduleTab();
    }

    @Test(dependsOnMethods = "baseScheduleLDTrainsTest_PassengerMainPage")
    public void baseScheduleLDTrainsTest_BasicSchedulePage() {
        String actualTitle = BrowserFactory.getInstance().getDriver().getTitle();
        String expectedTitle = passengerMainTitle;
        Assert.assertEquals(actualTitle, expectedTitle);
        BasicSchedulePage basicSchedulePage = new BasicSchedulePage();
        basicSchedulePage.fillForm(from, to);
    }

    @Test(dependsOnMethods = "baseScheduleLDTrainsTest_BasicSchedulePage")
    public void baseScheduleLDTrainsTest_BasicScheduleLDTrainsResultsPage() {
        BasicScheduleLDTrainsResultsPage basicScheduleLDTrainsResultsPage = new BasicScheduleLDTrainsResultsPage();
        Assert.assertEquals(basicScheduleLDTrainsResultsPage.getFrom(),from);
        Assert.assertEquals(basicScheduleLDTrainsResultsPage.getTo(),to);
        basicScheduleLDTrainsResultsPage.clickSomeDate();
        Assert.assertTrue(basicScheduleLDTrainsResultsPage.checkInformationMessage(),"The information message about route not found!");
    }
}
