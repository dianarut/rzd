package ru.rzd.pageobjects;

import ru.rzd.util.TimeUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    public List<WebElement> getGoods() {
        return goods;
    }

    public List<WebElement> getCities() {
        return cities;
    }

    public List<WebElement> getResultList() {
        return resultList;
    }

    public TenderSearchPage fillTheSearchForm() {
        Select selectObjectType = new Select(objectType);
        selectObjectType.selectByVisibleText("товары");
        Select selectCity = new Select(place);
        selectCity.selectByVisibleText("Москва");
        highlightElement(fromDate);
        fromDate.sendKeys(today);
        highlightElement(toDate);
        toDate.sendKeys(today);
        return this;
    }

    public TenderSearchPage search() {
        searchButton.click();
        return this;
    }
}














