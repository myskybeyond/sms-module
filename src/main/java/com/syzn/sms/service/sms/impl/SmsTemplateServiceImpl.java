package com.syzn.sms.service.sms.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syzn.sms.domain.SmsTemplateEntity;
import com.syzn.sms.mapper.SmsTemplateMapper;
import com.syzn.sms.service.sms.SmsTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @description:
 * @author: JianTao Li
 * @time: 2023/6/20 8:42
 * @email: myskybeyond@gmail.com
 */
@Service
public class SmsTemplateServiceImpl extends ServiceImpl<SmsTemplateMapper, SmsTemplateEntity> implements SmsTemplateService {
    @Override
    public SmsTemplateEntity findOneBySmsUsage(String smsUsage) {
        Assert.notNull(smsUsage,"短信用途参数空");
        return getOne(new QueryWrapper<SmsTemplateEntity>().eq("enabled","Y").eq("sms_usage",smsUsage),true);
    }
}
