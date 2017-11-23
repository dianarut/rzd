package com.rzd.selenium.util;

import java.util.Calendar;

public class TimeUtil {
    public static Calendar getCalendar(){
        Calendar calendar = Calendar.getInstance();
        return calendar;
    }
    public static String getCurrentCalendar(){
        Calendar calendar = Calendar.getInstance();
        int d = calendar.get(Calendar.DATE);
        int m = calendar.get(Calendar.MONTH);
        int y = calendar.get(Calendar.YEAR);
        String currentDAte = d+"."+m+"."+y;
        return currentDAte;
    }



}
