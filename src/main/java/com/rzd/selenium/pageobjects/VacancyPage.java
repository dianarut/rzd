package com.rzd.selenium.pageobjects;

import com.rzd.selenium.util.ConfigurationManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class VacancyPage extends AbstractPage{

    @FindBy(xpath = ".//input[@value='Найти']")
    private WebElement searchButton;

    @FindBy(xpath = ".//table[@class='tdPad5 vac-result-tbl']")
    private WebElement resultTable;

    @FindBy(xpath = ".//input[@name='name']")
    private WebElement vacancy;

    @FindBy(xpath = ".//input[@name='org_unit_name']")
    private WebElement department;


    @FindBy(xpath = ".//select[@name='region_id']")
    private WebElement region;

    @FindBy(xpath = ".//input[@name='salary']")
    private WebElement salary;

    @FindBy(xpath = ".//input[@class='padR10']")
    private WebElement formButton;

    public boolean pressButton(){
        searchButton.click();

        return resultTable.isDisplayed();
    }

    public boolean fillForm(){
        vacancy.sendKeys(ConfigurationManager.getProperty("vacancy.position"));
        department.sendKeys("");
        Select select = new Select(region);
        select.selectByVisibleText(ConfigurationManager.getProperty("vacancy.region"));
        salary.sendKeys(ConfigurationManager.getProperty("vacancy.salary"));
        formButton.click();

        return resultTable.isDisplayed();
    }
}
