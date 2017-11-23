
import com.rzd.selenium.pageobjects.MainPage;
import com.rzd.selenium.pageobjects.TenderPage;
import com.rzd.selenium.pageobjects.TenderPlannedPurchasesPage;
import com.rzd.selenium.pageobjects.TenderSearchPage;
import com.rzd.selenium.util.ConfigurationManager;
import com.rzd.selenium.util.Downloader;
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
