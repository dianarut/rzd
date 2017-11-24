package ru.rzd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSitesPage extends AbstractPage {

    @FindBy(xpath = "(//a[text()='Инвесторам'])[2]")
    private WebElement linkForInvestors;

    @FindBy(xpath = "//a[text()='Отдых и лечение']")
    private WebElement linkRestAndTreatment;

    public RestAndTreatmentPage openRestAndTreatmentPage() {
        linkRestAndTreatment.click();
        return new RestAndTreatmentPage();
    }

    public ForInvestorsPage openInvestoramPage() {
        linkForInvestors.click();
        return new ForInvestorsPage();
    }
}
