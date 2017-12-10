package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import ru.rzd.pageobjects.ChooseTrainAndPlacePage;
import ru.rzd.pageobjects.PassengerMainPage;
import ru.rzd.pageobjects.PersonalDataPage;
import ru.rzd.util.ConfigurationManager;

import java.util.List;

import static ru.rzd.util.AssertManager.isElementDisplayed;

public class BuyingTicketSeeScheduleTest{
    private static final String FROM = ConfigurationManager.getProperty("movement.base.from");
    private static final String TO = ConfigurationManager.getProperty("movement.base.to");
    private static final int PLUS_DAYS_TO_CURRENT_DATE= Integer.parseInt(ConfigurationManager.getProperty("movement.plusDaysToCurrentDate"));

    @When("^he fill the form with dates?$")
    public void fillForm(DataTable dates) {
        List<List<String>> data = dates.raw();
        PassengerMainPage passengerMainPage = new PassengerMainPage();
        passengerMainPage.fillForm(data.get(0).get(0), data.get(0).get(1), Integer.parseInt(data.get(0).get(2)));
    }

    @And("^he choose train? and place? in and out$")
    public void chooseTrainCarrigeInAndOut(){
        ChooseTrainAndPlacePage chooseTrainAndPlacePage = new ChooseTrainAndPlacePage();
        chooseTrainAndPlacePage.selectTrainAndCarrigeIn();
        chooseTrainAndPlacePage.selectTrainAndCarrigeOut();
    }

    @And("^he input personal date$")
    public void inputPersonalDate() {
        PersonalDataPage personalDataPage = new PersonalDataPage();
        //This test can fail because sometimes seats are displayed incorrect
        Assert.assertTrue(isElementDisplayed(personalDataPage.getSeatsForm()), "There are no seats!");
        personalDataPage.fillTheFormChooseSeatsAndReserveTicket();
    }

    @Then("^he get agreement page?$")
    public void getAgreementPage() {
        BuyingTicketFromMainPage buyingTicketFromMainPage = new BuyingTicketFromMainPage();
        buyingTicketFromMainPage.agreementPage();
    }
}

