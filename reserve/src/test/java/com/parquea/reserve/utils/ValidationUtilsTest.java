package com.parquea.reserve.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationUtilsTest {

    @Test
    public void isValidId() {
        assertTrue("se esperaba que 1 sea un id valido", ValidationUtils.isValidId(1));
    }

    @Test
    public void isInvalidId() {
        assertFalse("se esperaba que 0 sea un id invalido", ValidationUtils.isValidId(0));
    }

    @Test
    public void isInvalidIdNegative() {
        assertFalse("se esperaba que -10 sea un id invalido", ValidationUtils.isValidId(-10));
    }
}