package com.rzd.selenium.util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

    private static Calendar calendar = Calendar.getInstance();
    private static String date;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("d.MM.yyyy");
    private static Date dateNow;

    public static Calendar getCalendar() {
        Calendar calendar = Calendar.getInstance();
        return calendar;
    }

    //Заменить метод getCalendar на те что написаны снизу!!!
    public static String getCurrentDate() {
        dateNow = calendar.getTime();
        date = dateFormat.format(dateNow);
        return date;
    }

    public static String getCurrentDatePlusAmountOfDays(int amountOfDays) {
        calendar.add(Calendar.DATE, amountOfDays);
        dateNow = calendar.getTime();
        date = dateFormat.format(dateNow);
        return date;
    }

}
