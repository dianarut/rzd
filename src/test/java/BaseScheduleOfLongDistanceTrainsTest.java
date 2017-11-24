import ru.rzd.factory.BrowserFactory;
import ru.rzd.pageobjects.BasicScheduleLDTrainsResultsPage;
import ru.rzd.pageobjects.BasicSchedulePage;
import ru.rzd.pageobjects.MainPage;
import ru.rzd.pageobjects.PassengerMainPage;
import ru.rzd.util.ConfigurationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseScheduleOfLongDistanceTrainsTest{
    private String from = ConfigurationManager.getProperty("movement.base.from");
    private String to = ConfigurationManager.getProperty("movement.base.to");
    private String loginPageTitle = ConfigurationManager.getProperty("page.login.title");
    private String passengerMainTitle = ConfigurationManager.getProperty("page.passengerMain.title");

    @BeforeClass
    public void init2() {
        BrowserFactory.getInstance().getDriver().get(ConfigurationManager.getProperty("driver.start"));
    }

    @Test
    public void baseScheduleLDTrainsTest_MainPage() {
        MainPage mainPage = new MainPage();
        //Assert.assertTrue(mainPage.checkPassengersFrom(), "There are no passengers form!");
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
