package com.syzn.sms.job.task.bean.mp;

import lombok.Data;

/**
 * 模版消息基类
 *
 * @author Jiantao Li
 * @date 2019/10/12 10:56
 */
@Data
public abstract class BaseTemplateBean {

    public abstract String getTemplateId();

    private Long orgId;
    private String orgName;
    private Long schoolId;
    private String schoolName;
    /**
     * toUser
     */
    private String appId;

}
