package com.rzd.selenium.pageobjects;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.rzd.selenium.util.TimeUtil.generateDate;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//a[@href=\"https://www.rzd.ru/main/secure/ru\"]")
    private WebElement loginButton;

    @FindBy(id = "name0")
    private WebElement fromField;

    @FindBy(id = "name1")
    private WebElement toField;

    @FindBy(xpath = ".//*[@id='date0'][ancestor ::*[@id='new_ticket_form']]")
    private WebElement dateField;

    @FindBy(xpath = ".//*[count(*[@class = 'calen-cont'])=1]")
    private WebElement dateField2;

    @FindBy(id = "buttonDate")
    private WebElement calendarIcon;

    @FindBy(xpath = " .//*[count(*[@class = 'dropList'][child :: *[@class = 'station']])=1]")
    private WebElement dropdownList;

    @FindBy(xpath = " .//*[count(*[@class = 'dropList'][child :: *[@class = 'station']])=2]")
    private WebElement dropdownLists;

    @FindBy(xpath = ".//*[@id='Submit'][not(contains(@class, 'disabled'))]")
    private WebElement searchButton;

    @FindBy(id = "marquee")
    private WebElement justForClick;

    @FindBy(xpath = "//a[@href=\"http://tender.rzd.ru/\"]")
    private WebElement tenderButton;

    @FindBy(css = "#headLinks > a.headLinks-link.headLinks-link-allSites.orng")
    private WebElement allSitesLink;

    @FindBy(xpath = "//a[@href='http://young.rzd.ru/']")
    private WebElement eduLink;

    @FindBy(xpath = "//a[@href='http://social.rzd.ru/']")
    private WebElement vacancyLink;

    @FindBy(xpath = "//a[@href=\"http://pass.rzd.ru/\"]")
    private WebElement passengersButton;

    @FindBy(xpath = "//*[contains(text(), 'Итоги')]")
    private WebElement workResults;

    @FindBy(xpath = "//img[@class=\"mlang_icon\"]")
    private WebElement englishFlagButton;

    @FindBy(xpath = ".//*[@class='greyBlock'][child:: *[@id='ticketbuyforma_horizontal']]")
    private WebElement passengersForm;

    public MainPageEng goToEngVersion() {
        englishFlagButton.click();
        return new MainPageEng();
    }

    public LoginPage goToLoginPage() {
        loginButton.click();
        return new LoginPage();
    }

    public TenderPage openTenderPage() {
        tenderButton.click();
        return new TenderPage();
    }

    public AllSitesPage openAllSitesPage() {
        allSitesLink.click();
        return new AllSitesPage();
    }

    public EducationPage attendEducationPage() {
        eduLink.click();
        return new EducationPage();
    }

    public VacancyPage attendVacancyPage() {
        vacancyLink.click();
        return new VacancyPage();
    }

    public MainPage fillFromField(String from) {
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(fromField));
        fromField.click();
        fromField.clear();
        fromField.sendKeys(from);
        return this;
    }

    public MainPage fillToField(String to) {
        super.webDriverWait().until(ExpectedConditions.visibilityOf(dropdownList));
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(toField));
        toField.clear();
        toField.sendKeys(to);
        return this;
    }

    public MainPage fillForPassengersForm(String to, String from, int plusDaysToCurrentDate){
        fillFromField(from);
        justClick();
        fillToField(to);
        justClick();
        setDateField(generateDate(plusDaysToCurrentDate));
        justClick();
        clickSearchButton();
        return this;
    }

    //This click is designed to hide drop-down list.
    public MainPage justClick() {
        justForClick.click();
        return this;
    }

    public MainPage clickSearchButton(){
        super.webDriverWait().until(ExpectedConditions.visibilityOf(dropdownLists));
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return this;
    }

    public MainPage clickPassengersButton() {
        passengersButton.click();
        return this;
    }

    public MainPage setDateField(String date) {
        super.webDriverWait().until(ExpectedConditions.visibilityOf(dropdownLists));
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(calendarIcon));
        super.webDriverWait().until(ExpectedConditions.visibilityOf(dateField2));
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(dateField));
        dateField.clear();
        dateField.sendKeys(date);
        return this;
    }

    public ActivityPage openActivityPage(){
        workResults.click();
        return new ActivityPage();
    }

    public boolean checkPassengersFrom(){
        try {
            super.webDriverWait().until(ExpectedConditions.elementToBeClickable(passengersForm));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
