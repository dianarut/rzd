package ru.rzd.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.rzd.factory.BrowserFactory;

public class PassengerMainPageEng extends AbstractPage {

    private WebDriver driver = BrowserFactory.getInstance().getDriver();

    @FindBy(xpath = "(//div[@class='box-form__tabz-cont-child'])[1]")
    private WebElement suburbanTrainTab;

    public PassengerMainPageEng goToSuburbanTrainTab() {
        tabSwitcher();
        highlightElement(suburbanTrainTab);
        suburbanTrainTab.click();
        return this;
    }

    @Override
    protected void highlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='4px solid red'", element);
    }
}