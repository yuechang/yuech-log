/* Copyright © 2022 Yuech and/or its affiliates. All rights reserved. */
package com.yuech.log.handler;

import com.yuech.log.converter.ReturnAccessLogConverter;
import com.yuech.log.eunms.LogTypeEnum;
import com.yuech.log.model.AccessLogRequest;
import com.yuech.log.service.ReturnAccessLogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 退货日志处理器
 *
 * @author Yuech
 * @version 1.0
 * @date 2024-06-23 18:10
 */
@Component(value = "returnLogHandler")
public class ReturnLogHandler extends AbstractLogHandler {

    @Resource
    private ReturnAccessLogService returnAccessLogService;

    @Override
    public boolean doRecordLog(AccessLogRequest request) {
        return returnAccessLogService.save(ReturnAccessLogConverter.dto2do(request));
    }

    @Override
    public boolean support(LogTypeEnum logType) {
        return LogTypeEnum.RETURN_LOG.equals(logType);
    }
}
