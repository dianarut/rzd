import ru.rzd.factory.BrowserFactory;
import ru.rzd.pageobjects.*;
import ru.rzd.util.ConfigurationManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyingTicketFromMainPage{

    private String from = ConfigurationManager.getProperty("movement.base.to");
    private String to = ConfigurationManager.getProperty("movement.base.from");
    private int plusDaysToCurrentDate = Integer.parseInt(ConfigurationManager.getProperty("movement.plusDaysToCurrentDate"));
    private String loginPageTitle = ConfigurationManager.getProperty("page.login.title");


    @Test
    public void fillForPassengersForm() {
        MainPage mainPage = new MainPage();
        String actualTitle = BrowserFactory.getInstance().getDriver().getTitle();
        String expectedTitle = loginPageTitle;
        Assert.assertEquals(actualTitle, expectedTitle);
        mainPage.fillForPassengersForm(to, from, plusDaysToCurrentDate);
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
        personalDataPage.fillTheForm();
        personalDataPage.chooseSeat();
        PayAgreementPage payAgreementPage = personalDataPage.reserveTicket();
        Assert.assertTrue(payAgreementPage.isReservationMessage() > 0);
    }

    @Test(dependsOnMethods = {"passengerDataInput"})
    public void agreementPage() {
        PayAgreementPage payAgreementPage = new PayAgreementPage();
        payAgreementPage.agreeWithTerms();
        payAgreementPage.goToPayment();
        PaymentPage paymentPage = new PaymentPage();
        Assert.assertTrue(paymentPage.isPayPage() > 0);
    }
}
