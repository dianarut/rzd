package com.rzd.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TenderPage extends AbstractPage{

    @FindBy(xpath = "//a[@class=\"btn btn-color-red\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//img[@title = \"Закупочная площадка\"]")
    private WebElement purchasingArea;

    @FindBy(xpath = "//img[@title = \"Планируемые закупки\"]")
    private WebElement plannedPurchase;

    public TenderPlannedPurchasesPage openPlannedpurchasePage(){
        plannedPurchase.click();
        return new TenderPlannedPurchasesPage();
    }

    public TenderSearchPage openTenderSearchPage(){
        searchButton.click();
        return new TenderSearchPage();
    }
}
