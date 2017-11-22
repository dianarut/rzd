import com.rzd.selenium.factory.BrowserFactory;
import com.rzd.selenium.pageobjects.*;
import com.rzd.selenium.util.ConfigurationManager;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class AllSitesTabTest {

    private MainPage mainPage;

    @BeforeMethod
    public void setUp(){
        BrowserFactory.getInstance().getDriver().get(ConfigurationManager.getProperty("driver.start"));
    }

    @Test(priority=2)
    public void forInvestorsAccessibility() throws InterruptedException {
        mainPage = new MainPage();
        AllSitesPage allSitesPage = mainPage.openAllSitesPage();
        ForInvestorsPage forInvestorsPage = allSitesPage.openInvestoramPage();
        Assert.assertTrue(forInvestorsPage.isForInvestorsPage()>0 );
    }

    @Test(priority=1) //тест будет падать, тк ссылка на страницу не работает. так было задумано
    public void restAndTreatmentAccessibility()  {
        mainPage = new MainPage();
        AllSitesPage allSitesPage = mainPage.openAllSitesPage();
        RestAndTreatmentPage restAndTreatmentPage = allSitesPage.openRestAndTreatmentPage();
        Assert.assertTrue(restAndTreatmentPage.isRestAndTreatmentPage() > 0, "Rest and Treatment failed");
    }

    @Test(priority=3) //тест будет падать, тк ссылка на страницу не работает. так было задумано
    public void gamesAccessibility(){
        mainPage = new MainPage();
        ActivityPage activityPage = mainPage.openActivityPage();
        activityPage.switchTabInBrowser();
        activityPage.click2011();
        GamesPage gamesPage = activityPage.clickTheLink();
        Assert.assertTrue(gamesPage.isGamesPage()>0);
    }



}
