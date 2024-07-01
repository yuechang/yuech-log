/* Copyright © 2022 Yuech and/or its affiliates. All rights reserved. */
package com.yuech.log.handler;

import com.yuech.log.model.AccessLogRequest;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 请求日志责任链处理器
 *
 * @author Yuech
 * @version 1.0
 * @date 2024-06-23 17:15
 */
@Component
public class LogHandlerChainProcessor {

    @Resource
    private List<AbstractLogHandler> handlerChainList;

    public void processor(AccessLogRequest request) {

        if (request == null) {
            return;
        }
        for (AbstractLogHandler logHandler : handlerChainList) {
            logHandler.doRecordLog(request);
        }


    }
}
