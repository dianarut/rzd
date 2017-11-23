import com.rzd.selenium.factory.BrowserFactory;
import com.rzd.selenium.pageobjects.*;
import com.rzd.selenium.util.ConfigurationManager;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BuyingTicketSeeScheduleTest{
    private String from = ConfigurationManager.getProperty("movement.base.to");
    private String to = ConfigurationManager.getProperty("movement.base.from");
    private String loginPageTitle = ConfigurationManager.getProperty("page.login.title");
    private String passengerMainTitle = ConfigurationManager.getProperty("page.passengerMain.title");
    private int plusDaysToCurrentDate = Integer.parseInt(ConfigurationManager.getProperty("movement.plusDaysToCurrentDate"));

//123
    @BeforeTest
    public void goToMainPage() {
        BrowserFactory.getInstance().getDriver().get(ConfigurationManager.getProperty("driver.start"));
    }

    @Test
    public void mainPage() {
        MainPage mainPage = new MainPage();
        String actualTitle = BrowserFactory.getInstance().getDriver().getTitle();
        String expectedTitle = loginPageTitle;
        Assert.assertEquals(actualTitle, expectedTitle, "The page is wrong!");
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
        personalDataPage.chooseSeatTo();
        personalDataPage.chooseSeatFrom();
        String expectedTitle = passengerMainTitle;
        String actualTitle = BrowserFactory.getInstance().getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        personalDataPage.reserveTicket();
    }

    @Test(dependsOnMethods = "personalDataPage")
    public void payAgreementPage() {
        PayAgreementPage payAgreementPage = new PayAgreementPage();
        Assert.assertTrue(payAgreementPage.isReservationMessage() > 0);
        payAgreementPage.agreeWithTerms();
        payAgreementPage.goToPayment();
        PaymentPage paymentPage = new PaymentPage();
        Assert.assertTrue(paymentPage.isPayPage() > 0);
    }

    @AfterSuite
    public void close() {
        BrowserFactory.getInstance().getDriver().quit();
    }

}
