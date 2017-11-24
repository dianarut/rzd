package com.rzd.selenium.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

    private static Calendar calendar = Calendar.getInstance();

    public static Calendar getCalendar() {
        Calendar calendar = Calendar.getInstance();
        return calendar;
    }
//Заменить метод getCalendar на те что написаны снизу!!!
    public static String getCurrentDate(int plusDaysToCurrentDate) {
        calendar.add(Calendar.DATE, plusDaysToCurrentDate);
        Date dateNow = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("d.MM.yyyy");
        String date = dateFormat.format(dateNow);
        return date;
    }

    public static String getCurrentDatePlusAmountOfDays(int amountOfDays) {
        calendar.add(Calendar.DATE, amountOfDays);
        Date dateNow = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("d.MM.yyyy");
        String date = dateFormat.format(dateNow);
        return date;
    }
}