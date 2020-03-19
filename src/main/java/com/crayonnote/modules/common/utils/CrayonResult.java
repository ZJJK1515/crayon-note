package com.crayonnote.modules.common.utils;

import java.util.HashMap;

/**
 * 调用结果类
 *
 */
public class CrayonResult extends HashMap<String, Object> {

    public CrayonResult() {
        super.put("success", true);
    }

    public CrayonResult(String key, Object value) {
        super.put(key, value);
    }

    public CrayonResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static CrayonResult ok() {
        return new CrayonResult();
    }

    public static CrayonResult ok(Object data) {
        return new CrayonResult()
                .put("data", data);
    }

    public static CrayonResult error(String code) {
        return new CrayonResult("success", false)
                .put("code", code);
    }
}
