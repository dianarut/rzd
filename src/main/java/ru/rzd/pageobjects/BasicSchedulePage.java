package ru.rzd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicSchedulePage extends AbstractPage {

    @FindBy(id = "st_from")
    private WebElement fieldFrom;

    @FindBy(id = "st_to")
    private WebElement fieldTo;

    @FindBy(xpath = ".//button[text() = 'Расписание'][ancestor :: *[@id ='tab3_Output']]")
    private WebElement buttonSchedule;

    private BasicSchedulePage clickFromField(){
        fieldFrom.click();
        return this;
    }

    private BasicSchedulePage clickToField(){
        fieldTo.click();
        return this;
    }

    private BasicSchedulePage setFromField(String from) {
        fieldFrom.clear();
        fieldFrom.sendKeys(from);
        return this;
    }

    private BasicSchedulePage setToField(String to) {
        fieldTo.clear();
        fieldTo.sendKeys(to);
        return this;
    }

    private BasicSchedulePage clickScheduleButton(){
        buttonSchedule.click();
        return this;
    }

    public BasicSchedulePage fillForm(String from, String to){
        clickFromField();
        setFromField(from);
        clickToField();
        setToField(to);
        clickScheduleButton();
        return this;
    }
}
