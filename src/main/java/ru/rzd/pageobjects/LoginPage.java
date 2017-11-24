package ru.rzd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends AbstractPage {

    @FindBy(how = How.XPATH, using = "//input[@id=\"j_username\"]")
    private WebElement loginField;

    @FindBy(how = How.XPATH, using = "//input[@id=\"j_password\"]")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//span[@class=\"btn-ie-mid\"]")
    private WebElement submitButton;

    public LoginPage nameField(String loginName) {
        loginField.sendKeys(loginName);
        return this;
    }

    public LoginPage passwordField(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage submitButton() {
        submitButton.click();
        return this;
    }

}
