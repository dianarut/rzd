package ru.rzd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ChooseTrainAndPlacePage  extends AbstractPage {

    @FindBy (xpath =".//*[@class='col-xs-10'][ancestor :: *[@class='route-item__purpose__direct'][descendant :: *[@class='route-tr-addinfo'][count(*[@class = 'route-tr-elreg-msg'])=0]]]")
    private WebElement anyTrainTo;

    @FindBy (xpath =".//*[@class='col-xs-10'][ancestor :: *[@class='route-item__purpose__direct'][descendant :: *[@class='route-tr-addinfo'][count(*[@class = 'route-tr-elreg-msg'])=0]]][ancestor :: *[@id='Page1']]")
    private WebElement anyTrainBack;

    @FindBy (xpath =".//*[@type = 'radio']")
    private WebElement anyСarriageTo;

    @FindBy (xpath =".//*[@type = 'radio'][ancestor :: *[@id='Page1']]")
    private WebElement anyСarriageBack;

    @FindBy (xpath =".//*[@class='col-xs-10'][ancestor :: *[@class ='route-carType-item']][ancestor :: *[@id='Page1']]")
    private WebElement anyBackTrain;

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

    @FindBy (xpath =".//*[text()='Выбрать поезд обратно']")
    private WebElement chooseBackTrain;

    @FindBy (xpath =".//*[text()='Перейти к вводу данных пассажира и выбору мест']")
    private WebElement goToPassengersDateInputButton;

    @FindBy (xpath =".//*[@class='col-xs-12'][1][ancestor :: *[@class='route-item__purpose__direct'][descendant :: *[@class='route-tr-addinfo'][count(*[@class = 'route-tr-elreg-msg'])=0]]]/*")
    private  WebElement textFromStation;

    public  WebElement getTextFromStation()
    {
        return textFromStation;
    }

    public ChooseTrainAndPlacePage selectAnyTrainTo() {
        anyTrainTo.click();
        return this;
    }

    public ChooseTrainAndPlacePage selectAnyCarrigeTo() {
        anyСarriageTo.click();
        return this;
    }

    public ChooseTrainAndPlacePage selectAnyCarrigeBack() {
        anyСarriageBack.click();
        return this;
    }

    public ChooseTrainAndPlacePage clickChooseBackTrain() {
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(chooseBackTrain));
        chooseBackTrain.click();
        return this;
    }

    public ChooseTrainAndPlacePage selectAnyBackTrain() {
        anyTrainBack.click();
        return this;
    }

    public ChooseTrainAndPlacePage goToPassengersDateInputButton() {
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(goToPassengersDateInputButton));
        goToPassengersDateInputButton.click();
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

    public ChooseTrainAndPlacePage selectTrainsAndCarriges(){
        selectAnyTrainTo();
        selectAnyCarrigeTo();
        clickChooseBackTrain();
        selectAnyBackTrain();
        selectAnyCarrigeBack();
        return this;
    }

}
