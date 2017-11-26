package ru.rzd.pageobjects;

import ru.rzd.util.ConfigurationManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class EducationPage extends AbstractPage{

    @FindBy(xpath = ".//button[1]//span[2]")
    private WebElement searchButton;

    @FindBy(xpath = ".//div[@class='college_itemContent']")
    private List<WebElement> resultList;

    @FindBy(xpath = ".//input[@class='textInput']")
    private WebElement nameInput;

    @FindBy(xpath = ".//select[@name='trade_id']")
    private WebElement specializationInput;

    @FindBy(xpath = ".//select[@name='city_id']")
    private WebElement cityInput;

    private static final String EDUCATION_NAME = ConfigurationManager.getProperty("education.name");
    private static final String EDUCATION_SPECIALIZATION = ConfigurationManager.getProperty("education.specialization");
    private static final String EDUCATION_CITY = ConfigurationManager.getProperty("education.city");

    public int pressButton(){
        searchButton.click();
        return resultList.size();
    }

    public void fillForm(){
        nameInput.sendKeys(EDUCATION_NAME);
        Select dropdownSpec = new Select(specializationInput);
        dropdownSpec.selectByVisibleText(EDUCATION_SPECIALIZATION);
        Select dropdownCity = new Select(cityInput);
        dropdownCity.selectByVisibleText(EDUCATION_CITY);
    }
}
