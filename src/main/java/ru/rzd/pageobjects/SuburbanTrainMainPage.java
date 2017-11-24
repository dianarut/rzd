package ru.rzd.pageobjects;

import org.openqa.selenium.support.How;
import ru.rzd.factory.BrowserFactory;
import ru.rzd.util.TimeUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SuburbanTrainMainPage extends AbstractPage {

    private WebDriver driver = BrowserFactory.getInstance().getDriver();
    private String date = TimeUtil.getCurrentDatePlusAmountOfDays(1);

    @FindBy(xpath = "(//option[@value='2000002'])[1]")
    private WebElement departureStationFromDropdown;

    @FindBy(xpath = "(//option[@value='2000015'])[2]")
    private WebElement arrivalStationFromDropdown;

    @FindBy(xpath = "(//select[@class='jroute-field j-single box-form__input'])[1]")
    private WebElement directionDropdown;

    @FindBy(xpath = "(//select[@class='jroute-field j-single box-form__input'])[1]/option[@value=1]")
    private WebElement thereAndBackButton;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputNameField;

    @FindBy(xpath = "//input[@name='name2']")
    private WebElement inputSecondaryNameField;

    @FindBy(xpath = "//select[@name='docType']")
    private WebElement docTypeDropdown;

    @FindBy(xpath = "//select[@name='docType']/option[@value='4']")
    private WebElement foreignPassport;

    @FindBy(xpath = "//input[@name='docNumber']")
    private WebElement inputDocNumberField;

    @FindBy(xpath = "//span[@id='MainSubmit']")
    private WebElement mainSubmitButton;

    @FindBy(how = How.XPATH, using = "//h1")
    private List<WebElement> pageh1Text;

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

    //This method helps to pick date dynamically, depending on today's date.
    private void datePicker() {
        driver.findElement(By.xpath("//a[@href='#" + date + "']")).click();
    }

    private SuburbanTrainMainPage pickDepartureStation() {
        waitForElementEnabled(departureStationFromDropdown, 3);
        departureStationFromDropdown.click();
        return this;
    }

    private SuburbanTrainMainPage pickArrivalStation() {
        arrivalStationFromDropdown.click();
        return this;
    }


    private SuburbanTrainMainPage pickDate() {
        datePicker();
        return this;
    }

    private SuburbanTrainMainPage pickDirection() {
        directionDropdown.click();
        thereAndBackButton.click();
        return this;
    }

    private SuburbanTrainMainPage inputSurnameField(String name) {
        inputNameField.sendKeys(name);
        return this;
    }

    private SuburbanTrainMainPage inputInitialsField(String secondaryName) {
        inputSecondaryNameField.sendKeys(secondaryName);
        return this;
    }

    private SuburbanTrainMainPage pickDocumentType() {
        docTypeDropdown.click();
        foreignPassport.click();
        return this;
    }

    private SuburbanTrainMainPage inputDocumentNumber(String number) {
        inputDocNumberField.sendKeys(number);
        return this;
    }

    private SuburbanTrainMainPage clickSubmitButton() {
        mainSubmitButton.click();
        return this;
    }

    public List<WebElement> getPageh1Text() {
        waitForElementVisible(pageh1Text.get(0), 2);
        return pageh1Text;
    }
}
