package com.crayonnote.modules.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crayonnote.modules.common.exception.CrayonException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 抽象 VO 类

 * @param <VO>    VO 类型
 * @param <Entity> 实体类型
 * @author JYKingWY
 */
public abstract class AbstractVO<VO, Entity> extends CrayonObject {

    /**
     * 分页条件
     */
    private Page<VO> page;

    private Class<Entity> entityClass;

    /**
     * 将 vo 转成实体对象
     *
     * @return 实体对象
     */
    public Entity toEntity() {
        ParameterizedType parametclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = parametclass.getActualTypeArguments();
        entityClass = (Class<Entity>) actualTypeArguments[1];
        Entity entity;
        try {
            entity = entityClass.newInstance();
            super.copyPropertiesFrom(entity);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new CrayonException("反射创建对象时出现异常...");
        }
        return entity;
    }


}
