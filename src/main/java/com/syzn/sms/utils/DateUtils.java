package com.syzn.sms.utils;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Week;

import java.util.Date;

/**
 * @description:
 * @author: JianTao Li
 * @time: 2023/6/19 15:34
 * @email: myskybeyond@gmail.com
 */
public class DateUtils {

    private final static String[] DAY_OF_WEEK_ARRAY = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};

    /**
     * 计算偏移后日期
     * @param offset 偏移天数
     * @return 日期数组
     */
    public static String[] getOffsetDays(int offset){
        String[] strArray = new String[offset];
        for (int i = 1; i <= offset; i++) {
            DateTime dateTime = cn.hutool.core.date.DateUtil.offsetDay(new Date(),i);
            String dateStr = cn.hutool.core.date.DateUtil.format(dateTime, DatePattern.NORM_DATE_FORMAT);
            strArray[i-1] = dateStr;
        }
        return strArray;
    }

    /**
     * 计算星期
     * @param date 日期
     * @return 星期一|星期二|...
     */
    public static String getDayOfWeek(Date date){
        int dayOfWeek = DateUtil.dayOfWeek(date);
        Week week = Week.of(dayOfWeek);
        return week.toChinese();
    }
}
