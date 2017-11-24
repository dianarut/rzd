package ru.rzd.pageobjects;

import ru.rzd.factory.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class ActivityPage extends AbstractPage {

    @FindBy(xpath = "(//li/a[contains(text(), '2011')])[1]")
    private WebElement linkTo2011report;

    public ActivityPage click2011() {
        tabSwitcher();
        linkTo2011report.click();
        return this;
    }

    @FindBy(xpath = "//a[@target='_self']")
    private WebElement linkToGamesPage;

    public GamesPage clickTheLink() {
        linkToGamesPage.click();
        return new GamesPage();
    }

}
