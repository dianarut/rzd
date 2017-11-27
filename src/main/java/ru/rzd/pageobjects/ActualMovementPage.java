package ru.rzd.pageobjects;

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
    private static final String MOVEMENT_TO = ConfigurationManager.getProperty("movement.to");
    private static final String MOVEMENT_BASE_TO = ConfigurationManager.getProperty("movement.base.to");
    private static final String MOVEMENT_BASE_FROM = ConfigurationManager.getProperty("movement.base.from");
    private static final String MOVEMENT_FROM = ConfigurationManager.getProperty("movement.from");
    private static final String MOVEMENT_NUMBER = ConfigurationManager.getProperty("movement.number");
    private static final int DAY = TimeUtil.getDayBeforeCurrentDate();

    private boolean pressButton(){
        submitButton.click();
        return resultList.isEmpty();
    }

    public boolean fillArrive(){
        arriveStationInput.sendKeys(MOVEMENT_BASE_TO);
        driver.findElement(By.xpath(".//div[@class='station' and text()='" + MOVEMENT_TO + "']")).click();
        return pressButton();
    }

    public boolean fillDeparture(){
        departureStationInput.sendKeys(MOVEMENT_BASE_FROM);
        driver.findElement(By.xpath(".//div[@class='station' and text()='" + MOVEMENT_FROM + "']")).click();
        departureCalendar.click();
        driver.findElement(By.xpath(".//span[@class='select-time days45 near-time' and text()=" + DAY + "]")).click();
        return pressButton();
    }

    public boolean fillTrainNumber(){
        trainNumberInput.sendKeys(MOVEMENT_NUMBER);
        return pressButton();
    }
}
