import ru.rzd.factory.BrowserFactory;
import ru.rzd.pageobjects.*;
import ru.rzd.util.AssertManager;
import ru.rzd.util.ConfigurationManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyingTicketFromMainPage{

    private String from = ConfigurationManager.getProperty("movement.base.from");
    private String to = ConfigurationManager.getProperty("movement.base.to");
    private int plusDaysToCurrentDate = Integer.parseInt(ConfigurationManager.getProperty("movement.plusDaysToCurrentDate"));
    private String loginPageTitle = ConfigurationManager.getProperty("page.login.title");


    @Test
    public void fillForPassengersForm() {
        MainPage mainPage = new MainPage();
        mainPage.fillForPassengersForm(to, from, plusDaysToCurrentDate);
        Assert.assertEquals(mainPage.checkFromStations(), from);
        Assert.assertEquals(mainPage.checkToStations(), to);
        mainPage.clickSearchButton();
    }

    @Test(dependsOnMethods = "fillForPassengersForm")
    public void choosePlace() {
        ChooseTrainAndPlacePage chooseTrainAndPlacePage = new ChooseTrainAndPlacePage();
        chooseTrainAndPlacePage.fillQueryForm();
        Assert.assertTrue(chooseTrainAndPlacePage.fillPlaceForm());
    }

    @Test(dependsOnMethods = "choosePlace")
    public void passengerDataInput() {
        PersonalDataPage personalDataPage = new PersonalDataPage();
        personalDataPage.fillThePassengerDataForm();
        personalDataPage.chooseSeat();
        PayAgreementPage payAgreementPage = personalDataPage.reserveTicket();
        Assert.assertTrue(AssertManager.isElementPresent(payAgreementPage.getReservationMessage()));
    }

    @Test(dependsOnMethods = {"passengerDataInput"})
    public void agreementPage() {
        PayAgreementPage payAgreementPage = new PayAgreementPage();
        payAgreementPage.checkAgreeWithTermsBox();
        payAgreementPage.goToPaymentPage();
        PaymentPage paymentPage = new PaymentPage();
        Assert.assertTrue(AssertManager.isElementPresent(paymentPage.getPayPageAtribute()));
    }
}
