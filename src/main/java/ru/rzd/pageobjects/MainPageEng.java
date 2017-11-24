package ru.rzd.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageEng extends AbstractPage{

    @FindBy(xpath = "//img[@alt=\"Passengers\"]")
    private WebElement passengerButton;


    public MainPageEng goToPassengerMainPage(){
        passengerButton.click();
        return this;
    }



}
