import ru.rzd.factory.BrowserFactory;
import ru.rzd.pageobjects.ActualMovementPage;
import ru.rzd.pageobjects.MainPage;
import ru.rzd.pageobjects.PassengerMainPage;
import ru.rzd.util.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ActualMovementTest {

    private SoftAssert softAssert;
    private static final String DRIVER_START = ConfigurationManager.getProperty("driver.start");

    @BeforeClass
    public void init() {
        WebDriver driver = BrowserFactory.getInstance().getDriver();
        driver.get(DRIVER_START);
        softAssert = new SoftAssert();
    }

    @Test
    public void movementBasicTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickPassengersButton();
        PassengerMainPage passengerMainPage = new PassengerMainPage();
        ActualMovementPage actualMovementPage = passengerMainPage.attendActualMovementPage();
        actualMovementPage.fillArrive();
        softAssert.assertFalse(actualMovementPage.pressButton());
    }

    @Test(dependsOnMethods = "movementBasicTest")
    public void biDirectionalTest() {
        ActualMovementPage actualMovementPage = new ActualMovementPage();
        actualMovementPage.fillDeparture();
        softAssert.assertFalse(actualMovementPage.pressButton());
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "biDirectionalTest")
    public void trainSpecificTest() {
        ActualMovementPage actualMovementPage = new ActualMovementPage();
        actualMovementPage.fillTrainNumber();
        softAssert.assertFalse(actualMovementPage.pressButton());
        softAssert.assertAll();
    }
}
