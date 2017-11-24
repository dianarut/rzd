package ru.rzd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicSchedulePage extends AbstractPage {

    @FindBy(id = "st_from")
    private WebElement fromField;

    @FindBy(id = "st_to")
    private WebElement toField;

    @FindBy(xpath = ".//button[text() = 'Расписание'][ancestor :: *[@id ='tab3_Output']]")
    private WebElement scheduleButton;

    public BasicSchedulePage clickFromField(){
        fromField.click();
        return this;
    }

    public BasicSchedulePage clickToField(){
        toField.click();
        return this;
    }

    public BasicSchedulePage setFromField(String from) {
        fromField.clear();
        fromField.sendKeys(from);
        return this;
    }

    public BasicSchedulePage setToField(String to) {
        toField.clear();
        toField.sendKeys(to);
        return this;
    }

    public BasicSchedulePage clickScheduleButton(){
        scheduleButton.click();
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
