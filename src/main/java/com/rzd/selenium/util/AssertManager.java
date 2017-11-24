package com.rzd.selenium.util;

import org.openqa.selenium.WebElement;
import java.util.List;

public class AssertManager {
    public static boolean isElementPresent(List<WebElement> list) {
        if (list.size() > 0) {
            return true;
        }
        return false;
    }

//    public static boolean checkFromStation(String from) {
//        String station = getTextFromStation().getAttribute("textContent");
//        System.out.println(station.toLowerCase());
//        return station.toLowerCase().contains(from.toLowerCase());
//    }
}