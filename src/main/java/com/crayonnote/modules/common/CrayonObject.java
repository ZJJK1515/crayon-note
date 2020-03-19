package com.crayonnote.modules.common;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;

public abstract class CrayonObject<T> {

    /**
     * 将 obj 转成 json
     *
     * @param obj 对象
     * @return json
     */
    public String toJson(T obj) {
        return JSONObject.toJSONString(obj);
    }

    public void copyProperties(Object target) {
        BeanUtils.copyProperties(this, target);
    }
}
