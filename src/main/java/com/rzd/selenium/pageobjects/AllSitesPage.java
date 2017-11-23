package com.rzd.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSitesPage extends AbstractPage {

    @FindBy(xpath = "(//a[text()='Инвесторам'])[2]")
    private WebElement forInvestors;

    @FindBy(xpath = "//a[text()='Отдых и лечение']")
    private WebElement restAndTreatment;

    public RestAndTreatmentPage openRestAndTreatmentPage() {
        restAndTreatment.click();
        return new RestAndTreatmentPage();
    }

    public ForInvestorsPage openInvestoramPage() {
        forInvestors.click();
        return new ForInvestorsPage();
    }
}
