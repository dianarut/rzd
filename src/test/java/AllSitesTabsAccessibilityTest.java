import com.rzd.selenium.factory.BrowserFactory;
import com.rzd.selenium.pageobjects.*;
import com.rzd.selenium.util.ConfigurationManager;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class AllSitesTabsAccessibilityTest {

    private MainPage mainPage;

    @BeforeMethod
    public void setUp(){
        BrowserFactory.getInstance().getDriver().get(ConfigurationManager.getProperty("driver.start"));
    }

    @Test
    public void forInvestorsAccessibility() throws InterruptedException {
        mainPage = new MainPage();
        AllSitesPage allSitesPage = mainPage.openAllSitesPage();
        ForInvestorsPage forInvestorsPage = allSitesPage.openInvestoramPage();
        Assert.assertTrue(forInvestorsPage.isForInvestorsPage()>0 );
    }

    @Test //тест будет падать, тк ссылка на страницу не работает. так было задумано
    public void restAndTreatmentAccessibility()  {
        mainPage = new MainPage();
        AllSitesPage allSitesPage = mainPage.openAllSitesPage();
        RestAndTreatmentPage restAndTreatmentPage = allSitesPage.openRestAndTreatmentPage();
        Assert.assertTrue(restAndTreatmentPage.isRestAndTreatmentPage() > 0, "Rest and Treatment failed");
    }

    @Test //тест будет падать, тк ссылка на страницу не работает. так было задумано
    public void gamesAccessibility(){
        mainPage = new MainPage();
        ActivityPage activityPage = mainPage.openActivityPage();
        activityPage.click2011();
        GamesPage gamesPage = activityPage.clickTheLink();
        Assert.assertTrue(gamesPage.isGamesPage()>0);
    }



}
