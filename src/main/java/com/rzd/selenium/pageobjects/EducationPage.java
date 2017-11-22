package com.rzd.selenium.pageobjects;

import com.rzd.selenium.util.ConfigurationManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class EducationPage extends AbstractPage{

    @FindBy(xpath = ".//button[1]//span[2]")
    private WebElement searchButton;

    @FindBy(xpath = ".//div[@class='college_itemContent']")
    private List<WebElement> list;

    @FindBy(xpath = ".//input[@class='textInput']")
    private WebElement name;

    @FindBy(xpath = ".//select[@name='trade_id']")
    private WebElement specialization;

    @FindBy(xpath = ".//select[@name='city_id']")
    private WebElement city;

    public int pressButton(){
        searchButton.click();

        return list.size();
    }

    public void fillForm(){
        name.sendKeys(ConfigurationManager.getProperty("education.name"));
        Select dropdownSpec = new Select(specialization);
        dropdownSpec.selectByVisibleText(ConfigurationManager.getProperty("education.specialization"));
        Select dropdownCity = new Select(city);
        dropdownCity.selectByVisibleText(ConfigurationManager.getProperty("education.city"));
    }
}
