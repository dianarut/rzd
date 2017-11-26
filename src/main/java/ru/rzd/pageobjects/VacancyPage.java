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
    private WebElement vacancyInput;

    @FindBy(xpath = ".//input[@name='org_unit_name']")
    private WebElement departmentInput;

    @FindBy(xpath = ".//select[@name='region_id']")
    private WebElement regionInput;

    @FindBy(xpath = ".//input[@name='salary']")
    private WebElement salaryInput;

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
        vacancyInput.sendKeys(VACANCY_POSITION);
        departmentInput.sendKeys("");
        Select select = new Select(regionInput);
        select.selectByVisibleText(VACANCY_REGION);
        salaryInput.sendKeys(VACANCY_SALARY);
        formButton.click();
        return resultTable.isDisplayed();
    }
}
