package ru.rzd.pageobjects;

import org.openqa.selenium.interactions.Actions;
import ru.rzd.factory.BrowserFactory;
import ru.rzd.util.ConfigurationManager;
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

    @FindBy(xpath = "//input[@name = 'lastName']")
    private WebElement fieldSurname;

    @FindBy(xpath = "//input[@name = 'firstName']")
    private WebElement fieldName;

    @FindBy(xpath = "//input[@name = 'midName']")
    private WebElement fieldMidname;

    @FindBy(xpath = "//select[@name='gender']")
    private WebElement fieldGender;

    @FindBy(name = "birthdate")
    private WebElement fieldBirthday;

    @FindBy(xpath = "//select[@name='docType']")
    private WebElement listOfdocTypes;

    @FindBy(xpath = "//input[@name='docNumber']")
    private WebElement fieldDocNumber;

    @FindBy(xpath = "//select[@name='country']")
    private WebElement listOfCountries;

    @FindBy(xpath = "//input[@name='bInsurance']")
    private WebElement checkBoxInsurance;

    @FindBy(xpath = "//*[contains(@class, 's-cell s-type-up')]")
    private List<WebElement> listOfSeats;

    @FindBy(xpath = "//button[@type='submit' and text()='Зарезервировать места']")
    private WebElement buttonReserve;

    @FindBy(xpath = ".//*[@class='s-cell s-type-up' or @class='s-cell s-type-lo']")
    private WebElement buttonSeatsIn;

    @FindBy(xpath = ".//*[@class='s-cell s-type-up' or @class='s-cell s-type-lo'][preceding:: *[@class='col-xs-24 t-dblvert-pad j-scheme-box']]")
    private WebElement buttonSeatsOut;

    @FindBy(xpath = ".//*[@class='rn-array'][count(.//*[child:: *[@id='Layer_1']])=2]")
    private WebElement formSeats;

    public WebElement getSeatsForm() {
        return formSeats;
    }

    public PersonalDataPage fillThePassengerDataForm() {
        new Actions(BrowserFactory.getInstance().getDriver()).sendKeys(fieldSurname, LAST_NAME).build().perform();
//        fieldSurname.clear();
//        fieldSurname.sendKeys(LAST_NAME);
        fieldName.clear();
        fieldName.sendKeys(FIRST_NAME);
        fieldMidname.clear();
        fieldMidname.sendKeys(FATHER_NAME);
        Select selectGender = new Select(fieldGender);
        selectGender.selectByVisibleText(SEX);
        fieldBirthday.clear();
        fieldBirthday.sendKeys(B_DAY);
        Select selectDoc = new Select(listOfdocTypes);
        selectDoc.selectByValue("4");
        fieldDocNumber.clear();
        fieldDocNumber.sendKeys(PASS_NUMBER);
        Select selectCountry = new Select(listOfCountries);
        selectCountry.selectByValue("19");
        if (!CHECK && checkBoxInsurance.isSelected()) {
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

    public PersonalDataPage fillTheFormChooseSeatsAndReserveTicket() {
        this.fillThePassengerDataForm();
        buttonSeatsIn.click();
        buttonSeatsOut.click();
        this.reserveTicket();
        return this;
    }
}