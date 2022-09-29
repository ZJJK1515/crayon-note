package com.crayon.common.core.utils;

import java.util.Arrays;

public class StringUtils {

    /**
     *
     */
    public static String sqlToJavaStyle(String sqlTableName) {
        StringBuilder stringBuilder = new StringBuilder();
        sqlTableName = sqlTableName.replaceAll("__", "_");
        char[] chars = sqlTableName.toCharArray();
        int last_index = -1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '_') {
                last_index = i;
                continue;
            }
            stringBuilder.append((i - 1 == last_index && last_index != -1) ? Character.toUpperCase(c) : c);
        }
        return stringBuilder.toString();
    }

    /**
     *
     * @param sqlTableName sql列名或表名
     * @return 驼峰类型名称
     */
    public static String sqlToCamelStyle(String sqlTableName) {
        char[] chars = StringUtils.sqlToJavaStyle(sqlTableName).toCharArray();
        if (chars.length > 0) {
            chars[0] = Character.toUpperCase(chars[0]);
        }
        return String.valueOf(chars);
    }

    public static <T> String arrayToString(T[] arr) {
        return Arrays.toString(arr);
    }


}
