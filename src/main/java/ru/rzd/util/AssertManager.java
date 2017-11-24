package ru.rzd.util;

import org.openqa.selenium.WebElement;

import java.util.List;

public class AssertManager {
    public static boolean isElementPresent(List<WebElement> list) {
        if (list.size() > 0) {
            return true;
        }
        return false;
    }
}
