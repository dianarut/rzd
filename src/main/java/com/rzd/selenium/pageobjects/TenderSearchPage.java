package com.rzd.selenium.pageobjects;

import com.rzd.selenium.util.TimeUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TenderSearchPage extends AbstractPage {

    @FindBy(xpath = "//select[@name=\"property_type_id\"]")
    private WebElement objectType;

    @FindBy(xpath = "//select[@name=\"city_id\"]")
    private WebElement place;

    @FindBy(xpath = "//select[@name=\"status_type\"]")
    private WebElement status;

    @FindBy(xpath = "//input[@value=\"Найти\"]")
    private WebElement searchButton;

    @FindBy(id = "DateStart")
    private WebElement fromDate;

    @FindBy(id = "DateEnd")
    private WebElement toDate;

    @FindBy(xpath = "//a[@class=\"ui-state-default\"]")
    private WebElement currentDay;

    public String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String date = dateFormat.format(TimeUtil.getCalendar().getTime());
        return date;
    }


    public TenderSearchPage fillTheSearch() {
        Select selectObjectType = new Select(objectType);
        selectObjectType.selectByVisibleText("товары");
        Select selectCity = new Select(place);
        selectCity.selectByVisibleText("Москва");
        fromDate.sendKeys(getCurrentDate());
        toDate.sendKeys(getCurrentDate());
        return this;
    }


    public TenderSearchPage search() {
        searchButton.click();
        return this;
    }


    @FindBy(xpath="//tr/td[text()='товары']")
    private List<WebElement> goods;

    public int goodsAmount(){
       return goods.size();
    }

    @FindBy(xpath = "//tr/td[text()='Москва']")
    private List<WebElement> cities;

    public int citiesAmount(){
        return cities.size();
    }

    @FindBy(xpath = "//*[@id=\"container\"]//table[@class=\"table\"]/tbody/tr/td[2]")
    private List<WebElement> resultList;

    boolean res;

    public boolean containsCorrectDate(){
        for (WebElement n: resultList) {
            if(n.getText().contains(getCurrentDate()))
             res = true;
        }
        return res;
    }







}














