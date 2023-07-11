package com.syzn.sms.service;

import com.syzn.sms.domain.SmsSendEntity;
import com.syzn.sms.domain.SmsTemplateEntity;

/**
 * @description:
 * @author: JianTao Li
 * @time: 2023/6/19 11:11
 * @email: myskybeyond@gmail.com
 */
public interface SmsService {

    boolean sendSMS(SmsTemplateEntity sysSmsTempEntity, SmsSendEntity sysSmsSendEntity);
}
