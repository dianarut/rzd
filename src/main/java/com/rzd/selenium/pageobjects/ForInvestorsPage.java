package com.rzd.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ForInvestorsPage extends AbstractPage {

    @FindBy(xpath = "//title[text()='Инвесторам']")
    private List<WebElement> investoramPageTitle;

    public int isForInvestorsPage() {
        return investoramPageTitle.size();
    }


}
