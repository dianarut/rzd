package ru.rzd.pageobjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class PayAgreementPage extends AbstractPage {

    @FindBy(xpath = "//h3[text()='Ваши места успешно забронированы!']")
    private List<WebElement> reservationMessage;

    @FindBy(xpath = "//input[@type='checkbox' and @class='j-confirm']")
    private WebElement agreeButton;

    @FindBy(xpath = "//span[text()='Перейти к оплате']")
    private WebElement goToPaymentButton;

    public List<WebElement> getReservationMessage() {
        return reservationMessage;
    }

    public PaymentPage goToPaymentPage() {
        goToPaymentButton.click();
        return new PaymentPage();
    }

    public PayAgreementPage checkAgreeWithTermsBox() {
        super.waitForElementEnabled(agreeButton, 2);
        clickElementWithJavaScript(agreeButton);
        return this;
    }
}
