package com.syzn.sms.job.task.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jiantao Li
 * @date 2019/9/6 17:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskParamBean {

    private Long orgId;
    /**
     * 允许发送短信息
     */
    private boolean allowSms;

    /**
     * 允许发送公众号模版消息
     */
    private boolean allowWpTemplateMsg;

    /**
     * 允许发送邮件  默认开启
     */
    private boolean allowMail;
}
