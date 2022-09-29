package com.crayon.common.core;

import lombok.Data;

@Data
public class Result<T> {

    private boolean success;
    private T data;
    private Integer code;
    private String msg;

    public Result() {
        this.code = 200;
        this.success = true;
    }


    public Result(T data) {
        this.code = 200;
        this.success = true;
        this.data = data;
    }

    public Result(String msg) {
        success = false;
        this.code = 500;
        this.msg = msg;
    }

    public Result(int code) {
        success = false;
        this.code = code;
    }

    public Result(int code, String msg) {
        success = false;
        this.code = code;
        this.msg = msg;
    }

    public static <T> Result<T> ok() {
        return new Result<>();
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(data);
    }

    public static <T> Result<T> error() {
        return new Result<>("");
    }

    public static <T> Result<T> error(String errorMsg) {
        return new Result<>(errorMsg);
    }

    public static <T> Result<T> error(int code, String errorMsg) {
        return new Result<>(code, errorMsg);
    }

}
