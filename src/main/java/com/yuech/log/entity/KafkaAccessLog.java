package com.yuech.log.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;


/**
 * kafka操作日志表
 *
 * @author Yuech
 * @version 1.0
 * @date 2024-06-23 16:06
 */
@TableName(value ="kafka_access_log")
@Data
public class KafkaAccessLog implements Serializable {

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 数据ID
     */
    private String dataId;

    /**
     * 数据类型
     */
    private String type;

    /**
     * 请求参数
     */
    private String requestParameter;

    /**
     * 响应结果
     */
    private String responseResult;

    /**
     * 耗时
     */
    private Integer cost;

    /**
     * 日志产生时间
     */
    private Date time;

    /**
     * 创建人
     */
    private String createOwner;

    /**
     * 创建时间
     */
    private Date createTime;

}