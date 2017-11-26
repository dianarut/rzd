package ru.rzd.pageobjects;

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

    public WebElement getSomeDate() {
        return someDate;
    }

    public WebElement getInformationMessage() {
        return informationMessage;
    }
    public WebElement getFromField() {
        return fromField;
    }

    public WebElement getToField() {
        return toField;
    }

    public BasicScheduleLDTrainsResultsPage clickSomeDate(){
        someDate.click();
        return this;
    }
}
