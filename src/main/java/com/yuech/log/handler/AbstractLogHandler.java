/* Copyright © 2022 Yuech and/or its affiliates. All rights reserved. */
package com.yuech.log.handler;

import com.yuech.log.model.AccessLogRequest;

/**
 * 抽象请求日志拦截器
 *
 * @author Yuech
 * @version 1.0
 * @date 2024-06-23 17:01
 */
public abstract class AbstractLogHandler {


    /**
     * 记录日志
     *
     * @param request 请求参数
     * @return 记录结果
     */
    public abstract boolean doRecordLog(AccessLogRequest request);
}
