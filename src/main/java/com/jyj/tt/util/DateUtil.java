package com.jyj.tt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
    public static final String HOUR_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String MONTH_PATTERN = "yyyy-MM";
    public static final String YEAR_PATTERN = "yyyy";
    public static final String MINUTE_ONLY_PATTERN = "mm";
    public static final String HOUR_ONLY_PATTERN = "HH";

    public static long dateParse(String dateTimeString, String pattern) {
        long times = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            Date date = sdf.parse(dateTimeString);
            times = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return times;
    }

    public static String dateFormat(Date date, String pattern) {
        if (date==null)return "";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String strDate = "";
        try {
            strDate = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDate;
    }
}
