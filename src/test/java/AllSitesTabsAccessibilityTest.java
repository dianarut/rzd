import org.testng.annotations.AfterClass;
import ru.rzd.factory.BrowserFactory;
import ru.rzd.pageobjects.*;
import ru.rzd.util.AssertManager;
import ru.rzd.util.ConfigurationManager;
import org.testng.Assert;
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
        Assert.assertTrue(AssertManager.isElementPresent(forInvestorsPage.getInvestoramPageAtribute()));
    }

    @Test //тест будет падать, тк ссылка на страницу не работает. так было задумано
    public void restAndTreatmentAccessibility()  {
        mainPage = new MainPage();
        AllSitesPage allSitesPage = mainPage.openAllSitesPage();
        RestAndTreatmentPage restAndTreatmentPage = allSitesPage.openRestAndTreatmentPage();
        Assert.assertTrue(AssertManager.isElementPresent(restAndTreatmentPage.getRestAndtreatmentPageAtribute()), "Rest and Treatment page failed");
    }

    @Test //тест будет падать, тк ссылка на страницу не работает. так было задумано
    public void gamesAccessibility(){
        mainPage = new MainPage();
        ActivityPage activityPage = mainPage.openActivityPage();
        activityPage.clickLinkTo2011report();
        GamesPage gamesPage = activityPage.clickLinklinkToGamesPage();
        Assert.assertTrue(AssertManager.isElementPresent(gamesPage.getGamesPageAtribute()), "Games page failed");
    }
<<<<<<< HEAD
//
=======

>>>>>>> test_master
//    @AfterClass
//    public void afterCLass(){
//        BrowserFactory.getInstance().getDriver().quit();
//    }


}
