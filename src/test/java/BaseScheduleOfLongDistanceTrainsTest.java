import org.openqa.selenium.WebDriver;
import ru.rzd.factory.BrowserFactory;
import ru.rzd.pageobjects.BasicScheduleLDTrainsResultsPage;
import ru.rzd.pageobjects.BasicSchedulePage;
import ru.rzd.pageobjects.MainPage;
import ru.rzd.pageobjects.PassengerMainPage;
import ru.rzd.util.ConfigurationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ru.rzd.util.AssertManager.*;

public class BaseScheduleOfLongDistanceTrainsTest{
    private static final String FROM = ConfigurationManager.getProperty("movement.base.from");
    private static final String TO = ConfigurationManager.getProperty("movement.base.to");

    @BeforeClass
    public void init2() {
        WebDriver driver = BrowserFactory.getInstance().getDriver();
        driver.get(ConfigurationManager.getProperty("driver.start"));
    }

    @Test
    public void getBaseScheduleOfLongDistanceTrains() {
        MainPage mainPage = new MainPage();
        mainPage.clickPassengersButton();
        PassengerMainPage passengerMainPage = new PassengerMainPage();
        passengerMainPage.clickBasicScheduleTab();
        BasicSchedulePage basicSchedulePage = new BasicSchedulePage();
        basicSchedulePage.fillForm(FROM, TO);
        BasicScheduleLDTrainsResultsPage basicScheduleLDTrainsResultsPage = new BasicScheduleLDTrainsResultsPage();
        Assert.assertTrue(isValueOfVisibleElementContainsText(FROM,basicScheduleLDTrainsResultsPage.getFromField())
                & isValueOfVisibleElementContainsText(TO,basicScheduleLDTrainsResultsPage.getToField()),"The places of departure and destination are wrong!");
        Assert.assertTrue(isElementDisplayed(basicScheduleLDTrainsResultsPage.getSomeDate()),"There are no available trip's date");
        basicScheduleLDTrainsResultsPage.clickSomeDate();
        Assert.assertTrue(isElementDisplayed(basicScheduleLDTrainsResultsPage.getInformationMessage()),"The information message about route is not found!");
    }
}
