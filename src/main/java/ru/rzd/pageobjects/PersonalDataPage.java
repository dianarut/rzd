package ru.rzd.pageobjects;

import ru.rzd.util.ConfigurationManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class PersonalDataPage extends AbstractPage {

    private static final String LAST_NAME = ConfigurationManager.getProperty("passport.surname");
    private static final String FIRST_NAME = ConfigurationManager.getProperty("passport.name");
    private static final String FATHER_NAME = ConfigurationManager.getProperty("passport.fathername");
    private static final String SEX = ConfigurationManager.getProperty("passport.gender");
    private static final String B_DAY = ConfigurationManager.getProperty("passport.birthday");
    private static final String PASS_NUMBER = ConfigurationManager.getProperty("passport.number");
    private final boolean CHECK = false;

    @FindBy(xpath = "//input[@fieldName = 'lastName']")
    private WebElement fieldSurname;

    @FindBy(xpath = "//input[@fieldName = 'firstName']")
    private WebElement fieldName;

    @FindBy(xpath = "//input[@fieldName = 'midName']")
    private WebElement fieldMidname;

    @FindBy(xpath = "//select[@fieldName='gender']")
    private WebElement fieldGender;

    @FindBy(name = "birthdate")
    private WebElement fieldBirthday;

    @FindBy(xpath = "//select[@fieldName='docType']")
    private WebElement listOfdocTypes;

    @FindBy(xpath = "//input[@fieldName='docNumber']")
    private WebElement fieldDocNumber;

    @FindBy(xpath = "//select[@fieldName='country']")
    private WebElement listOfCountries;

    @FindBy(xpath = "//input[@fieldName='bInsurance']")
    private WebElement checkBoxInsurance;

    @FindBy(xpath = "//*[contains(@class, 's-cell s-type-up')]")
    private List<WebElement> listOfSeats;

    @FindBy(xpath = "//button[@type='submit' and text()='Зарезервировать места']")
    private WebElement buttonReserve;

    @FindBy(xpath = ".//*[@class='s-cell s-type-up' or @class='s-cell s-type-lo']")
    private WebElement seatsTo;

    @FindBy(xpath = ".//*[@class='s-cell s-type-up' or @class='s-cell s-type-lo'][preceding:: *[@class='col-xs-24 t-dblvert-pad j-scheme-box']]")
    private WebElement seatsFrom;

    @FindBy(xpath = ".//*[@class='rn-array'][count(.//*[child:: *[@id='Layer_1']])=2]")
    private WebElement seatsForms;


    public PersonalDataPage inputSurname(String lastname){
        fieldSurname.clear();
        fieldSurname.sendKeys(lastname);
        return this;
    }
    public PersonalDataPage inputName(String firstName){
        fieldName.clear();
        fieldName.sendKeys(firstName);
        return this;
    }

    public  PersonalDataPage inputMidName(String fathername){
        fieldMidname.clear();
        fieldMidname.sendKeys(fathername);
        return this;
    }

    public PersonalDataPage chooseGender(String sex) {
        Select selectGender = new Select(fieldGender);
        selectGender.selectByVisibleText(sex);
        return this;
    }

    public PersonalDataPage inputBirthday(String day) {
        fieldBirthday.clear();
        fieldBirthday.sendKeys(day);
        return this;
    }

    public PersonalDataPage chooseDocType() {
        Select selectDoc = new Select(listOfdocTypes);
        selectDoc.selectByValue("4");
        return this;
    }

    public PersonalDataPage inputDocNumber(String number){
        fieldDocNumber.clear();
        fieldDocNumber.sendKeys(number);
        return this;
    }

    public PersonalDataPage chooseCountry() {
        Select selectCountry = new Select(listOfCountries);
        selectCountry.selectByValue("19");
        return this;
    }

    public PersonalDataPage uncheckInsurance(boolean check){
        if (!check && checkBoxInsurance.isSelected()) {
            checkBoxInsurance.click();
        }
        return this;
    }

    public PersonalDataPage chooseSeat() {
        for (int i = 0; i <= listOfSeats.size(); i++)
            if (listOfSeats.get(i).isEnabled()) {
                listOfSeats.get(i).click();
                break;
            }

        return this;
    }

    public PayAgreementPage reserveTicket() {
        buttonReserve.click();
        return new PayAgreementPage();
    }

    public PersonalDataPage fillTheForm() {
        PersonalDataPage personalDataPage = new PersonalDataPage();
        personalDataPage.inputSurname(LAST_NAME);
        personalDataPage.inputName(FIRST_NAME);
        personalDataPage.inputMidName(FATHER_NAME);
        personalDataPage.chooseGender(SEX);
        personalDataPage.inputBirthday(B_DAY);
        personalDataPage.chooseDocType();
        personalDataPage.inputDocNumber(PASS_NUMBER);
        personalDataPage.chooseCountry();
        personalDataPage.uncheckInsurance(CHECK);
        return this;
    }

    public PersonalDataPage chooseSeatTo() {
        seatsTo.click();
        return this;
    }

    public PersonalDataPage chooseSeatFrom() {
        seatsFrom.click();
        return this;
    }
    public boolean checkSeatsLayout(){
        try {
            seatsForms.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}