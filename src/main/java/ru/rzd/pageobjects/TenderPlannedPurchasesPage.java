package ru.rzd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TenderPlannedPurchasesPage extends AbstractPage {



    @FindBy(xpath = "//a[text()='План закупок для нужд ОАО \"РЖД\" на 2017 год']")
    public WebElement document;

    public void downloadPurshasingPlan(){
        super.webDriverWait().until(ExpectedConditions.visibilityOf(document));
        document.click();
    }

    public String docName(){
        return document.getText();
    }

}
