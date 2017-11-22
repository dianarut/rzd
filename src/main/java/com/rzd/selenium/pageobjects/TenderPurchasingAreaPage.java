package com.rzd.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TenderPurchasingAreaPage extends AbstractPage {

    @FindBy(xpath = "//a/u[text()='форму']")
    private WebElement form;

    public TenderRegistrationPage openRegistrationPage(){
        form.click();
        return new TenderRegistrationPage();
    }
}
