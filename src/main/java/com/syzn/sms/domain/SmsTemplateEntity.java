package com.syzn.sms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Objects;

/**
 * @author JianTao Li
 */
@TableName(value = "t_sms_template",schema = "sms")
public class SmsTemplateEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Integer smsTemplateId;
    private String templateCode;
    private String smsUsage;
    private String signName;
    private String smsTemplate;
    private String enabled;

    public int getSmsTemplateId() {
        return smsTemplateId;
    }

    public void setSmsTemplateId(int smsTemplateId) {
        this.smsTemplateId = smsTemplateId;
    }


    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }


    public String getSmsUsage() {
        return smsUsage;
    }

    public void setSmsUsage(String smsUsage) {
        this.smsUsage = smsUsage;
    }


    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }


    public String getSmsTemplate() {
        return smsTemplate;
    }

    public void setSmsTemplate(String smsTemplate) {
        this.smsTemplate = smsTemplate;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmsTemplateEntity that = (SmsTemplateEntity) o;
        return smsTemplateId == that.smsTemplateId && Objects.equals(templateCode, that.templateCode) && Objects.equals(smsUsage, that.smsUsage) && Objects.equals(signName, that.signName) && Objects.equals(smsTemplate, that.smsTemplate) && Objects.equals(enabled, that.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(smsTemplateId, templateCode, smsUsage, signName, smsTemplate, enabled);
    }
}
