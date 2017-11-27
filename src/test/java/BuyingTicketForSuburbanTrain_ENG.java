import org.testng.annotations.BeforeMethod;
import ru.rzd.factory.BrowserFactory;
import ru.rzd.pageobjects.MainPage;
import ru.rzd.pageobjects.MainPageEng;
import ru.rzd.pageobjects.PassengerMainPageEng;
import ru.rzd.util.AssertManager;
import ru.rzd.util.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BuyingTicketForSuburbanTrain_ENG {

    private WebDriver driver = BrowserFactory.getInstance().getDriver();
    private MainPage mainPage;
    private MainPageEng mainPageEng;
    private PassengerMainPageEng passengerMainPageEng;
    private String passengerMainEngTitle = ConfigurationManager.getProperty("page.passengerMainEng.title");

    @BeforeMethod
    public void goToMainPage() {
        driver.get(ConfigurationManager.getProperty("driver.start"));
    }

    @BeforeTest
    public void initializer() {
        mainPage = new MainPage();
        mainPageEng = new MainPageEng();
        passengerMainPageEng = new PassengerMainPageEng();
    }

    @Test()
    public void goToMainPassPage() {
        mainPage.goToEngVersion();
        Assert.assertTrue(AssertManager.isElementPresent(mainPageEng.getPassengerServiceText()));
        mainPageEng.goToPassengerMainPage();
    }

    @Test()
    public void goToSuburbanTrainTab() {
        mainPage.goToEngVersion();
        mainPageEng.goToPassengerMainPage();
        String expectedTitle = passengerMainEngTitle;
        String actualTitle = driver.getTitle();
        passengerMainPageEng.goToSuburbanTrainTab();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(actualTitle.equals(expectedTitle), "Test should fail, suburban trains tab is not working");
        softAssert.assertAll();
    }


}




