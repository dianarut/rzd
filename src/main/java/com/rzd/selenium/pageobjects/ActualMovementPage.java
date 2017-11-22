package com.rzd.selenium.pageobjects;

import com.rzd.selenium.factory.BrowserFactory;
import com.rzd.selenium.util.ConfigurationManager;
import com.rzd.selenium.util.TimeUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Calendar;
import java.util.List;

public class ActualMovementPage extends AbstractPage{

    @FindBy(xpath = ".//input[@name='dst']")
    private WebElement arriveStationField;

    @FindBy(xpath = ".//input[@name='src']")
    private WebElement departureStationField;

    @FindBy (id = "TabloSubmit")
    private WebElement submitButton;

    @FindBy (xpath = ".//tr[@class='trlist__trlist-row']")
    private List<WebElement> resultList;

    @FindBy (xpath = ".//span[@class='j-calendar-pass calendar_pass box-form__datetime__calendar']")
    private WebElement departureCalendar;

    @FindBy(id = "nTrain")
    private WebElement trainNumber;

    public void fillArrive(){
        arriveStationField.sendKeys(ConfigurationManager.getProperty("movement.base.to"));
        BrowserFactory.getInstance().getDriver().findElement(By.xpath(".//div[@class='station' and text()='" +
                ConfigurationManager.getProperty("movement.to") + "']")).click();
    }

    public boolean pressButton(){
        submitButton.click();

        return resultList.isEmpty();
    }

    public void fillDeparture(){
        departureStationField.sendKeys(ConfigurationManager.getProperty("movement.base.from"));
        BrowserFactory.getInstance().getDriver().findElement(By.xpath(".//div[@class='station' and text()='" +
                ConfigurationManager.getProperty("movement.from") + "']")).click();
        departureCalendar.click();
        BrowserFactory.getInstance().getDriver().findElement(By.xpath(".//span[@class='select-time " +
                "days45 near-time' and text()=" + (TimeUtil.getCalendar().get(TimeUtil.getCalendar().DAY_OF_MONTH) - 1) + "]")).click();
    }

    public void fillTrainNumber(){
        trainNumber.sendKeys(ConfigurationManager.getProperty("movement.number"));
    }
}
