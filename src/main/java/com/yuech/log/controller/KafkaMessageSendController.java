/* Copyright © 2022 Yuech and/or its affiliates. All rights reserved. */
package com.yuech.log.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * kafka消息发送Controller
 *
 * @author Yuech
 * @version 1.0
 * @date 2024-06-23 08:52
 */
@RestController
@RequestMapping("/kafka")
public class KafkaMessageSendController {

    @Value("${kafka.topic.name}")
    private String topicName;

    @Value("${kafka.log.topic.name}")
    private String logTopicName;

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;


    @PostMapping("/sendMessage")
    public String sendMessage(@RequestBody String jsonString) {
        kafkaTemplate.send(topicName, jsonString);
        return "Kafka Message Send OK!";
    }

    @PostMapping("/sendLogMessage")
    public String sendLogMessage(@RequestBody String jsonString) {
        kafkaTemplate.send(logTopicName, jsonString);
        return "Kafka Log Message Send OK!";
    }

}
