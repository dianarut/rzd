import org.openqa.selenium.WebDriver;
import ru.rzd.factory.BrowserFactory;
import ru.rzd.pageobjects.ChooseTrainAndPlacePage;
import ru.rzd.pageobjects.MainPage;
import ru.rzd.pageobjects.PassengerMainPage;
import ru.rzd.pageobjects.PersonalDataPage;
import ru.rzd.util.ConfigurationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ru.rzd.util.AssertManager.isElementDisplayed;

public class BuyingTicketSeeScheduleTest{
    private static final String FROM = ConfigurationManager.getProperty("movement.base.from");
    private static final String TO = ConfigurationManager.getProperty("movement.base.to");
    private static final int PLUS_DAYS_TO_CURRENT_DATE= Integer.parseInt(ConfigurationManager.getProperty("movement.plusDaysToCurrentDate"));

    @BeforeClass
    public void init2() {
        WebDriver driver = BrowserFactory.getInstance().getDriver();
        driver.get(ConfigurationManager.getProperty("driver.start"));
    }

    @Test
    public void chooseTrainCarrigeInAndOut() {
        MainPage mainPage = new MainPage();
        mainPage.clickPassengersButton();
        PassengerMainPage passengerMainPage = new PassengerMainPage();
        passengerMainPage.fillForm(FROM, TO, PLUS_DAYS_TO_CURRENT_DATE);
        ChooseTrainAndPlacePage chooseTrainAndPlacePage = new ChooseTrainAndPlacePage();
        Assert.assertTrue(chooseTrainAndPlacePage.checkStations(FROM, TO, chooseTrainAndPlacePage.getNameFirstStationIn(),chooseTrainAndPlacePage.getNameSecondStationIn()),"The places of departure and destination are wrong!");
        chooseTrainAndPlacePage.selectTrainAndCarrigeIn();
        Assert.assertTrue(chooseTrainAndPlacePage.checkStations(TO, FROM, chooseTrainAndPlacePage.getNameFirstStationOut(), chooseTrainAndPlacePage.getNameSecondStationOut()),"The places of departure and destination on the way back are wrong!");
        chooseTrainAndPlacePage.selectTrainAndCarrigeOut();
    }

    @Test(dependsOnMethods = "chooseTrainCarrigeInAndOut")
    public void chooseSeatsInAndOutAndReserveTickets(){
        PersonalDataPage personalDataPage = new PersonalDataPage();
        //This test can fail because sometimes seats are displayed incorrect
        Assert.assertTrue(isElementDisplayed(personalDataPage.getSeatsForm()), "There are no seats!");
        personalDataPage.fillTheFormChooseSeatsAndReserveTicket();
        BuyingTicketFromMainPage buyingTicketFromMainPage = new BuyingTicketFromMainPage();
        buyingTicketFromMainPage.agreementPage();
    }
}
