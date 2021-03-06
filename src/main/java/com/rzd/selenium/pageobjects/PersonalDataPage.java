package com.rzd.selenium.pageobjects;

import com.rzd.selenium.factory.BrowserFactory;
import com.rzd.selenium.util.ConfigurationManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class PersonalDataPage extends AbstractPage {

    private String lastname = ConfigurationManager.getProperty("passport.surname");
    private String firstname = ConfigurationManager.getProperty("passport.name");
    private String fathername = ConfigurationManager.getProperty("passport.fathername");
    private String sex = ConfigurationManager.getProperty("passport.gender");
    private String bDay = ConfigurationManager.getProperty("passport.birthday");
    private String passNumber = ConfigurationManager.getProperty("passport.number");


    @FindBy (xpath = "//input[@name = \"lastName\"]")
    private WebElement surname;


    @FindBy(xpath = "//input[@name = \"firstName\"]")
    private WebElement name;


    @FindBy(xpath  ="//input[@name = \"midName\"]")
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


    public PersonalDataPage inputSurname(String lastname){
        surname.sendKeys(lastname);
        return this;
    }
    public PersonalDataPage inputName(String firstName){
        name.sendKeys(firstName);
        return this;
    }

    public  PersonalDataPage inputMidName(String fathername){
        midname.sendKeys(fathername);
        return this;
    }

    public PersonalDataPage chooseGender(String sex) {
        Select selectGender = new Select(gender);
        selectGender.selectByVisibleText(sex);
        return this;
    }

    public PersonalDataPage inputBirthday(String day){
        birthday.clear();
        birthday.sendKeys(day);
        return this;
    }

    public PersonalDataPage chooseDocType(){
        Select selectDoc = new Select(docType);
        selectDoc.selectByValue("4");
        return this;
    }

    public PersonalDataPage inputDocNumber(String number){
        docNumber.sendKeys(number);
        return this;
    }

    public PersonalDataPage chooseCountry(){
        Select selectCountry = new Select(country);
        selectCountry.selectByValue("19");
        return this;
    }

    public PersonalDataPage uncheckInsurance(){
        insurance.click();
        return this;
    }

    public PersonalDataPage chooseSeat(){
       for(int i=0; i<=seats.size(); i++)
            if(seats.get(i).isEnabled()){
                seats.get(i).click();
                break;
            }

        return this;
    }

    public PayAgreementPage reserveTicket(){
        reserveButton.click();
        return new PayAgreementPage();
    }

    public PersonalDataPage fillTheForm(){
        PersonalDataPage personalDataPage = new PersonalDataPage();
        personalDataPage.inputSurname(lastname);
        personalDataPage.inputName(firstname);
        personalDataPage.inputMidName(fathername);
        personalDataPage.chooseGender(sex);
        personalDataPage.inputBirthday(bDay);
        personalDataPage.chooseDocType();
        personalDataPage.inputDocNumber(passNumber);
        personalDataPage.chooseCountry();
        personalDataPage.uncheckInsurance();        
        return this;
    }

    public PersonalDataPage chooseSeatTo(){
        seatsTo.click();
        return this;
    }

    public PersonalDataPage chooseSeatFrom(){
        seatsFrom.click();
        return this;
    }

}
