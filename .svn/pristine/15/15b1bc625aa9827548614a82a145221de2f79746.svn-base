package com.xy.wwoa.common.util;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/2
 * @Time 10:45
 */
public class CommonUtil {

    private CommonUtil() {
    }

    public static String fillNull(String str) {
        return StringUtils.isEmpty(str) ? "无" : str;
    }

    public static String convertListToString(List<?> list) {
        String str = "";
        for (Object o : list) {
            str += o + ",";
        }
        return str.length() > 0 ? str.substring(0, str.length() - 1) : str;
    }

    public static String removeEndMark(String str) {
        return str.length() > 0 ? str.substring(0, str.length() - 1) : str;
    }

    /**
     * 将字符串按逗号切割成数组
     *
     * @param str
     * @return
     */
    public static String[] splitCommaForGetArray(String str) {
        return StringUtils.isEmpty(str) ? new String[0] : str.split(",");
    }

    public static List<String> splitCommaForGetList(String str) {
        return StringUtils.isEmpty(str) ? Collections.emptyList() : Arrays.asList(str.split(","));
    }

}
