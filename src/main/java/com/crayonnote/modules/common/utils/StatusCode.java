package com.crayonnote.modules.common.utils;

public enum StatusCode {
    SUCCESS(20000,"成功"),
    FAILD(90000,"失败");

    private Integer code;
    private String message;

    StatusCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
