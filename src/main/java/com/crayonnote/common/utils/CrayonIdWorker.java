package com.crayonnote.common.utils;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * ID 生成工具类
 */
public class CrayonIdWorker extends IdWorker {

    /**
     * 生成 Long ID
     *
     * @return id
     */
    public static Long nextId() {
        return IdWorker.getId();
    }

    /**
     * 生成 String ID
     *
     * @return id
     */
    public static String nextIdStr() {
        return IdWorker.getIdStr();
    }

}
