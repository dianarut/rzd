package com.rzd.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PaymentPage extends AbstractPage {

    @FindBy(xpath = "//title[text()='TW Payment Gateway']")
    private List<WebElement> paypage;

    public int isPayPage(){
        return paypage.size();
    }

}
