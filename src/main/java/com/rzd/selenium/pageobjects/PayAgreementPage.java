package com.rzd.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PayAgreementPage extends AbstractPage {

    @FindBy(xpath="//h3[text()='Ваши места успешно забронированы!']")
    private List<WebElement> reservationMessage;

    public int isReservationMessage(){
        return reservationMessage.size();
    }

    @FindBy(xpath ="//input[@type=\"checkbox\" and @class=\"j-confirm\"]")
    private WebElement agreeButton;

    public PayAgreementPage agreeWithTerms(){
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(agreeButton));
        agreeButton.click();
        return this;
    }

    @FindBy(xpath = "//span[text()='Перейти к оплате']")
    private WebElement goToPaymentButton;

    public PaymentPage goToPayment(){
        goToPaymentButton.click();
        return new PaymentPage();
    }
}
