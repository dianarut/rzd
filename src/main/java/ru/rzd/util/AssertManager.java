package ru.rzd.util;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AssertManager {
        public static boolean isElementPresent(List<WebElement> list) {
            if (list.size() > 0) {
                return true;
            }
            return false;
        }

    public static boolean isResultAfterFiltrationCorrect(List<WebElement> list1, List<WebElement>list2, List<WebElement>list3, String date){
        boolean res = false;
        if(list1.size()==list2.size())
            for (WebElement n: list3) {
                if(n.getText().contains(date))
                    res = true;
            }
        return res;
    }

    public static boolean isContentOfVisibleElementContainsText(String text, WebElement element) {
        return element.getText().toLowerCase().contains(text.toLowerCase());
    }

    public static boolean isContentOfInvisibleElementContainsText(String text, WebElement element) {
        return element.getAttribute("textContent").toLowerCase().contains(text.toLowerCase());
    }

    public static boolean isValueOfVisibleElementContainsText(String text, WebElement element) {
        return element.getAttribute("value").toLowerCase().contains(text.toLowerCase());
    }

    public static boolean isElementDisplayed(WebElement element){
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
