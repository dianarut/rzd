
import ru.rzd.pageobjects.MainPage;
import ru.rzd.pageobjects.TenderPage;
import ru.rzd.pageobjects.TenderPlannedPurchasesPage;
import ru.rzd.pageobjects.TenderSearchPage;
import ru.rzd.util.ConfigurationManager;
import ru.rzd.util.Downloader;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TenderTest {

    private String downloadPath = ConfigurationManager.getProperty("tender.downloadPath");

    @Test
    public void plannedPurchaseTest() {
        MainPage mainPage = new MainPage();
        TenderPage tenderPage = mainPage.openTenderPage();
        TenderPlannedPurchasesPage tenderPlannedPurchasesPage = tenderPage.openPlannedpurchasePage();
        tenderPlannedPurchasesPage.downloadPurshasingPlan();
        String filename = tenderPlannedPurchasesPage.docName();
        Assert.assertTrue(Downloader.isFileDownloaded(downloadPath, filename));

    }

    @Test
    public void tenderSearchTest(){
        MainPage mainPage = new MainPage();
        TenderPage tenderPage = mainPage.openTenderPage();
        TenderSearchPage tenderSearchPage = tenderPage.openTenderSearchPage();
        tenderSearchPage.fillTheSearch();
        tenderSearchPage.search();
        Assert.assertTrue((tenderSearchPage.containsCorrectDate())&&(tenderSearchPage.citiesAmount()==tenderSearchPage.goodsAmount()));
    }



}
