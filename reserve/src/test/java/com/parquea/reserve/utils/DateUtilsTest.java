package com.parquea.reserve.utils;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateUtilsTest {

    private LocalDateTime dateactual;

    @Before
    public void inicializarTest() {
        dateactual = LocalDateTime.now();
    }

    @Test
    public void isAfterTime() {
        assertTrue("se espera que sea una fecha futura", DateUtils.esMayorALaFechaActual(dateactual.plusMinutes(2L)));
    }

    @Test
    public void isBeforeTime() {
        assertFalse("se espera que sea una fecha pasada", DateUtils.esMayorALaFechaActual(dateactual.minusMinutes(2L)));
    }

    @Test
    public void isBeforeTimeCompare() {
        assertFalse("se espera que la fecha inicial no sea mayor a la fecha fin", DateUtils.inicialEsMayorAFinal(dateactual.plusDays(1L), dateactual));
    }

    @Test
    public void isAfterTimeCompare() {
        assertTrue("se espera que la fecha inicial sea mayor que la fecha fin", DateUtils.inicialEsMayorAFinal(dateactual, dateactual.plusDays(1L)));
    }

    @Test
    public void isEqualTimeCompare() {
        assertFalse("se espera que la fecha inicial no sea igual a la fecha fin", DateUtils.inicialEsMayorAFinal(dateactual, dateactual));
    }
}