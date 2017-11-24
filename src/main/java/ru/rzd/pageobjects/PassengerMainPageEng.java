package ru.rzd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PassengerMainPageEng extends AbstractPage {

    @FindBy(xpath = "(//div[@class=\"box-form__tabz-cont-child\"])[1]")
    private WebElement suburbanTrainTab;

    public PassengerMainPageEng goToSuburbanTrainTab() {
        tabSwitcher();
        suburbanTrainTab.click();
        return this;
    }
}