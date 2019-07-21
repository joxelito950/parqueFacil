package com.parquea.reserve.exceptions;

public class InvalidDTOException extends Exception {
    public InvalidDTOException(String message) {
        super(message);
    }

    public InvalidDTOException(String message, Throwable cause) {
        super(message, cause);
    }
}
