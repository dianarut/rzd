package com.rzd.selenium.pageobjects;

import com.rzd.selenium.util.TimeUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.List;

public class TenderSearchPage extends AbstractPage {

    private String today = TimeUtil.getCurrentDate();

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

    @FindBy(xpath="//tr/td[text()='товары']")
    private List<WebElement> goods;

    @FindBy(xpath = "//tr/td[text()='Москва']")
    private List<WebElement> cities;

    @FindBy(xpath = "//*[@id=\"container\"]//table[@class=\"table\"]/tbody/tr/td[2]")
    private List<WebElement> resultList;


    public TenderSearchPage fillTheSearch() {
        Select selectObjectType = new Select(objectType);
        selectObjectType.selectByVisibleText("товары");
        Select selectCity = new Select(place);
        selectCity.selectByVisibleText("Москва");
        fromDate.sendKeys(today);
        toDate.sendKeys(today);
        return this;
    }

    public TenderSearchPage search() {
        searchButton.click();
        return this;
    }

    public int goodsAmount(){
        return goods.size();
    }

    public int citiesAmount(){
        return cities.size();
    }


    public boolean containsCorrectDate(){
        boolean res = false;
        for (WebElement n: resultList) {
            if(n.getText().contains(today))
             res = true;
        }
        return res;
    }







}














