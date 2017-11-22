package com.rzd.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RestAndTreatmentPage extends AbstractPage{

    @FindBy(xpath = "//title[text()='Отдых и лечение']")
    private List<WebElement> restPageTitle;

    public int isRestAndTreatmentPage (){
        return restPageTitle.size();
    }
}
