import com.rzd.selenium.factory.BrowserFactory;
import com.rzd.selenium.pageobjects.ActualMovementPage;
import com.rzd.selenium.pageobjects.MainPage;
import com.rzd.selenium.pageobjects.PassengerMainPage;
import com.rzd.selenium.util.ConfigurationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ActualMovementTest {

    private SoftAssert softAssert;

    @BeforeClass
    public void init() {
        BrowserFactory.getInstance().getDriver().get(ConfigurationManager.getProperty("driver.start"));
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
