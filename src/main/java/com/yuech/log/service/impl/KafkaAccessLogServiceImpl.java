package com.yuech.log.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuech.log.entity.KafkaAccessLog;
import com.yuech.log.service.KafkaAccessLogService;
import com.yuech.log.mapper.KafkaAccessLogMapper;
import org.springframework.stereotype.Service;

/**
 * kafka操作日志表ServiceImpl
 *
 * @author Yuech
 * @version 1.0
 * @date 2024-06-23 16:45:22
 */
@Service
public class KafkaAccessLogServiceImpl extends ServiceImpl<KafkaAccessLogMapper, KafkaAccessLog>
        implements KafkaAccessLogService {

}




