/* Copyright © 2022 Yuech and/or its affiliates. All rights reserved. */
package com.yuech.log.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author Yuech
 * @version 1.0
 * @date 2024-06-23 20:43
 */
@Slf4j
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    public final static String DATE = "yyyy-MM-dd";
    public final static String DATE_SLASH = "yyyy/MM/dd";
    public final static String DATE_CHINESE = "yyyy年MM月dd日";

    public final static String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_TIME_HOURS = "yyyy-MM-dd HH";
    public final static String DATE_TIME_MINUTES = "yyyy-MM-dd HH:mm";
    public final static String DATE_TIME_SLASH = "yyyy/MM/dd HH:mm:ss";
    public final static String DATE_TIME_CHINESE = "yyyy年MM月dd日 HH时mm分ss秒";

    public final static String DATE_TIME_MILLION = "yyyy-MM-dd HH:mm:ss:SSS";

    public final static String YEAR = "yyyy";
    public final static String YEAR_TO_MONTH = "yyyyMM";
    public final static String YEAR_TO_DATE = "yyyyMMdd";
    public final static String YEAR_TO_SECOND = "yyyyMMddHHmmss";
    public final static String YEAR_TO_MILLION = "yyyyMMddHHmmssSSS";

    /**
     * 将日期串转化为日期对象
     *
     * @param dateStr 日期格式串
     * @return 日期对象
     */
    public static Date getDate(String dateStr) {

        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        Date date = null;
        try {
            date = parseDate(dateStr,
                    DATE, DATE_SLASH, DATE_CHINESE,
                    DATE_TIME, DATE_TIME_HOURS, DATE_TIME_MINUTES, DATE_TIME_SLASH, DATE_TIME_CHINESE,
                    DATE_TIME_MILLION,
                    YEAR, YEAR_TO_MONTH, YEAR_TO_DATE, YEAR_TO_SECOND, YEAR_TO_MILLION);
        } catch (ParseException e) {
            log.error("日期:[" + dateStr + "]转化异常", e);
        }
        return date;
    }
}
