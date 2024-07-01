/* Copyright © 2022 Yuech and/or its affiliates. All rights reserved. */
package com.yuech.log.handler;

import com.yuech.log.converter.KafkaAccessLogConverter;
import com.yuech.log.eunms.AccessLogTypeEnum;
import com.yuech.log.model.AccessLogRequest;
import com.yuech.log.service.KafkaAccessLogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * kafka日志处理器
 *
 * @author Yuech
 * @version 1.0
 * @date 2024-06-23 18:10
 */
@Component(value = "kafkaLogHandler")
public class KafkaLogHandler extends AbstractLogHandler {

    @Resource
    private KafkaAccessLogService kafkaAccessLogService;

    @Override
    public boolean doRecordLog(AccessLogRequest request) {
        if (AccessLogTypeEnum.KAFKA_LOG.equals(request.getType())) {
            return kafkaAccessLogService.save(KafkaAccessLogConverter.dto2do(request));
        }
        return true;
    }
}
