package ru.rzd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.rzd.business_objects.User;

import java.util.List;

public class LoginPage extends AbstractPage {

    @FindBy(how = How.XPATH, using = "//input[@id='j_username']")
    private WebElement loginField;

    @FindBy(how = How.XPATH, using = "//input[@id='j_password']")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//span[@class='btn-ie-mid']")
    private WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//td[@class='arrLinkBlock tar']/a")
    private List<WebElement> buttonForgotPassword;

    public LoginPage oneCanLoginToWebsite(User user) {
        loginField.sendKeys(user.getLogin());
        passwordField.sendKeys(user.getPassword());
        submitButton.click();
        return this;
    }

    public List<WebElement> getButtonForgotPassword() {
        return buttonForgotPassword;
    }
}
