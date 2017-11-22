package com.rzd.selenium.pageobjects;


import com.rzd.selenium.factory.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;


public class PassengerMainPageEng extends AbstractPage {

    @FindBy(xpath = "(//div[@class=\"box-form__tabz-cont-child\"])[1]")
    WebElement suburbanTrainTab;


    public PassengerMainPageEng goToSuburbanTrainTab() {
        switchTabInBrowser();
        suburbanTrainTab.click();
        return this;
    }


    public void switchTabInBrowser(){
        ArrayList<String> tabs2 = new ArrayList<> (BrowserFactory.getInstance().getDriver().getWindowHandles());
        BrowserFactory.getInstance().getDriver().switchTo().window(tabs2.get(0));
        BrowserFactory.getInstance().getDriver().close();
        BrowserFactory.getInstance().getDriver().switchTo().window(tabs2.get(1));
    }

}