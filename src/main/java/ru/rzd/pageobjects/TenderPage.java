package ru.rzd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TenderPage extends AbstractPage{

    @FindBy(xpath = "//a[@class='btn btn-color-red']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//img[@title = 'Планируемые закупки']")
    private WebElement buttonPlannedPurchase;

    public TenderPlannedPurchasesPage openPlannedpurchasePage(){
        waitForElementVisible(buttonPlannedPurchase, 3);
        buttonPlannedPurchase.click();
        return new TenderPlannedPurchasesPage();
    }

    public TenderSearchPage openTenderSearchPage(){
        waitForElementVisible(buttonSearch, 3);
        buttonSearch.click();
        return new TenderSearchPage();
    }
}
