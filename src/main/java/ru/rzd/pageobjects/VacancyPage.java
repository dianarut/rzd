package ru.rzd.pageobjects;

import ru.rzd.util.ConfigurationManager;
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

    private static final String VACANCY_POSITION = ConfigurationManager.getProperty("vacancy.position");
    private static final String VACANCY_REGION = ConfigurationManager.getProperty("vacancy.region");
    private static final String VACANCY_SALARY = ConfigurationManager.getProperty("vacancy.salary");

    public boolean pressButton(){
        searchButton.click();
        return resultTable.isDisplayed();
    }

    public boolean fillForm(){
        vacancy.sendKeys(VACANCY_POSITION);
        department.sendKeys("");
        Select select = new Select(region);
        select.selectByVisibleText(VACANCY_REGION);
        salary.sendKeys(VACANCY_SALARY);
        formButton.click();
        return resultTable.isDisplayed();
    }
}
