package ru.rzd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ru.rzd.util.TimeUtil;

import static ru.rzd.util.AssertManager.isContentOfInvisibleElementContainsText;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//a[@href='https://www.rzd.ru/main/secure/ru']")
    private WebElement loginButton;

    @FindBy(id = "name0")
    private WebElement fieldFrom;

    @FindBy(id = "name1")
    private WebElement fieldTo;

    @FindBy(xpath = ".//*[@id='date0'][ancestor ::*[@id='new_ticket_form']]")
    private WebElement fieldDate;

    @FindBy(xpath = ".//*[@id='Submit'][not(contains(@class, 'disabled'))]")
    private WebElement ButtonSearch;

    @FindBy(id = "marquee")
    private WebElement areaForClick;

    @FindBy(xpath = "//a[@href='http://tender.rzd.ru/']")
    private WebElement tenderButton;

    @FindBy(css = "#headLinks > a.headLinks-link.headLinks-link-allSites.orng")
    private WebElement allSitesLink;

    @FindBy(xpath = "//a[@href='http://young.rzd.ru/']")
    private WebElement eduLink;

    @FindBy(xpath = "//a[@href='http://social.rzd.ru/']")
    private WebElement vacancyLink;

    @FindBy(xpath = "//a[@href='http://pass.rzd.ru/']")
    private WebElement passengersButton;

    @FindBy(xpath = "//*[contains(text(), 'Итоги')]")
    private WebElement workResults;

    @FindBy(xpath = "//img[@class='mlang_icon']")
    private WebElement englishFlagButton;

    @FindBy(xpath = ".//*[@class='dropList'][1]/*[@class='station'][1]")
    private WebElement nameFromStation;

    @FindBy(xpath = ".//*[@class='dropList'][2]/*[@class='station'][1]")
    private WebElement nameToStation;

    public WebElement getNameFromStation() {
        return nameFromStation;
    }

    public WebElement getNameToStation() {
        return nameToStation;
    }

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

    private MainPage fillFromField(String from) {
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(fieldFrom));
        fieldFrom.click();
        fieldFrom.clear();
        fieldFrom.sendKeys(from);
        return this;
    }

    private MainPage fillToField(String to) {
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(fieldTo));
        fieldTo.clear();
        fieldTo.sendKeys(to);
        return this;
    }

    public MainPage fillForPassengersForm(String to, String from, int plusDaysToCurrentDate){
        fillFromField(from);
        clickToHideDropDownList();
        fillToField(to);
        clickToHideDropDownList();
        setDateField(TimeUtil.getCurrentDatePlusAmountOfDays(plusDaysToCurrentDate));
        clickToHideDropDownList();
        return this;
    }

    private MainPage clickToHideDropDownList() {
        areaForClick.click();
        return this;
    }

    public MainPage clickSearchButton(){
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(ButtonSearch));
        ButtonSearch.click();
        return this;
    }

    public MainPage clickPassengersButton() {
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(buttonPassengers));
        buttonPassengers.click();
        return this;
    }

    private MainPage setDateField(String date) {
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(fieldDate));
        fieldDate.clear();
        fieldDate.sendKeys(date);
        return this;
    }

    public ActivityPage openActivityPage(){
        workResults.click();
        return new ActivityPage();
    }

    public boolean checkStations(String from, String to , WebElement firstStation, WebElement secondStation){
        return isContentOfInvisibleElementContainsText(to, firstStation)
            & isContentOfInvisibleElementContainsText(from, secondStation);
    }
}