package com.parquea.reserve.utils;

import java.util.Date;

public class DateUtils {
    private DateUtils() {

    }

    public static boolean isAfterTime(Date date) {
        return new Date().before(date);
    }

    public static boolean isAfterTime(Date initial, Date end) {
        return initial.before(end);
    }
}
