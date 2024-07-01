/* Copyright © 2022 Yuech and/or its affiliates. All rights reserved. */
package com.yuech.log.eunms;

import lombok.Getter;

/**
 * 日志类型枚举类
 *
 * @author Yuech
 * @version 1.0
 * @date 2024-06-23 10:06
 */
@Getter
public enum AccessLogTypeEnum {

    /**
     * kafka消息日志
     */
    KAFKA_LOG("KAFKA_LOG", "kafka消息"),

    /**
     * 访问日志
     */
    ACCESS_LOG("ACCESS_LOG", "访问日志"),

    /**
     * 退货日志
     */
    RETURN_LOG("RETURN_LOG", "退货日志"),

    ;

    /**
     * 枚举编码
     */
    private final String code;

    /**
     * 枚举描述
     */
    private final String desc;


    AccessLogTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
