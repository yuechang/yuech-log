### yuech-log 统一日志收集

@startuml
box kafka消息生产

participant "用户/应用" as UserOrSystem
participant Controller as KafkaMessageSendController
participant "kafka生产者" as Producer

activate Producer
Producer --> Producer: KafkaSenderConfig
deactivate Producer


activate UserOrSystem
UserOrSystem --> KafkaMessageSendController: sendLogMessage
deactivate UserOrSystem


activate KafkaMessageSendController
KafkaMessageSendController --> Producer: 发送消息
deactivate KafkaMessageSendController

end box


participant "Kafka" as Kafka

Producer --> Kafka: 发送消息


box kafka消息消费
participant "kafka消费者" as Consumer
participant Listener as KafkaLogMessageListener

Kafka --> Consumer: 消费消息
Consumer --> KafkaLogMessageListener: 处理消息

participant ChainProcessor as LogHandlerChainProcessor

KafkaLogMessageListener --> LogHandlerChainProcessor:

activate LogHandlerChainProcessor

loop 实际记录日志
LogHandlerChainProcessor --> LogHandlerChainProcessor: 遍历AbstractLogHandler实例列表
LogHandlerChainProcessor --> AccessLogHandler: 记录基础业务日志
AccessLogHandler --> KafkaLogHandler: 记录kafka日志
KafkaLogHandler --> ReturnLogHandler: 退货日志处理器
end loop

deactivate LogHandlerChainProcessor

end box
@enduml
