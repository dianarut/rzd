package ru.rzd.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import ru.rzd.factory.BrowserFactory;
import ru.rzd.util.ConfigurationManager;
import ru.rzd.util.TimeUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ActualMovementPage extends AbstractPage{

    @FindBy(xpath = ".//input[@name='dst']")
    private WebElement arriveStationInput;

    @FindBy(xpath = ".//input[@name='src']")
    private WebElement departureStationInput;

    @FindBy (id = "TabloSubmit")
    private WebElement submitButton;

    @FindBy (xpath = ".//tr[@class='trlist__trlist-row']")
    private List<WebElement> resultList;

    @FindBy (xpath = ".//span[@class='j-calendar-pass calendar_pass box-form__datetime__calendar']")
    private WebElement departureCalendar;

    @FindBy(id = "nTrain")
    private WebElement trainNumberInput;

    private WebDriver driver = BrowserFactory.getInstance().getDriver();
    private Actions fillFormAction = new Actions(driver);
    private static final String MOVEMENT_TO = ConfigurationManager.getProperty("movement.to");
    private static final String MOVEMENT_BASE_TO = ConfigurationManager.getProperty("movement.base.to");
    private static final String MOVEMENT_BASE_FROM = ConfigurationManager.getProperty("movement.base.from");
    private static final String MOVEMENT_FROM = ConfigurationManager.getProperty("movement.from");
    private static final String MOVEMENT_NUMBER = ConfigurationManager.getProperty("movement.number");
    private static final int DAY = TimeUtil.getDayBeforeCurrentDate();
    private String jsHighlightStyle = "arguments[0].style.border='6px solid red'";

    @Override
    protected void highlightElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript(jsHighlightStyle, element);
    }

    private boolean pressButton(){
        highlightElement(submitButton);
        fillFormAction.moveToElement(submitButton).click().build().perform();
        return resultList.isEmpty();
    }

    public boolean fillArrive(){
        fillFormAction.moveToElement(arriveStationInput).click()
                .sendKeys(MOVEMENT_BASE_TO).build().perform();
        WebElement arriveDropdown = driver.findElement(By.xpath(".//div[@class='station' and text()='" + MOVEMENT_TO + "']"));
        fillFormAction.moveToElement(arriveDropdown).click().build().perform();
        return pressButton();
    }

    public boolean fillDeparture(){
        fillFormAction.moveToElement(departureStationInput).click()
                .sendKeys(MOVEMENT_BASE_FROM).build().perform();
        WebElement departureDropdown = driver.findElement(By.xpath(".//div[@class='station' and text()='" + MOVEMENT_FROM + "']"));
        fillFormAction.moveToElement(departureDropdown).click()
                .moveToElement(departureCalendar).click().build().perform();
        WebElement dayCalendar = driver.findElement(By.xpath(".//span[@class='select-time days45 near-time' and text()=" + DAY + "]"));
        fillFormAction.moveToElement(dayCalendar).click().build().perform();
        return pressButton();
    }

    public boolean fillTrainNumber(){
        fillFormAction.moveToElement(trainNumberInput).click()
                .sendKeys(MOVEMENT_NUMBER).build().perform();
        return pressButton();
    }
}
