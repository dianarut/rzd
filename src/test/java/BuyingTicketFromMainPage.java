import org.testng.Assert;
import org.testng.annotations.Test;
import ru.rzd.pageobjects.*;
import ru.rzd.util.AssertManager;
import ru.rzd.util.ConfigurationManager;

public class BuyingTicketFromMainPage{

    private static final String FROM = ConfigurationManager.getProperty("movement.base.from");
    private static final String TO = ConfigurationManager.getProperty("movement.base.to");
    private static final int PLUS_DAYS_TO_CURRENT_DATE = Integer.parseInt(ConfigurationManager.getProperty("movement.plusDaysToCurrentDate"));

    @Test
    public void fillForPassengersForm() {
        MainPage mainPage = new MainPage();
        mainPage.fillForPassengersForm(FROM, TO, PLUS_DAYS_TO_CURRENT_DATE);
        Assert.assertTrue(mainPage.checkStations(FROM, TO, mainPage.getNameFromStation(),mainPage.getNameToStation()));
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
