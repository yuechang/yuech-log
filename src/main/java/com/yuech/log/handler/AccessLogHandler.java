/* Copyright © 2022 Yuech and/or its affiliates. All rights reserved. */
package com.yuech.log.handler;

import com.yuech.log.converter.AccessLogConverter;
import com.yuech.log.eunms.AccessLogTypeEnum;
import com.yuech.log.model.AccessLogRequest;
import com.yuech.log.service.AccessLogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 基础业务日志处理器
 *
 * @author Yuech
 * @version 1.0
 * @date 2024-06-23 18:10
 */
@Component(value = "accessLogHandler")
public class AccessLogHandler extends AbstractLogHandler {

    @Resource
    private AccessLogService accessLogService;

    @Override
    public boolean doRecordLog(AccessLogRequest request) {

        if (AccessLogTypeEnum.ACCESS_LOG.equals(request.getType())) {
            return accessLogService.save(AccessLogConverter.dto2do(request));
        }
        return true;
    }
}
