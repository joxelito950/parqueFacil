package com.parquea.reserve.utils;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class DateUtilsTest {

    @Test
    public void isAfterTime() {
        long dateactual = new Date().getTime();
        assertTrue("se espera que sea una fecha futura", DateUtils.isAfterTime(new Date(dateactual + 999)));
    }

    @Test
    public void isBeforeTime() {
        long dateactual = new Date().getTime();
        assertFalse("se espera que sea una fecha pasada", DateUtils.isAfterTime(new Date(dateactual - 999)));
    }

    @Test
    public void isAfterTimeCompare() {
        assertTrue("se espera que la fecha 12 sea mayor a la fecha de 1", DateUtils.isAfterTime(new Date(1), new Date(12)));
    }

    @Test
    public void isBeforeTimeCompare() {
        assertFalse("se espera que la fecha 1 sea menor a la fecha de 12", DateUtils.isAfterTime(new Date(12), new Date(1)));
    }
}