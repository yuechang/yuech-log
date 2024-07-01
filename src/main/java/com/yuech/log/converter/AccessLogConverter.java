/* Copyright © 2022 Yuech and/or its affiliates. All rights reserved. */
package com.yuech.log.converter;

import com.yuech.log.entity.AccessLog;
import com.yuech.log.model.AccessLogRequest;
import com.yuech.log.utils.DateUtils;

import java.util.Date;

/**
 * 基础日志转化器
 *
 * @author Yuech
 * @version 1.0
 * @date 2024-06-23 18:18
 */
public class AccessLogConverter {


    /**
     * 日志dto对象 转 do对象
     *
     * @param request 请求参数
     * @return do对象
     */
    public static AccessLog dto2do(AccessLogRequest request) {

        AccessLog accessLog = new AccessLog();
        accessLog.setDataId(request.getDataId());
        accessLog.setType(request.getType().getCode());
        accessLog.setRequestParameter(request.getRequestParameter());
        accessLog.setResponseResult(request.getResponseResult());
        accessLog.setCost(request.getCost());
        accessLog.setTime(DateUtils.getDate(request.getTime()));
        accessLog.setCreateOwner(request.getOperator());
        accessLog.setCreateTime(new Date());
        return accessLog;
    }
}
