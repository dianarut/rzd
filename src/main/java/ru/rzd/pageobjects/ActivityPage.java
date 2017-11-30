package ru.rzd.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivityPage extends AbstractPage {

    @FindBy(xpath = "(//li/a[contains(text(), '2011')])[1]")
    private WebElement linkTo2011report;

    public ActivityPage clickLinkTo2011report() {
        linkTo2011report.click();
        return this;
    }

    @FindBy(xpath = "//a[@target='_self']")
    private WebElement linkToGamesPage;

    public GamesPage clickLinklinkToGamesPage() {
        linkToGamesPage.click();
        return new GamesPage();
    }

}
