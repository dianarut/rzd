package ru.rzd.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.rzd.factory.BrowserFactory;

public class BasicSchedulePage extends AbstractPage {

    @FindBy(id = "st_from")
    private WebElement fieldFrom;

    @FindBy(id = "st_to")
    private WebElement fieldTo;

    @FindBy(xpath = ".//button[text() = 'Расписание'][ancestor :: *[@id ='tab3_Output']]")
    private WebElement buttonSchedule;

    private BasicSchedulePage setField(WebElement element, String field) {
        element.click();
        element.clear();
        element.sendKeys(field);
        new Actions(BrowserFactory.getInstance().getDriver()).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).build().perform();
        return this;
    }

    private BasicSchedulePage setFields(String from, String to) {
        this.setField(fieldFrom, from);
        this.setField(fieldTo, to);
        return this;
    }

    private BasicSchedulePage clickScheduleButton(){
        buttonSchedule.click();
        return this;
    }

    public BasicSchedulePage fillForm(String from, String to){
        setFields(from,to);
        clickScheduleButton();
        return this;
    }
}
