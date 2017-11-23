package com.rzd.selenium.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuburbanTrainConfirmationPage extends AbstractPage {

    @FindBy(how = How.XPATH, using = "//input[@class=\"j-allow-bitton\"]")
    private WebElement iAgreeCheckbox;

    @FindBy(how = How.XPATH, using = "//button[@id=\"ConfirmSubmit\"]")
    private WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//h1")
    private WebElement pageh1Text;

    public SuburbanTrainConfirmationPage clickOnIAgreeCheckbox() {
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(iAgreeCheckbox));
        iAgreeCheckbox.click();
        return this;
    }

    public PaymentPage clickOnSubmitButton() {
        submitButton.click();
        return new PaymentPage();
    }

    public String pageh1Text() {
        return pageh1Text.getText();
    }


}
