import ru.rzd.factory.BrowserFactory;
import ru.rzd.pageobjects.ChooseTrainAndPlacePage;
import ru.rzd.pageobjects.MainPage;
import ru.rzd.pageobjects.PassengerMainPage;
import ru.rzd.pageobjects.PersonalDataPage;
import ru.rzd.util.ConfigurationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BuyingTicketSeeScheduleTest{
    private String from = ConfigurationManager.getProperty("movement.base.to");
    private String to = ConfigurationManager.getProperty("movement.base.from");
    private String loginPageTitle = ConfigurationManager.getProperty("page.login.title");
    private String passengerMainTitle = ConfigurationManager.getProperty("page.passengerMain.title");
    private int plusDaysToCurrentDate = Integer.parseInt(ConfigurationManager.getProperty("movement.plusDaysToCurrentDate"));

    @BeforeClass
    public void init2() {
        BrowserFactory.getInstance().getDriver().get(ConfigurationManager.getProperty("driver.start"));
    }

    @Test
    public void mainPage() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.checkPassengersFrom(), "There are no passengers form!");
        mainPage.clickPassengersButton();
    }

    @Test(dependsOnMethods = "mainPage")
    public void passengerMainPage() {
        PassengerMainPage passengerMainPage = new PassengerMainPage();
        String actualTitle = BrowserFactory.getInstance().getDriver().getTitle();
        String expectedTitle = passengerMainTitle;
        Assert.assertEquals(actualTitle, expectedTitle);
        passengerMainPage.fillForm(from, to, plusDaysToCurrentDate);
    }

    @Test(dependsOnMethods = "passengerMainPage")
    public void chooseTrainAndPlacePage() {
        ChooseTrainAndPlacePage chooseTrainAndPlacePage = new ChooseTrainAndPlacePage();
        chooseTrainAndPlacePage.selectTrainsAndCarriges();
        String actualTitle = BrowserFactory.getInstance().getDriver().getTitle();
        String expectedTitle = passengerMainTitle;
        Assert.assertEquals(actualTitle, expectedTitle);
        chooseTrainAndPlacePage.goToPassengersDateInputButton();
    }

    @Test(dependsOnMethods = "chooseTrainAndPlacePage")
    public void personalDataPage(){
        PersonalDataPage personalDataPage = new PersonalDataPage();
        personalDataPage.fillTheForm();
        Assert.assertTrue(personalDataPage.checkSeatsLayout(), "There are no seats!");
        personalDataPage.chooseSeatTo();
        personalDataPage.chooseSeatFrom();
        String expectedTitle = passengerMainTitle;
        String actualTitle = BrowserFactory.getInstance().getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        personalDataPage.reserveTicket();
    }

    @Test(dependsOnMethods = "personalDataPage")
    public void payAgreementPage() {
        BuyingTicketFromMainPage buyingTicketFromMainPage = new BuyingTicketFromMainPage();
        buyingTicketFromMainPage.agreementPage();
    }
}
