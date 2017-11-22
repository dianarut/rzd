import com.rzd.selenium.factory.BrowserFactory;
import com.rzd.selenium.pageobjects.MainPage;
import com.rzd.selenium.pageobjects.PassengerMainPage;
import com.rzd.selenium.pageobjects.SuburbanTrainConfirmationPage;
import com.rzd.selenium.pageobjects.SuburbanTrainMainPage;
import com.rzd.selenium.util.ConfigurationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BuyingTicketForSuburbanTrain_RU {


    private MainPage mainPage;
    private PassengerMainPage passengerMainPage;
    private SuburbanTrainMainPage suburbanTrainMainPage;
    private SuburbanTrainConfirmationPage suburbanTrainConfirmationPage;

    private String mainPageURL = ConfigurationManager.getProperty("page.main.url");
    private String surname = ConfigurationManager.getProperty("passport.surname");
    private String initials = ConfigurationManager.getProperty("passport.initials");
    private String passportNumber = ConfigurationManager.getProperty("passport.number");
    private String passengerMainPageTitle = ConfigurationManager.getProperty("page.passengerMain.title");
    private String suburbanTrainMainPageTitle = ConfigurationManager.getProperty("page.suburbanTrainMainPage.title");
    private String suburbanTrainConfirmationPageTitle = ConfigurationManager.getProperty("page.suburbanTrainConfirmationPage.title");


    @BeforeTest
    public void goToMainPage() {
        BrowserFactory.getInstance().getDriver().get(ConfigurationManager.getProperty("driver.start"));
    }


    @BeforeClass
    public void initializer() {
        mainPage = new MainPage();
        passengerMainPage = new PassengerMainPage();
        suburbanTrainMainPage = new SuburbanTrainMainPage();
        suburbanTrainConfirmationPage = new SuburbanTrainConfirmationPage();
    }

    @Test
    public void goToPassengersTab() {
        String expectedTitle = mainPageURL;
        String actualTitle = BrowserFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals(actualTitle, expectedTitle);
        mainPage.clickPassengersButton();
    }

    @Test(description = "Going to suburban trains page", dependsOnMethods = "goToPassengersTab")
    public void clickOnSuburbanTrainsTab() {
        String expectedTitle = passengerMainPageTitle;
        String actualTitle = BrowserFactory.getInstance().getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        passengerMainPage.clickOnSuburbanTrainsTab();
    }

    @Test(description = "Filling all fields with correct data", dependsOnMethods = "clickOnSuburbanTrainsTab")
    public void inputCorrectData() {
        String expectedTitle = suburbanTrainMainPageTitle;
        String actualTitle = BrowserFactory.getInstance().getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        suburbanTrainMainPage.fillAllFields(surname, initials, passportNumber);
    }

    @Test(description = "Clicking checkbox and going to paymentPage", dependsOnMethods = "inputCorrectData")
    public void checkboxAndSubmit() {
        String expectedHTMLh1 = suburbanTrainConfirmationPageTitle;
        String actualHTMLh1 = suburbanTrainConfirmationPage.pageh1Text();
        Assert.assertEquals(actualHTMLh1, expectedHTMLh1);
        suburbanTrainConfirmationPage.clickOnIAgreeCheckbox();
        suburbanTrainConfirmationPage.clickOnSubmitButton();
    }

}
