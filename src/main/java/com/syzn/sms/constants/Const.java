package com.syzn.sms.constants;

/**
 * 全局常量
 */
public class Const {
    /**
     * 手机号校验正则表达式
     */
    //        String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9])|(19[0-9]))\\d{8}$";
    public static final String REGEX_MOBILE = "^(1[0-9]{2})\\d{8}$";

    /**
     * 考勤查询
     */
    public static final String ATTEND_MODULE = "org.query.attend.days";

    /**
     * 统计考勤查询
     */
    public static final String TOTAL_ATTEND_MODULE = "org.query.total.attend.days";
    /**
     * 统计缴费查询
     */
    public static final String TOTAL_PAY_MODULE = "org.query.total.pay.days";

    /**
     * 考勤查询开关
     */
    public static final String ADD_ATTEND_FLAG = "org.add.attend.flag";

    /**
     * 课程余额提醒阈值
     */
    public static final String COURSE_REMAIN_THRESHOLDS = "org.remain.course.balance%";

    /**
     * 上课提醒时间
     * -默认提前1天
     */
    public static final String CLASS_REMAIN_BEFORE_DAYS = "org.remain.class.before.days";

    /**
     * 补课提醒时间
     * -默认提前1天
     */
    public static final String REPAIR_CLASS_REMAIN_BEFORE_DAYS = "org.remain.repair.class.before.days";


    /**
     * 定时任务状态
     *
     * @author chenshun
     * @email sunlightcs@gmail.com
     * @date 2016年12月3日 上午12:07:22
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
        NORMAL(0),
        /**
         * 暂停
         */
        PAUSE(1);

        private int value;

        ScheduleStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    }
