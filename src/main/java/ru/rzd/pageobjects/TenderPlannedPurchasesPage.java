package ru.rzd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TenderPlannedPurchasesPage extends AbstractPage {

    @FindBy(xpath = "//a[text()='План закупок для нужд ОАО \"РЖД\" на 2017 год']")
    public WebElement filePurchaisePlan2017;

    public TenderPlannedPurchasesPage downloadPurshasingPlan(){
        waitForElementVisible(filePurchaisePlan2017, 3);
        filePurchaisePlan2017.click();
        return this;
    }

    public WebElement getFilePurchaisePlan2017() {
        return filePurchaisePlan2017;
    }



}
