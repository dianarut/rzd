import org.testng.annotations.BeforeMethod;
import ru.rzd.factory.BrowserFactory;
import ru.rzd.pageobjects.MainPage;
import ru.rzd.pageobjects.PassengerMainPage;
import ru.rzd.pageobjects.SuburbanTrainConfirmationPage;
import ru.rzd.pageobjects.SuburbanTrainMainPage;
import ru.rzd.util.AssertManager;
import ru.rzd.util.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BuyingTicketForSuburbanTrain_RU {

    private WebDriver driver = BrowserFactory.getInstance().getDriver();
    private MainPage mainPage;
    private PassengerMainPage passengerMainPage;
    private SuburbanTrainMainPage suburbanTrainMainPage;
    private SuburbanTrainConfirmationPage suburbanTrainConfirmationPage;
    private String surname = ConfigurationManager.getProperty("passport.surname");
    private String initials = ConfigurationManager.getProperty("passport.initials");
    private String passportNumber = ConfigurationManager.getProperty("passport.number");

    @BeforeMethod
    public void goToMainPage() {
        driver.get(ConfigurationManager.getProperty("driver.start"));
    }

    @BeforeClass
    public void initializer() {
        mainPage = new MainPage();
        passengerMainPage = new PassengerMainPage();
        suburbanTrainMainPage = new SuburbanTrainMainPage();
        suburbanTrainConfirmationPage = new SuburbanTrainConfirmationPage();
    }

    @Test(description = "Going to suburban trains page")
    public void clickOnSuburbanTrainsTab() {
        mainPage.clickPassengersButton();
        Assert.assertTrue(AssertManager.isElementPresent(passengerMainPage.getPageh1Text()));
        passengerMainPage.clickOnSuburbanTrainsTab();
    }

    @Test(description = "Filling all fields with correct data")
    public void inputCorrectData() {
        mainPage.clickPassengersButton();
        passengerMainPage.clickOnSuburbanTrainsTab();
        Assert.assertTrue(AssertManager.isElementPresent(suburbanTrainMainPage.getPageh1Text()));
        suburbanTrainMainPage.fillAllFields(surname, initials, passportNumber);
    }

    @Test(description = "Clicking checkbox and going to paymentPage")
    public void checkboxAndSubmit() {
        mainPage.clickPassengersButton();
        passengerMainPage.clickOnSuburbanTrainsTab();
        suburbanTrainMainPage.fillAllFields(surname, initials, passportNumber);
        Assert.assertTrue(AssertManager.isElementPresent(suburbanTrainConfirmationPage.getPageh1Text()));
        suburbanTrainConfirmationPage.oneAgreeToTermOfUse();
    }

}
