package com.xy.wwoa.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xy.wwoa.common.exception.JSONException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * JSON解析工具类
 */
@Slf4j
public class JSONUtil {

    private final static ObjectMapper objectMapper;

    static {
        objectMapper = SpringBeanUtil.getBean(ObjectMapper.class);
    }

    /**
     * 对象转json
     *
     * @param object
     * @return
     */
    public static String toJsonString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json转换换成对象
     *
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T parseObject(String json, Class<T> clazz) {
        T result = null;
        try {
            if (json != null) {
                result = objectMapper.readValue(json, clazz);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("json字符串: {}, 转换的类型: {}", json, clazz);
            throw new JSONException();
        }
        return result;
    }

    /**
     * json转换成集合
     *
     * @param json
     * @param clazz
     * @return
     */
    public static <T> List<T> parseArray(String json, Class<T> clazz) {
        List<T> result = new ArrayList<T>();
        try {
            List<Map<String, Object>> list = objectMapper.readValue(json, new TypeReference<List<T>>() {
            });
            for (Map<String, Object> one : list) {
                result.add(map2object(one, clazz));
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("json字符串: {}, 转换的类型: {}", json, clazz);
            throw new JSONException();
        }
        return result;
    }

    public static <T> T map2object(Map<String, Object> map, Class<T> clazz) {
        return objectMapper.convertValue(map, clazz);
    }
}
