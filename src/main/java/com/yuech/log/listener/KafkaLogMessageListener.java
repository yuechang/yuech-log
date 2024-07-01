/* Copyright © 2022 Yuech and/or its affiliates. All rights reserved. */
package com.yuech.log.listener;

import com.yuech.log.handler.LogHandlerChainProcessor;
import com.yuech.log.model.AccessLogRequest;
import com.yuech.log.utils.JacksonUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * kafka消息监听者
 *
 * @author Yuech
 * @version 1.0
 * @date 2024-06-23 08:53
 */
@Component
@Slf4j
public class KafkaLogMessageListener {

    @Resource
    private LogHandlerChainProcessor logHandlerChainProcessor;

    /**
     * 通过注解注入所在的消费组和药监听的Topic
     *
     * @param record 消息记录
     * @param ack    ACK对象
     * @param topic  主题
     */
    @KafkaListener(topics = "${kafka.log.topic.name}", groupId = "${kafka.log.group.id}", concurrency = "1")
    public void topicTest(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {

        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            try {
                // 写入日志
                AccessLogRequest request = JacksonUtils.parse((String)msg, AccessLogRequest.class);
                logHandlerChainProcessor.processor(request);
                // 手动ACK
                ack.acknowledge();
                log.info("Kafka 日志消费成功! Topic:" + topic + ",Message:" + msg);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Kafka 日志消费失败！Topic:" + topic + ",Message:" + msg, e);
            }
        }
    }
}
