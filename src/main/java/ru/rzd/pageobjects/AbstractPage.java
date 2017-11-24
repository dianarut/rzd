package ru.rzd.pageobjects;

import ru.rzd.factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class AbstractPage {

    private WebDriver driver;

    public AbstractPage() {
        driver = BrowserFactory.getInstance().getDriver();
        PageFactory.initElements(this.driver, this);
    }

    public WebDriverWait webDriverWait() {
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        return waiter;
    }

    protected void waitForElementEnabled(WebElement webElement, int seconds) {
        new WebDriverWait(driver, seconds).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public String getTitleFromDriver() {
        String title = driver.getTitle();
        return title;
    }


    public void tabSwitcher() {
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
    }

}
