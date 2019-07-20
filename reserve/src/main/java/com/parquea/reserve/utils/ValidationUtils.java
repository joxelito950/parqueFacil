package com.parquea.reserve.utils;

public class ValidationUtils {
    private ValidationUtils() {

    }

    public static boolean isValidId(long id) {
        return 0 < id;
    }
}
