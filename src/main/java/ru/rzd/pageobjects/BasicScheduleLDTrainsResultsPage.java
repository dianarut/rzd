package ru.rzd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasicScheduleLDTrainsResultsPage   extends AbstractPage{

    @FindBy(xpath = "//*[@class = 'basicSched_trainsMark']")
    private WebElement buttonAvailableDate;

    @FindBy(id = "basicSched_simplemodal-container")
    private WebElement messegeInformationAboutRouts;

    @FindBy(id = "st_from")
    private WebElement fieldFrom;

    @FindBy(id = "st_to")
    private WebElement fieldTo;

    public WebElement getSomeDate() {
        return buttonAvailableDate;
    }

    public WebElement getInformationMessage() {
        return messegeInformationAboutRouts;
    }
    public WebElement getFromField() {
        return fieldFrom;
    }

    public WebElement getToField() {
        return fieldTo;
    }

    public BasicScheduleLDTrainsResultsPage clickSomeDate(){
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(buttonAvailableDate));
        highlightElement(buttonAvailableDate);
        clickElementWithJavaScript(buttonAvailableDate);
        return this;
    }
}
