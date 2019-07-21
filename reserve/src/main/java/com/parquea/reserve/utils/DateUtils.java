package com.parquea.reserve.utils;

import java.time.LocalDateTime;

public class DateUtils {
    private DateUtils() {

    }

    public static boolean esMayorALaFechaActual(LocalDateTime date) {
        return LocalDateTime.now().isBefore(date);
    }

    public static boolean inicialEsMayorAFinal(LocalDateTime initial, LocalDateTime end) {
        return initial.isBefore(end);
    }
}
