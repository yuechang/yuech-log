/* Copyright © 2022 Yuech and/or its affiliates. All rights reserved. */
package com.yuech.log.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * jackson工具类
 *
 * @author Yuech
 * @version 1.0
 * @date 2024-06-23 21:48
 */
@Slf4j
public class JacksonUtils<T> {

    /**
     * 对象Mapper
     */
    public static ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    /**
     * 将JSON串转化成对象
     *
     * @param json  JSON串
     * @param clazz 类名
     * @param <T>   类型
     * @return 对象
     */
    public static <T> T parse(String json, Class<T> clazz) {

        if (StringUtils.isBlank(json)) {
            return null;
        }

        T t = null;
        try {
            t = OBJECT_MAPPER.readValue(json, clazz);
        } catch (Exception e ) {
            log.error("将字符串:[" + json + "]转对象异常", e);
        }
        return t;
    }

    /**
     * 将对象 转化成 JSON串
     *
     * @param object  对象
     * @return JSON串
     */
    public static String toJson(Object object) {

        if (object == null) {
            return StringUtils.EMPTY;
        }

        String json = StringUtils.EMPTY;
        try {
            json = OBJECT_MAPPER.writeValueAsString(object);
        } catch (Exception e ) {
            log.error("将对象:[" + object.toString() + "]转字符串异常", e);
        }
        return json;
    }

}
