package ru.rzd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ForInvestorsPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(text(),'Новости для инвесторов')]")
    private List<WebElement> investoramPageAtribute;

    public List<WebElement> getInvestoramPageAtribute() {
        return investoramPageAtribute;
    }
}
