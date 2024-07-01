/* Copyright © 2022 Yuech and/or its affiliates. All rights reserved. */
package com.yuech.log.converter;

import com.yuech.log.entity.ReturnAccessLog;
import com.yuech.log.model.AccessLogRequest;
import com.yuech.log.utils.DateUtils;

import java.util.Date;

/**
 * 退货日志转化器
 *
 * @author Yuech
 * @version 1.0
 * @date 2024-06-23 18:18
 */
public class ReturnAccessLogConverter {


    /**
     * 退货日志dto对象 转 do对象
     *
     * @param request 请求参数
     * @return do对象
     */
    public static ReturnAccessLog dto2do(AccessLogRequest request) {

        ReturnAccessLog returnAccessLog = new ReturnAccessLog();
        returnAccessLog.setDataId(request.getDataId());
        returnAccessLog.setType(request.getType().getCode());
        returnAccessLog.setRequestParameter(request.getRequestParameter());
        returnAccessLog.setResponseResult(request.getResponseResult());
        returnAccessLog.setCost(request.getCost());
        returnAccessLog.setTime(DateUtils.getDate(request.getTime()));
        returnAccessLog.setCreateOwner(request.getOperator());
        returnAccessLog.setCreateTime(new Date());
        return returnAccessLog;
    }
}
