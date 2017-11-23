package com.rzd.selenium.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
    public static Calendar getCalendar(){
        Calendar calendar = Calendar.getInstance();

        return calendar;
    }

    public static String generateDate(int plusDaysToCurrentDate) {
        Calendar cal = getCalendar();
        cal.add(Calendar.DATE, plusDaysToCurrentDate);
        Date dateNow = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("d.MM.yyyy");
        String date = dateFormat.format(dateNow);
        return date;
    }
}
