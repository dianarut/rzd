package ru.rzd.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.rzd.factory.BrowserFactory;
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

    private WebDriver driver = BrowserFactory.getInstance().getDriver();
    private Actions fillFormAction = new Actions(driver);
    private static final String EDUCATION_NAME = ConfigurationManager.getProperty("education.name");
    private static final String EDUCATION_SPECIALIZATION = ConfigurationManager.getProperty("education.specialization");
    private static final String EDUCATION_CITY = ConfigurationManager.getProperty("education.city");
    private String jsHighlightStyle = "arguments[0].style.border='6px solid red'";

    @Override
    protected void highlightElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript(jsHighlightStyle, element);
    }

    public boolean pressButton(){
        highlightElement(searchButton);
        fillFormAction.moveToElement(searchButton).click().build().perform();
        return resultList.isEmpty();
    }

    public void fillForm(){
        fillFormAction.moveToElement(nameInput).click().sendKeys(EDUCATION_NAME).build().perform();
        Select specializationDropdown = new Select(specializationInput);
        specializationDropdown.selectByVisibleText(EDUCATION_SPECIALIZATION);
        Select cityDropdown = new Select(cityInput);
        cityDropdown.selectByVisibleText(EDUCATION_CITY);
    }
}
