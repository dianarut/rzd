package com.rzd.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicScheduleLDTrainsResultsPage   extends AbstractPage{

    @FindBy(xpath = "//*[@class = 'basicSched_trainsMark']")
    private WebElement someDate;

    @FindBy(id = "basicSched_simplemodal-container")
    private WebElement informationMessage;

    @FindBy(id = "st_from")
    private WebElement fromField;

    @FindBy(id = "st_to")
    private WebElement toField;

    public BasicScheduleLDTrainsResultsPage clickSomeDate(){
        someDate.click();
        return this;
    }

    public String getFrom(){
        return fromField.getAttribute("value");
    }

    public String getTo(){
        return toField.getAttribute("value");
    }

    public boolean checkInformationMessage() {
        return informationMessage.isDisplayed();
    }
}
