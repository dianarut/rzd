import org.testng.Assert;
import ru.rzd.factory.BrowserFactory;
import ru.rzd.pageobjects.ActualMovementPage;
import ru.rzd.pageobjects.MainPage;
import ru.rzd.pageobjects.PassengerMainPage;
import ru.rzd.util.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActualMovementTest {

    private static final String DRIVER_START = ConfigurationManager.getProperty("driver.start");

    @BeforeClass
    public void init() {
        WebDriver driver = BrowserFactory.getInstance().getDriver();
        driver.get(DRIVER_START);
    }

    @Test
    public void fillArrivalInputOnlyTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickPassengersButton();
        PassengerMainPage passengerMainPage = new PassengerMainPage();
        ActualMovementPage actualMovementPage = passengerMainPage.attendActualMovementPage();
        Assert.assertFalse(actualMovementPage.fillArrive());
    }

    @Test
    public void fillArrivalDepartureInputOnlyTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickPassengersButton();
        PassengerMainPage passengerMainPage = new PassengerMainPage();
        ActualMovementPage actualMovementPage = passengerMainPage.attendActualMovementPage();
        actualMovementPage.fillArrive();
        Assert.assertFalse(actualMovementPage.fillDeparture());
    }

    @Test
    public void fillArrivalDepartureTrainNumberInputTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickPassengersButton();
        PassengerMainPage passengerMainPage = new PassengerMainPage();
        ActualMovementPage actualMovementPage = passengerMainPage.attendActualMovementPage();
        actualMovementPage.fillArrive();
        actualMovementPage.fillDeparture();
        Assert.assertFalse(actualMovementPage.fillTrainNumber());
    }
}
