package com.rzd.selenium.pageobjects;

import com.rzd.selenium.util.ConfigurationManager;
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

    @FindBy(xpath = "//input[@name = \"lastName\"]")
    private WebElement surname;

    @FindBy(xpath = "//input[@name = \"firstName\"]")
    private WebElement name;

    @FindBy(xpath = "//input[@name = \"midName\"]")
    private WebElement midname;

    @FindBy(xpath = "//select[@name=\"gender\"]")
    private WebElement gender;

    @FindBy(name = "birthdate")
    private WebElement birthday;

    @FindBy(xpath = "//select[@name=\"docType\"]")
    private WebElement docType;

    @FindBy(xpath = "//input[@name=\"docNumber\"]")
    private WebElement docNumber;

    @FindBy(xpath = "//select[@name=\"country\"]")
    private WebElement country;

    @FindBy(xpath = "//input[@name=\"bInsurance\"]")
    private WebElement insurance;

    @FindBy(xpath = "//*[contains(@class, 's-cell s-type-up')]")
    private List<WebElement> seats;

    @FindBy(xpath = "//button[@type=\"submit\" and text()='Зарезервировать места']")
    private WebElement reserveButton;

    @FindBy(xpath = ".//*[@class='s-cell s-type-up' or @class='s-cell s-type-lo']")
    private WebElement seatsTo;

    @FindBy(xpath = ".//*[@class='s-cell s-type-up' or @class='s-cell s-type-lo'][preceding:: *[@class='col-xs-24 t-dblvert-pad j-scheme-box']]")
    private WebElement seatsFrom;

    @FindBy(xpath = ".//*[@class='rn-array'][count(.//*[child:: *[@id='Layer_1']])=2]")
    private WebElement seatsForms;


    public PersonalDataPage inputSurname(String lastname){
        surname.clear();
        surname.sendKeys(lastname);
        return this;
    }
    public PersonalDataPage inputName(String firstName){
        name.clear();
        name.sendKeys(firstName);
        return this;
    }

    public  PersonalDataPage inputMidName(String fathername){
        midname.clear();
        midname.sendKeys(fathername);
        return this;
    }

    public PersonalDataPage chooseGender(String sex) {
        Select selectGender = new Select(gender);
        selectGender.selectByVisibleText(sex);
        return this;
    }

    public PersonalDataPage inputBirthday(String day) {
        birthday.clear();
        birthday.sendKeys(day);
        return this;
    }

    public PersonalDataPage chooseDocType() {
        Select selectDoc = new Select(docType);
        selectDoc.selectByValue("4");
        return this;
    }

    public PersonalDataPage inputDocNumber(String number){
        docNumber.clear();
        docNumber.sendKeys(number);
        return this;
    }

    public PersonalDataPage chooseCountry() {
        Select selectCountry = new Select(country);
        selectCountry.selectByValue("19");
        return this;
    }

    public PersonalDataPage uncheckInsurance(boolean check){
        if (!check && insurance.isSelected()) {
            insurance.click();
        }
        return this;
    }

    public PersonalDataPage chooseSeat() {
        for (int i = 0; i <= seats.size(); i++)
            if (seats.get(i).isEnabled()) {
                seats.get(i).click();
                break;
            }

        return this;
    }

    public PayAgreementPage reserveTicket() {
        reserveButton.click();
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