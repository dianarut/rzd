package com.rzd.selenium.pageobjects;

import com.rzd.selenium.factory.BrowserFactory;
import com.rzd.selenium.util.TimeUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SuburbanTrainMainPage extends AbstractPage {


    private int todaysDate;
    private int todaysMonth;
    private int todaysYear;
    private String date;


    @FindBy(xpath = "(//option[@value=\"2000002\"])[1]")
    private WebElement departureStationFromDropdown;

    @FindBy(xpath = "(//option[@value=\"2000015\"])[2]")
    private WebElement arrivalStationFromDropdown;


    @FindBy(xpath = "(//select[@class=\"jroute-field j-single box-form__input\"])[1]")
    private WebElement directionDropdown;

    @FindBy(xpath = "(//select[@class=\"jroute-field j-single box-form__input\"])[1]/option[@value=1]")
    private WebElement thereAndBackButton;

    @FindBy(xpath = "//input[@name=\"name\"]")
    private WebElement inputNameField;

    @FindBy(xpath = "//input[@name=\"name2\"]")
    private WebElement inputSecondaryNameField;

    @FindBy(xpath = "//select[@name=\"docType\"]")
    private WebElement docTypeDropdown;

    @FindBy(xpath = "//select[@name=\"docType\"]/option[@value=\"4\"]")
    private WebElement foreignPassport;

    @FindBy(xpath = "//input[@name=\"docNumber\"]")
    private WebElement inputDocNumberField;

    @FindBy(xpath = "//span[@id=\"MainSubmit\"]")
    private WebElement mainSubmitButton;

    //This method helps to pick date dynamically, depending on today's date.
    public void datePicker() {
        getTodaysDate();
        BrowserFactory.getInstance().getDriver().findElement(By.xpath(" (//a[@href=\"#" + date + "\"])[1]")).click();
    }


    public void fillAllFields(String surname, String initials, String passportNumber) {
        pickDepartureStation();
        pickArrivalStation();
        pickDate();
        pickDirection();
        inputSurnameField(surname);
        inputInitialsField(initials);
        pickDocumentType();
        inputDocumentNumber(passportNumber);
        clickSubmitButton();
    }

    public SuburbanTrainMainPage pickDepartureStation() {
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(departureStationFromDropdown));
        departureStationFromDropdown.click();
        return this;
    }

    public SuburbanTrainMainPage pickArrivalStation() {
        arrivalStationFromDropdown.click();
        return this;
    }


    public SuburbanTrainMainPage pickDate() {
        datePicker();
        return this;
    }

    public SuburbanTrainMainPage pickDirection() {
        directionDropdown.click();
        thereAndBackButton.click();
        return this;
    }

    public SuburbanTrainMainPage inputSurnameField(String name) {
        inputNameField.sendKeys(name);
        return this;
    }

    public SuburbanTrainMainPage inputInitialsField(String secondaryName) {
        inputSecondaryNameField.sendKeys(secondaryName);
        return this;
    }

    public SuburbanTrainMainPage pickDocumentType() {
        docTypeDropdown.click();
        foreignPassport.click();
        return this;
    }

    public SuburbanTrainMainPage inputDocumentNumber(String number) {
        inputDocNumberField.sendKeys(number);
        return this;
    }

    public SuburbanTrainMainPage clickSubmitButton() {
        mainSubmitButton.click();
        return this;
    }


    private String getTodaysDate() {
        todaysDate = (TimeUtil.getCalendar().get(TimeUtil.getCalendar().DAY_OF_MONTH) + 1);
        todaysMonth = (TimeUtil.getCalendar().get(TimeUtil.getCalendar().MONTH) + 1);
        todaysYear = (TimeUtil.getCalendar().get(TimeUtil.getCalendar().YEAR));
        date = todaysDate + "." + todaysMonth + "." + todaysYear;
        return date;
    }


}
