### yuech-log 统一日志收集


- 1、通过kafka解耦日志存储，日志生产端仅需发送kafka消息
``` text
KafkaSenderConfig配置 --> kafka消息生成者 --> KafkaMessageSendController#sendLogMessage
kafka消费者 --> KafkaLogMessageListener 
```


- 2、使用责任链模式收集kafka消息
``` text
基础业务日志处理器 --> kafka日志处理器  --> 退货日志处理器      --> ...
AccessLogHandler --> KafkaLogHandler --> ReturnLogHandler  --> ...
```
