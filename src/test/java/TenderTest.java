
import ru.rzd.pageobjects.MainPage;
import ru.rzd.pageobjects.TenderPage;
import ru.rzd.pageobjects.TenderPlannedPurchasesPage;
import ru.rzd.pageobjects.TenderSearchPage;
import ru.rzd.util.AssertManager;
import ru.rzd.util.ConfigurationManager;
import ru.rzd.util.Downloader;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.rzd.util.TimeUtil;


public class TenderTest {

    private String dirWhereTodownload = ConfigurationManager.getProperty("tender.downloadPath");
    private String today = TimeUtil.getCurrentDate();

    @Test
    public void downloadingPurchasePlanTest() {
        MainPage mainPage = new MainPage();
        TenderPage tenderPage = mainPage.openTenderPage();
        TenderPlannedPurchasesPage tenderPlannedPurchasesPage = tenderPage.openPlannedpurchasePage();
        tenderPlannedPurchasesPage.downloadPurshasingPlan();
        String downloadedFileName = tenderPlannedPurchasesPage.getFilePurchaisePlan2017().getText();
        Assert.assertTrue(Downloader.isFileDownloaded(dirWhereTodownload, downloadedFileName));

    }

    @Test
    public void tenderSearchTest(){
        MainPage mainPage = new MainPage();
        TenderPage tenderPage = mainPage.openTenderPage();
        TenderSearchPage tenderSearchPage = tenderPage.openTenderSearchPage();
        tenderSearchPage.fillTheSearchForm();
        tenderSearchPage.search();
        Assert.assertTrue(AssertManager.isResultAfterFiltrationCorrect(tenderSearchPage.getGoods(), tenderSearchPage.getCities(), tenderSearchPage.getResultList(), today));
    }



}
