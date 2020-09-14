package com.crayonnote.common;

import com.crayonnote.common.exception.CrayonException;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 抽象 VO 类

 * @author JYKingWY
 */
public abstract class AbstractVO {

    /**
     * 将 vo 转成实体对象
     *
     * @return 实体对象
     */
    public <T> T toEntity(Class<T> clazz) {
        T entity;
        try {
            entity = clazz.newInstance();
            BeanUtils.copyProperties(this, entity);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new CrayonException("反射创建对象时出现异常...");
        }
        return entity;
    }


    /**
     * 将 vo 转成实体对象
     *
     * @return 实体对象
     */
    public <T> T toEntity() {
        T entity;
        try {
            ParameterizedType parametclass = (ParameterizedType) this.getClass().getGenericSuperclass();
            Type[] actualTypeArguments = parametclass.getActualTypeArguments();
            Class<T> entityClass = (Class<T>) actualTypeArguments[1];
            entity = entityClass.newInstance();
            BeanUtils.copyProperties(this, entity);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new CrayonException("反射创建对象时出现异常...");
        }
        return entity;
    }

}
