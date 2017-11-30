package ru.rzd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class RestAndTreatmentPage extends AbstractPage{

    @FindBy(xpath = "//*[contains(text(),'Отдых и лечение')]")
    private List<WebElement> restAndtreatmentPageAtribute;

    public List<WebElement> getRestAndtreatmentPageAtribute() {
        return restAndtreatmentPageAtribute;
    }

}
