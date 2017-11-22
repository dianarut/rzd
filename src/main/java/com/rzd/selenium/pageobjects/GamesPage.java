package com.rzd.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GamesPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(text(),'Олимпийские игры')]")
    private List<WebElement> gamesPageTitle;

    public int isGamesPage () {
        return gamesPageTitle.size();
    }
}
