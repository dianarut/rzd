package ru.rzd.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PassengerMainPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='Form_tabs']/td[2]/div")
    private WebElement suburbanTrainsTab;

    @FindBy(id = "tab3")
    private WebElement basicScheduleTab;

    @FindBy(xpath = ".//p[text()='Фактическое движение поездов']")
    private WebElement actualMovementTab;

    @FindBy(id = "name0")
    private WebElement fromField;

    @FindBy(id = "name1")
    private WebElement toField;

    @FindBy(id = "DirToggle")
    private WebElement backCheckBox;

    @FindBy(id = "Submit")
    private WebElement scheduleButton;

    @FindBy(xpath = ".//*[text()= 'МОСКВА БЕЛОРУССКАЯ']']")
    private WebElement moskowInDropDownList;

    @FindBy(xpath = ".//div[text()='МИНСК']")
    private WebElement minskInDropDownList;

    @FindBy(xpath = ".//*[@class='box-form__datetime__arrow-right j-date-arrow j-right'][following-sibling :: *[@id='date0']]")
    private WebElement plusToDate;

    @FindBy(xpath = ".//*[@class='box-form__datetime__arrow-right j-date-arrow j-right'][following-sibling :: *[@id='date1']]")
    private WebElement plusBackDate;

    @FindBy(how = How.XPATH, using = "//h1")
    private List<WebElement> pageh1Text;


    public SuburbanTrainMainPage clickOnSuburbanTrainsTab() {
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(suburbanTrainsTab));
        suburbanTrainsTab.click();
        return new SuburbanTrainMainPage();
    }

    public PassengerMainPage clickBackCheckBox() {
        backCheckBox.click();
        return this;
    }

    public PassengerMainPage clickScheduleButton() {
        scheduleButton.click();
        return this;
    }

    public PassengerMainPage setFromField(String from) {
        fromField.click();
        fromField.clear();
        fromField.sendKeys(from);
        return this;
    }

    public PassengerMainPage setToField(String to) {
        toField.click();
        toField.clear();
        toField.sendKeys(to);
        return this;
    }

    public PassengerMainPage clickBasicScheduleTab() {
        basicScheduleTab.click();
        return this;
    }

    public PassengerMainPage plusDaysToDates(int days) {
        int n = 0;
        while (days > n) {
            plusToDate.click();
            plusBackDate.click();
            n++;
        }
        return this;
    }

    public ActualMovementPage attendActualMovementPage() {
        actualMovementTab.click();
        return new ActualMovementPage();
    }

    public PassengerMainPage fillForm(String from, String to, int days) {
        setFromField(from);
        setToField(to);
        clickBackCheckBox();
        plusDaysToDates(days);
        clickScheduleButton();
        return this;
    }

    public List<WebElement> getPageh1Text() {
        waitForElementVisible(pageh1Text.get(0), 2);
        return pageh1Text;
    }
}
