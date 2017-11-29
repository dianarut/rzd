package ru.rzd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.rzd.factory.BrowserFactory;

import javax.swing.*;


public class TenderPlannedPurchasesPage extends AbstractPage {

    @FindBy(xpath = "//a[text()='План закупок для нужд ОАО \"РЖД\" на 2017 год']")
    public WebElement filePurchaisePlan2017;

    public TenderPlannedPurchasesPage downloadPurshasingPlan(){
        waitForElementVisible(filePurchaisePlan2017, 3);
        highlightElement(filePurchaisePlan2017);
        new Actions(BrowserFactory.getInstance().getDriver()).moveToElement(filePurchaisePlan2017).click(filePurchaisePlan2017).build().perform();
        return this;
    }

    public WebElement getFilePurchaisePlan2017() {
        return filePurchaisePlan2017;
    }



}
