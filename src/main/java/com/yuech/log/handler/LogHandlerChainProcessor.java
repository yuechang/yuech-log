/* Copyright © 2022 Yuech and/or its affiliates. All rights reserved. */
package com.yuech.log.handler;

import com.yuech.log.model.AccessLogRequest;
import com.yuech.log.utils.JacksonUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class LogHandlerChainProcessor {

    @Resource
    private List<AbstractLogHandler> handlerChainList;

    /**
     * 保存日志信息
     *
     * @param request 需保存日志信息
     */
    public void processor(AccessLogRequest request) {

        if (request == null) {
            return;
        }

        for (AbstractLogHandler logHandler : handlerChainList) {
            boolean recordResult = logHandler.recordLog(request);
            log.debug("log info : " + JacksonUtils.toJson(request) + ", record log result:" + recordResult);
        }
    }
}
