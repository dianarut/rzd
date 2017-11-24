import ru.rzd.factory.BrowserFactory;
import ru.rzd.pageobjects.MainPage;
import ru.rzd.pageobjects.PassengerMainPage;
import ru.rzd.pageobjects.SuburbanTrainConfirmationPage;
import ru.rzd.pageobjects.SuburbanTrainMainPage;
import ru.rzd.util.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BuyingTicketForSuburbanTrain_RU {

    private WebDriver driver = BrowserFactory.getInstance().getDriver();

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
        driver.get(ConfigurationManager.getProperty("driver.start"));
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
        String actualTitle = driver.getCurrentUrl();
        Assert.assertEquals(actualTitle, expectedTitle);
        mainPage.clickPassengersButton();
    }

    @Test(description = "Going to suburban trains page", dependsOnMethods = "goToPassengersTab")
    public void clickOnSuburbanTrainsTab() {
        String expectedTitle = passengerMainPageTitle;
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        passengerMainPage.clickOnSuburbanTrainsTab();
    }

    @Test(description = "Filling all fields with correct data", dependsOnMethods = "clickOnSuburbanTrainsTab")
    public void inputCorrectData() {
        String expectedTitle = suburbanTrainMainPageTitle;
        String actualTitle = driver.getTitle();
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
