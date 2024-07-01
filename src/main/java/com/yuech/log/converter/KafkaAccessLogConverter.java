/* Copyright © 2022 Yuech and/or its affiliates. All rights reserved. */
package com.yuech.log.converter;

import com.yuech.log.entity.KafkaAccessLog;
import com.yuech.log.model.AccessLogRequest;
import com.yuech.log.utils.DateUtils;

import java.util.Date;

/**
 * kafka日志转化器
 *
 * @author Yuech
 * @version 1.0
 * @date 2024-06-23 18:18
 */
public class KafkaAccessLogConverter {


    /**
     * kafka日志dto对象 转 do对象
     *
     * @param request 请求参数
     * @return do对象
     */
    public static KafkaAccessLog dto2do(AccessLogRequest request) {

        KafkaAccessLog kafkaAccessLog = new KafkaAccessLog();
        kafkaAccessLog.setDataId(request.getDataId());
        kafkaAccessLog.setType(request.getType().getCode());
        kafkaAccessLog.setRequestParameter(request.getRequestParameter());
        kafkaAccessLog.setResponseResult(request.getResponseResult());
        kafkaAccessLog.setCost(request.getCost());
        kafkaAccessLog.setTime(DateUtils.getDate(request.getTime()));
        kafkaAccessLog.setCreateOwner(request.getOperator());
        kafkaAccessLog.setCreateTime(new Date());
        return kafkaAccessLog;
    }
}
