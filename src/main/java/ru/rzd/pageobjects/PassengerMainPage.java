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
    private WebElement tabBasicSchedule;

    @FindBy(xpath = ".//p[text()='Фактическое движение поездов']")
    private WebElement actualMovementTab;

    @FindBy(id = "name0")
    private WebElement fieldFrom;

    @FindBy(id = "name1")
    private WebElement fieldTo;

    @FindBy(id = "DirToggle")
    private WebElement checkboxBack;

    @FindBy(id = "Submit")
    private WebElement buttonSchedule;

    @FindBy (xpath =".//*[@class='box-form__datetime__arrow-right j-date-arrow j-right'][following-sibling :: *[@id='date0']]")
    private WebElement buttonPlusToDateIn;

    @FindBy (xpath =".//*[@class='box-form__datetime__arrow-right j-date-arrow j-right'][following-sibling :: *[@id='date1']]")
    private WebElement buttonPlusToDateOut;

    @FindBy(how = How.XPATH, using = "//h1")
    private List<WebElement> pageh1Text;

    public SuburbanTrainMainPage clickOnSuburbanTrainsTab() {
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(suburbanTrainsTab));
        suburbanTrainsTab.click();
        return new SuburbanTrainMainPage();
    }

    private PassengerMainPage clickBackCheckBox() {
        checkboxBack.click();
        return this;
    }

    private PassengerMainPage clickScheduleButton() {
        buttonSchedule.click();
        return this;
    }

    private PassengerMainPage setFromField(String from) {
        fieldFrom.click();
        fieldFrom.clear();
        fieldFrom.sendKeys(from);
        return this;
    }

    private PassengerMainPage setToField(String to) {
        fieldTo.click();
        fieldTo.clear();
        fieldTo.sendKeys(to);
        return this;
    }

    public PassengerMainPage clickBasicScheduleTab() {
        tabBasicSchedule.click();
        return this;
    }

    private PassengerMainPage plusDaysToDates(int days) {
        int n = 0;
        while (days>n){
            buttonPlusToDateIn.click();
            buttonPlusToDateOut.click();
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