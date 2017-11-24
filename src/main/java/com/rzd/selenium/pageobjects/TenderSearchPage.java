package com.rzd.selenium.pageobjects;

import com.rzd.selenium.util.TimeUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TenderSearchPage extends AbstractPage {

    private String today = TimeUtil.getCurrentDate(0);

    @FindBy(xpath = "//select[@name='property_type_id']")
    private WebElement listObjectType;

    @FindBy(xpath = "//select[@name='city_id']")
    private WebElement listOfPlace;

    @FindBy(xpath = "//select[@name='status_type']")
    private WebElement listOfStatus;

    @FindBy(xpath = "//input[@value='Найти']")
    private WebElement buttonSearch;

    @FindBy(id = "DateStart")
    private WebElement fieldStartDate;

    @FindBy(id = "DateEnd")
    private WebElement fieldEndDate;

    @FindBy(xpath = "//a[@class='ui-state-default']")
    private WebElement fieldCurrentDay;

    @FindBy(xpath="//tr/td[text()='товары']")
    private List<WebElement> listOfFieldsGoods;

    @FindBy(xpath = "//tr/td[text()='Москва']")
    private List<WebElement> listOfFieldsCities;

    @FindBy(xpath = "//*[@id='container']//table[@class='table']/tbody/tr/td[2]")
    private List<WebElement> listOfResult;


    public TenderSearchPage fillTheSearch() {
        Select selectObjectType = new Select(listObjectType);
        selectObjectType.selectByVisibleText("товары");
        Select selectCity = new Select(listOfPlace);
        selectCity.selectByVisibleText("Москва");
        fieldStartDate.sendKeys(today);
        fieldEndDate.sendKeys(today);
        return this;
    }

    public TenderSearchPage search() {
        buttonSearch.click();
        return this;
    }

    public int goodsAmount(){
        return listOfFieldsGoods.size();
    }

    public int citiesAmount(){
        return listOfFieldsCities.size();
    }


    public boolean containsCorrectDate(){
        boolean res = false;
        for (WebElement n: listOfResult) {
            if(n.getText().contains(today))
             res = true;
        }
        return res;
    }







}














