package com.rzd.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.concurrent.TimeUnit;

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

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        String[] dirContents = dir.list();


        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].equals(fileName)) {
                // File has been found, it can now be deleted:
                break;
            }
        }
        return true;
    }


}
