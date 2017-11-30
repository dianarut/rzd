package ru.rzd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.rzd.factory.BrowserFactory;

import static ru.rzd.util.AssertManager.isContentOfVisibleElementContainsText;

public class ChooseTrainAndPlacePage  extends AbstractPage {

    @FindBy (xpath =".//*[@class='col-xs-10'][ancestor :: *[@class='route-item__purpose__direct'][descendant :: *[@class='route-tr-addinfo'][count(*[@class = 'route-tr-elreg-msg'])=0]]]")
    private WebElement buttonFristAvailableTrainIn;

    @FindBy (xpath =".//*[@class='col-xs-10'][ancestor :: *[@class='route-item__purpose__direct'][descendant :: *[@class='route-tr-addinfo'][count(*[@class = 'route-tr-elreg-msg'])=0]]][ancestor :: *[@id='Page1']]")
    private WebElement buttonFristAvailableTrainOut;

    @FindBy (css =".col-xs-4>input")
    private WebElement radiobuttonFirsСarriageIn;

    @FindBy (xpath =".//*[@type = 'radio'][ancestor :: *[@id='Page1']]")
    private WebElement radiobuttonFirsСarriageOut;

    @FindBy (xpath =".//button[@class='btn btn-main-red j-toggle-filter-sidebar']")
    private WebElement changeButton;

    @FindBy (xpath =".//input[@name='firm-no']")
    private WebElement firmCheckBox;

    @FindBy (xpath ="(.//span[@title='Вечер с 18 до 24'][1])[3]")
    private WebElement timeSpan;

    @FindBy (xpath ="(.//input[@value='Подобрать'])[1]")
    private WebElement applyButton;

    @FindBy (xpath ="(.//div[@class='route-carType-item'])[3]")
    private WebElement compartment;

    @FindBy (xpath ="(.//input[@type='radio'])[1]")
    private WebElement radioNumber;

    @FindBy (xpath =".//button[text()='Перейти к вводу данных пассажира и выбору мест']")
    private WebElement moveButton;

    @FindBy (xpath =".//h3[text()='Страхование на время поездки']")
    private WebElement checkContent;

    @FindBy (xpath =".//div[text()='Время для станций на территории РФ:']")
    private WebElement textContent;

    @FindBy (css =".j-car-ok.btn.btn-default")
    private WebElement buttonChooseBackTrain;

    @FindBy (xpath =".//*[@class='col-xs-12'][1][ancestor :: *[@class='route-item__purpose__direct'][descendant :: *[@class='route-tr-addinfo'][count(*[@class = 'route-tr-elreg-msg'])=0]]]/*")
    private  WebElement nameFirstStationIn;

    @FindBy (xpath =".//*[@class='col-xs-12'][2][ancestor :: *[@class='route-item__purpose__direct'][descendant :: *[@class='route-tr-addinfo'][count(*[@class = 'route-tr-elreg-msg'])=0]]]/*")
    private  WebElement nameSecondStationIn;

    @FindBy (xpath =".//*[@id='Page1']//*[@class='col-xs-12'][1][ancestor :: *[@class='route-item__purpose__direct'][descendant :: *[@class='route-tr-addinfo'][count(*[@class = 'route-tr-elreg-msg'])=0]]]/*")
    private  WebElement nameFirstStationOut;

    @FindBy (xpath =".//*[@id='Page1']//*[@class='col-xs-12'][2][ancestor :: *[@class='route-item__purpose__direct'][descendant :: *[@class='route-tr-addinfo'][count(*[@class = 'route-tr-elreg-msg'])=0]]]/*")
    private  WebElement nameSecondStationOut;

    @FindBy (xpath =".//*[@class='jqui_tooltip circle-text offset-left-md']")
    private  WebElement iconQuection;

    public WebElement getNameFirstStationIn() {
        return nameFirstStationIn;
    }

    public WebElement getNameSecondStationIn() {
        return nameSecondStationIn;
    }

    public WebElement getNameFirstStationOut() {
        return nameFirstStationOut;
    }

    public WebElement getNameSecondStationOut() {
        return nameSecondStationOut;
    }

    private ChooseTrainAndPlacePage selectAnyTrainTo() {
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(buttonFristAvailableTrainIn));
        buttonFristAvailableTrainIn.click();
        return this;
    }

    private ChooseTrainAndPlacePage selectAnyCarrigeTo() {
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(radiobuttonFirsСarriageIn));
        radiobuttonFirsСarriageIn.click();
        return this;
    }

    private ChooseTrainAndPlacePage selectAnyCarrigeBack() {
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(radiobuttonFirsСarriageOut));
        radiobuttonFirsСarriageOut.click();
        return this;
    }

    private ChooseTrainAndPlacePage clickChooseBackTrain() {
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(buttonChooseBackTrain));
        buttonChooseBackTrain.click();
        return this;
    }

    private ChooseTrainAndPlacePage selectAnyBackTrain() {
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(buttonFristAvailableTrainOut));
        buttonFristAvailableTrainOut.click();
        return this;
    }

    private ChooseTrainAndPlacePage goToPassengersDateInputButton() {
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(moveButton));
        moveButton.click();
        return this;
    }

    public void fillQueryForm(){
        changeButton.click();
        firmCheckBox.click();
        timeSpan.click();
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(applyButton));
        applyButton.click();
    }

    public boolean fillPlaceForm(){
        selectAnyTrainTo();
        radioNumber.click();
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(moveButton));
        moveButton.click();
        return checkContent.isDisplayed();
    }

    public ChooseTrainAndPlacePage selectTrainAndCarrigeIn(){
        selectAnyTrainTo();
        moveToIconQuestion();
        selectAnyCarrigeTo();
        clickChooseBackTrain();
        return this;
    }

    public ChooseTrainAndPlacePage selectTrainAndCarrigeOut(){
        selectAnyBackTrain();
        moveToIconQuestion();
        selectAnyCarrigeBack();
        this.goToPassengersDateInputButton();
        return this;
    }

    public boolean checkStations(String from, String to , WebElement firstStation, WebElement SecondStation){
        return isContentOfVisibleElementContainsText(from, firstStation)
                & isContentOfVisibleElementContainsText(to, SecondStation);
    }

    public ChooseTrainAndPlacePage moveToIconQuestion() {
        new Actions(BrowserFactory.getInstance().getDriver()).moveToElement(iconQuection).build().perform();
        return this;
    }
}
