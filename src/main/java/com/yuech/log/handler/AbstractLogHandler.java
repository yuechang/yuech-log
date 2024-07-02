/* Copyright © 2022 Yuech and/or its affiliates. All rights reserved. */
package com.yuech.log.handler;

import com.yuech.log.eunms.LogTypeEnum;
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
     * 实际记录日志
     *
     * @param request 请求参数
     * @return 记录结果
     */
    public abstract boolean doRecordLog(AccessLogRequest request);


    /**
     * 记录日志
     *
     * @param request 请求参数
     * @return 记录结果
     */
    public boolean recordLog(AccessLogRequest request) {

        boolean recordResult = false;
        if (support(request.getType())) {
            recordResult = doRecordLog(request);
        }
        return recordResult;
    }

    /**
     * 是否为支持记录的类型
     * <br/>
     * 默认均不记录
     *
     * @param logType 日志类型
     * @return true:支持，false：不支持
     */
    public boolean support(LogTypeEnum logType) {
        return false;
    }

}
