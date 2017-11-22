import com.rzd.selenium.factory.BrowserFactory;
import com.rzd.selenium.pageobjects.MainPage;
import com.rzd.selenium.pageobjects.TenderPage;
import com.rzd.selenium.pageobjects.TenderPlannedPurchasesPage;
import com.rzd.selenium.pageobjects.TenderSearchPage;
import com.rzd.selenium.util.ConfigurationManager;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;


public class TenderTest {

    private String downloadPath = ConfigurationManager.getProperty("tender.downloadPath");

    @Test
    public void plannedPurchaseTest() {
        MainPage mainPage = new MainPage();
        TenderPage tenderPage = mainPage.openTenderPage();
        TenderPlannedPurchasesPage tenderPlannedPurchasesPage = tenderPage.openPlannedpurchasePage();
        tenderPlannedPurchasesPage.downloadPurshasingPlan();
        String fileName = tenderPlannedPurchasesPage.docName();
        Assert.assertTrue(tenderPlannedPurchasesPage.isFileDownloaded(downloadPath, fileName));

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
