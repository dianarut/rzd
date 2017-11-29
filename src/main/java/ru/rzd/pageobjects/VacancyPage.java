package ru.rzd.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.rzd.factory.BrowserFactory;
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

    private WebDriver driver = BrowserFactory.getInstance().getDriver();
    private Actions fillFormAction = new Actions(driver);
    private static final String VACANCY_POSITION = ConfigurationManager.getProperty("vacancy.position");
    private static final String VACANCY_REGION = ConfigurationManager.getProperty("vacancy.region");
    private static final String VACANCY_SALARY = ConfigurationManager.getProperty("vacancy.salary");

    public boolean pressButton(){
        fillFormAction.moveToElement(searchButton).click().build().perform();
        return resultTable.isDisplayed();
    }

    public boolean fillForm(){
        fillFormAction.moveToElement(vacancyInput).click().sendKeys(VACANCY_POSITION)
                .moveToElement(departmentInput).click().sendKeys("").build().perform();
        Select select = new Select(regionInput);
        select.selectByVisibleText(VACANCY_REGION);
        fillFormAction.moveToElement(salaryInput).click()
                .sendKeys(VACANCY_SALARY).build().perform();
        return pressButton();
    }
}
