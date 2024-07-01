package com.yuech.log.mapper;

import com.yuech.log.entity.KafkaAccessLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * kafka操作日志表Mapper
 *
 * @author Yuech
 * @version 1.0
 * @date 2024-06-23 16:45:22
 */
@Mapper
public interface KafkaAccessLogMapper extends BaseMapper<KafkaAccessLog> {

}




