package com.syzn.sms.job.task.bean.mp;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 值日排班提醒模版
 *
 * @author Jiantao Li
 * @date 2019/4/25 15:11
 */
@Data
@NoArgsConstructor
public class DutyNoticeTemplateBean extends BaseTemplateBean {

    public static final String TEMPLATE_ID = "TJ7OD1X7uq5SSW5NGhdZV28vVh0o_duBh8umasbID1w";

    /**
     * 值日员工
     */
    private String dutyEmployeeName;
    private String dutyAreaName;
    private Date dutyDate;
    /**
     * 预留手机号
     */
    private String mobile;

    private String email;

    @Override
    public String getTemplateId() {
        return TEMPLATE_ID;
    }

    public DutyNoticeTemplateBean(Date dutyDate,String dutyAreaName,String dutyEmployeeName,String email,String mobile,String weChat){
        this.dutyDate = dutyDate;
        this.dutyAreaName = dutyAreaName;
        this.dutyEmployeeName = dutyEmployeeName;
        this.email = email;
        this.mobile = mobile;
        super.setAppId(weChat);
    }
}
