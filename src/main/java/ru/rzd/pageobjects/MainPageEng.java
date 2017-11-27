package ru.rzd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class MainPageEng extends AbstractPage {

    @FindBy(xpath = "//img[@alt='Passengers']")
    private WebElement passengerButton;

    @FindBy(xpath = "//strong[text()='Passenger Service']")
    private List<WebElement> passengerServiceText;

    public MainPageEng goToPassengerMainPage() {
        passengerButton.click();
        return this;
    }

    public List<WebElement> getPassengerServiceText() {
        waitForElementVisible(passengerServiceText.get(0), 2);
        return passengerServiceText;
    }
}
