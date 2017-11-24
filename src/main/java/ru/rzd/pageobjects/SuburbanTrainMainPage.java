package ru.rzd.pageobjects;

import ru.rzd.factory.BrowserFactory;
import ru.rzd.util.TimeUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Calendar;

public class SuburbanTrainMainPage extends AbstractPage {

    private WebDriver driver = BrowserFactory.getInstance().getDriver();
    private int day = TimeUtil.getCalendar().get(Calendar.DATE) + 1;
    private int month = TimeUtil.getCalendar().get(Calendar.MONTH) + 1;
    private int year = TimeUtil.getCalendar().get(Calendar.YEAR);
    private String date = day + "." + month + "." + year;

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
    private void datePicker() {
        driver.findElement(By.xpath(" (//a[@href=\"#" + date + "\"])[1]")).click();
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

}
