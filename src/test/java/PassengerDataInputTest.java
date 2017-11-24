import ru.rzd.pageobjects.PayAgreementPage;
import ru.rzd.pageobjects.PaymentPage;
import ru.rzd.pageobjects.PersonalDataPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PassengerDataInputTest {

   @Test
   public void passengerDataInput(){
       PersonalDataPage personalDataPage = new PersonalDataPage();
       personalDataPage.inputSurname("аывмолгфвм");
       personalDataPage.inputName("фвполдрфвг");
       personalDataPage.inputMidName("ываолфав");
       personalDataPage.chooseGender("Женский");
       personalDataPage.inputBirthday("02071993");
       personalDataPage.chooseDocType();
       personalDataPage.inputDocNumber("123546789");
       personalDataPage.chooseCountry();
      // personalDataPage.uncheckInsurance();
       personalDataPage.chooseSeat();

   }

   @Test(dependsOnMethods = {"passengerDataInput"})
   public void agreementPage(){
       PersonalDataPage personalDataPage = new PersonalDataPage();
       PayAgreementPage payAgreementPage = personalDataPage.reserveTicket();
       Assert.assertTrue(payAgreementPage.isReservationMessage()>0);
       payAgreementPage.agreeWithTerms();
       payAgreementPage.goToPayment();
       PaymentPage paymentPage = new PaymentPage();
       Assert.assertTrue(paymentPage.isPayPage()>0);
   }
}
