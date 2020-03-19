package com.crayonnote.modules.common.exception;

public class CrayonException extends RuntimeException {

    public CrayonException() {
    }

    public CrayonException(String message) {
        super(message);
    }

    public CrayonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CrayonException(Throwable cause) {
        super(cause);
    }

    public CrayonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
