package com.fawry.productcatalog.exception;

public class BadParamsException extends RuntimeException{
    public BadParamsException() {
    }

    public BadParamsException(String message) {
        super(message);
    }

    public BadParamsException(String message, Throwable cause) {
        super(message, cause);
    }
}
