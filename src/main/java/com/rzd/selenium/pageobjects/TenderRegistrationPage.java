package com.rzd.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TenderRegistrationPage extends AbstractPage {

    @FindBy(id = "Property_Kind")
    private WebElement property_kind;

    @FindBy(id = "OrgName")
    private WebElement organizationName;

    @FindBy(id="ISMSP_YES")
    private WebElement subjectButton;

    @FindBy(id = "INN")
    private WebElement inn;

    @FindBy(id = "LegalAddress")
    private WebElement legalAddress;

    @FindBy(id = "sameAddress")
    private WebElement sameAddressButton;

    @FindBy(id = "Phone")
    private WebElement phone;

    @FindBy(id = "OrgEmail")
    private WebElement email;

    @FindBy(id = "OrgEmail2")
    private WebElement emailConfirm;

//captcha



}
