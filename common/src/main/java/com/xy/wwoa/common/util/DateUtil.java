package com.xy.wwoa.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/3
 * @Time 18:31
 */
public class DateUtil {

    private DateUtil() {
    }

    private static final DateTimeFormatter YMD_HMS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String convertDateToString(LocalDateTime localDateTime) {
        return localDateTime == null ? "" : YMD_HMS.format(localDateTime);
    }

}
