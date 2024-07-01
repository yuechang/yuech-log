package com.yuech.log.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuech.log.entity.AccessLog;
import com.yuech.log.service.AccessLogService;
import com.yuech.log.mapper.AccessLogMapper;
import org.springframework.stereotype.Service;

/**
 * 操作日志表ServiceImpl
 *
 * @author Yuech
 * @version 1.0
 * @date 2024-06-23 16:40:50
 */
@Service
public class AccessLogServiceImpl extends ServiceImpl<AccessLogMapper, AccessLog>
        implements AccessLogService {

}




