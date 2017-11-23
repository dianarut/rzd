package com.rzd.selenium.pageobjects;

import com.rzd.selenium.factory.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ActivityPage extends AbstractPage {

    @FindBy(xpath = "(//li/a[contains(text(), '2011')])[1]")
    private WebElement link2011;

    public ActivityPage click2011() {
        link2011.click();
        return this;
    }

    @FindBy(xpath = "//a[@target=\"_self\"]")
    private WebElement link;

    public GamesPage clickTheLink() {
        link.click();
        return new GamesPage();
    }
  //TODO add method after click
    public void switchTabInBrowser() {
        ArrayList<String> tabs2 = new ArrayList<>(BrowserFactory.getInstance().getDriver().getWindowHandles());
        BrowserFactory.getInstance().getDriver().switchTo().window(tabs2.get(0));
        BrowserFactory.getInstance().getDriver().close();
        BrowserFactory.getInstance().getDriver().switchTo().window(tabs2.get(1));
    }
}
