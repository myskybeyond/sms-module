package com.syzn.sms.service.sms;

import com.baomidou.mybatisplus.extension.service.IService;
import com.syzn.sms.domain.SmsTemplateEntity;

/**
 * @description:
 * @author: JianTao Li
 * @time: 2023/6/20 8:42
 * @email: myskybeyond@gmail.com
 */
public interface SmsTemplateService extends IService<SmsTemplateEntity> {

    /**
     * 查找短信息模板
     * @param smsUsage 信息模板用途
     * @return
     */
    SmsTemplateEntity findOneBySmsUsage(String smsUsage);
}
