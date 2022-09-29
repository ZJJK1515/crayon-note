package com.crayon.common.core.exception;

public class CrayonException extends Exception {

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

}
