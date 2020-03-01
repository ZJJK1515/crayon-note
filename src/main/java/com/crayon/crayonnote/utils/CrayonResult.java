package com.crayon.crayonnote.utils;

public class CrayonResult {

    private boolean success;

    private Object data;

    private String message;


    public CrayonResult(boolean success) {
        this.success = success;
    }

    public CrayonResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public CrayonResult(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public static CrayonResult ok() {
        return new CrayonResult(true);
    }

    public static CrayonResult ok(Object data) {
        return new CrayonResult(true, data);
    }

    public static CrayonResult error(String message) {
        return new CrayonResult(false, message);
    }
}
