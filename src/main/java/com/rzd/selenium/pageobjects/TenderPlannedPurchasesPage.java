package com.rzd.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TenderPlannedPurchasesPage extends AbstractPage {



    @FindBy(xpath = "//a[text()='План закупок для нужд ОАО 'РЖД' на 2017 год']")
    public WebElement filePurchaisePlan2017;

    public void downloadPurshasingPlan(){
        super.webDriverWait().until(ExpectedConditions.visibilityOf(filePurchaisePlan2017));
        filePurchaisePlan2017.click();
    }

    public String docName(){
        return filePurchaisePlan2017.getText();
    }

}
