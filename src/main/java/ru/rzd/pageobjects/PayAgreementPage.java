package ru.rzd.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class PayAgreementPage extends AbstractPage {

    @FindBy(xpath = "//h3[text()='Ваши места успешно забронированы!']")
    private List<WebElement> reservationMessage;

    @FindBy(xpath = "//input[@type=\"checkbox\" and @class=\"j-confirm\"]")
    private WebElement agreeButton;

    @FindBy(xpath = "//span[text()='Перейти к оплате']")
    private WebElement goToPaymentButton;

    public PaymentPage goToPayment() {
        goToPaymentButton.click();
        return new PaymentPage();
    }

    public int isReservationMessage() {
        return reservationMessage.size();
    }

    public PayAgreementPage agreeWithTerms() {
        super.waitForElementEnabled(agreeButton, 2);
        agreeButton.click();
        return this;
    }
}
