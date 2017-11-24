package ru.rzd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PaymentPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(text(),'CVV')]")
    private List<WebElement> payPageAtribute;

    public List<WebElement> getPayPageAtribute() {
        return payPageAtribute;
    }

}
