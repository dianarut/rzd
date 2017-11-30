package ru.rzd.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.rzd.business_objects.User;
import ru.rzd.factory.BrowserFactory;

import java.util.List;

public class LoginPage extends AbstractPage {

    private WebDriver driver = BrowserFactory.getInstance().getDriver();

    @FindBy(how = How.XPATH, using = "//input[@id='j_username']")
    private WebElement loginField;

    @FindBy(how = How.XPATH, using = "//input[@id='j_password']")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//span[@class='btn-ie-mid']")
        private WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//td[@class='arrLinkBlock tar']/a")
    private List<WebElement> buttonForgotPassword;

    public LoginPage oneCanLoginToWebsite(User user) {
        highlightElement(loginField);
        loginField.sendKeys(user.getLogin());
        highlightElement(passwordField);
        passwordField.sendKeys(user.getPassword());
        clickElementWithJavaScript(submitButton);
        return this;
    }

    public List<WebElement> getButtonForgotPassword() {
        return buttonForgotPassword;
    }

    @Override
    protected void highlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='4px solid blue'", element);
    }
}
