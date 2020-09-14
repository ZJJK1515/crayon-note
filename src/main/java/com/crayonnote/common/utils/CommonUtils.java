package com.crayonnote.common.utils;

public class CommonUtils {

    public static String getClassPath() {
        return CommonUtils.class.getResource("/").getPath();
    }

}
