
import com.rzd.selenium.factory.BrowserFactory;
import com.rzd.selenium.pageobjects.MainPage;
import com.rzd.selenium.pageobjects.MainPageEng;
import com.rzd.selenium.pageobjects.PassengerMainPageEng;
import com.rzd.selenium.util.ConfigurationManager;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class EngVersion {

    private MainPage mainPage;
    private MainPageEng mainPageEng;
    private PassengerMainPageEng passengerMainPageEng;
    private String mainPageURL = ConfigurationManager.getProperty("page.main.url");
    private String mainPageEngURL = ConfigurationManager.getProperty("page.mainEng.url");
    private String passengerMainEngTitle = ConfigurationManager.getProperty("page.passengerMainEng.title");



    @BeforeClass
    public void goToMainPage() {
        BrowserFactory.getInstance().getDriver().get(ConfigurationManager.getProperty("driver.start"));
    }

    @BeforeTest
    public void initializer() {
        mainPage = new MainPage();
        mainPageEng = new MainPageEng();
        passengerMainPageEng = new PassengerMainPageEng();
    }


    @Test
    public void goToEngMainPage() {
        String expectedURL = mainPageURL;
        String actualURL = BrowserFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        mainPage.goToEngVersion();
    }

    @Test(dependsOnMethods = "goToEngMainPage")
    public void goToMainPassPage() {
        String expectedURL = mainPageEngURL;
        String actualURL = BrowserFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        mainPageEng.goToPassengerMainPage();
    }

    @Test(dependsOnMethods = "goToMainPassPage")
    public void goToSuburbanTrainTab() {
        String expectedTitle = passengerMainEngTitle;
        String actualTitle = BrowserFactory.getInstance().getDriver().getTitle();
        passengerMainPageEng.goToSuburbanTrainTab();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(actualTitle.equals(expectedTitle), "Test should fail, suburban trains tab is not working");
        softAssert.assertAll();
    }


}




