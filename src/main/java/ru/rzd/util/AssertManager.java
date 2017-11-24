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

    public static boolean isResultAfterFiltrationCorrect(List<WebElement> list1, List<WebElement>list2, List<WebElement>list3, String date){
        boolean res = false;
        if(list1.size()==list2.size())
            for (WebElement n: list3) {
                if(n.getText().contains(date))
                    res = true;
            }
        return res;
    }
}
