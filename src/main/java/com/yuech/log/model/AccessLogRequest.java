/* Copyright © 2022 Yuech and/or its affiliates. All rights reserved. */
package com.yuech.log.model;

import com.yuech.log.eunms.LogTypeEnum;
import lombok.Data;

/**
 * 日志kafka报文参数对象
 *
 * @author Yuech
 * @version 1.0
 * @date 2024-06-23 10:05
 */
@Data
public class AccessLogRequest {

    /**
     * 数据ID
     */
    private String dataId;

    /**
     * 日志类型
     */
    private LogTypeEnum type;

    /**
     * 请求参数
     */
    private String requestParameter;

    /**
     * 响应结果
     */
    private String responseResult;

    /**
     * 耗时
     */
    private Integer cost;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 日志产生时间
     */
    private String time;
}
