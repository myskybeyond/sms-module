package com.syzn.sms.service;

import cn.hutool.json.JSONUtil;
import com.syzn.sms.domain.SmsSendEntity;
import com.syzn.sms.domain.SmsTemplateEntity;
import com.syzn.sms.exception.SmszsBaseException;
import com.syzn.sms.service.sms.SmsSendLogService;
import com.syzn.sms.service.sms.SmsTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Map;

/**
 * @description:
 * @author: JianTao Li
 * @time: 2023/6/19 17:52
 * @email: myskybeyond@gmail.com
 */
@Service
@Slf4j
public class SmsSendService {

    /**
     * 是否使用-是
     */
    private final static String SMS_USED_YES = "Y";
    /**
     * 是否使用-是
     */
    private final static String SMS_USED_NO = "N";

    private final SmsService smsService;

    private final SmsSendLogService smsSendLogService;
    private final SmsTemplateService smsTemplateService;

    public SmsSendService(SmsService smsService,
                          SmsSendLogService smsSendLogService,
                          SmsTemplateService smsTemplateService) {
        this.smsService = smsService;
        this.smsSendLogService = smsSendLogService;
        this.smsTemplateService = smsTemplateService;
    }

    public SmsSendEntity sendSms(Long orgId, String smsUsage, String phoneNumber, Map<String, String> smsVariableMap) throws SmszsBaseException {
        try {

            SmsSendEntity sysSmsSendEntity = new SmsSendEntity();
//            String smsVariable = objectMapper.writeValueAsString(smsVariableMap);
            String smsVariable = JSONUtil.toJsonStr(smsVariableMap);
            sysSmsSendEntity.setSmsVariable(smsVariable);
            sysSmsSendEntity.setSmsUsage(smsUsage);
            sysSmsSendEntity.setMobile(phoneNumber);
            sysSmsSendEntity.setIsUsed(SMS_USED_YES);
            sysSmsSendEntity.setOrgId(orgId);
            sysSmsSendEntity.setSendTime(new Timestamp(System.currentTimeMillis()));
            SmsTemplateEntity sysSmsTempEntity = smsTemplateService.findOneBySmsUsage(smsUsage);
            smsSendLogService.save(sysSmsSendEntity);
            boolean sendStat = smsService.sendSMS(sysSmsTempEntity, sysSmsSendEntity);
            smsSendLogService.saveOrUpdate(sysSmsSendEntity);
            if (sendStat) {
                return sysSmsSendEntity;
            } else if ("isv.MOBILE_NUMBER_ILLEGAL".equals(sysSmsSendEntity.getSendCode())) {
                throw new SmszsBaseException("验证码发送失败！手机号码无效。");
            } else {
                throw new SmszsBaseException("验证码发送失败！");
            }
        } catch (Exception ex) {
            log.warn("短信发送异常:{}", ex);
            throw new SmszsBaseException("短信息发送失败！");
        }
    }

}
