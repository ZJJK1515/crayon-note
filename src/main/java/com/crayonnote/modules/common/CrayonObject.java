package com.crayonnote.modules.common;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;

public abstract class CrayonObject {

    /**
     * 将 obj 转成 json
     *
     * @param obj 对象
     * @return json
     */
    public String toJsonString(Object obj) {
        return JSONObject.toJSONString(obj);
    }

    /**
     * 复制属性
     * @param target 目标对象
     */
    public void copyProperties(Object target) {
        BeanUtils.copyProperties(this, target);
    }

    public void copyPropertiesFrom(Object source) {
        BeanUtils.copyProperties(source, this);
    }
}
