package ru.rzd.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SuburbanTrainConfirmationPage extends AbstractPage {

    @FindBy(how = How.XPATH, using = "//input[@class='j-allow-bitton']")
    private WebElement iAgreeCheckbox;

    @FindBy(how = How.XPATH, using = "//button[@id='ConfirmSubmit']")
    private WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//h1")
    private List<WebElement> pageh1Text;

    public SuburbanTrainConfirmationPage oneAgreeToTermOfUse() {
        super.webDriverWait().until(ExpectedConditions.elementToBeClickable(iAgreeCheckbox));
        iAgreeCheckbox.click();
        submitButton.click();
        return this;
    }

    public List<WebElement> getPageh1Text() {
        waitForElementVisible(pageh1Text.get(0), 2);
        return pageh1Text;
    }
}
