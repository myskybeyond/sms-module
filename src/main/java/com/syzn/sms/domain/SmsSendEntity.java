package com.syzn.sms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Timestamp;
import java.util.Objects;

@TableName(value = "t_sms_send",schema = "sms")
public class SmsSendEntity {
    @TableId(type = IdType.AUTO)
    private Integer smsSendId;
    private String mobile;
    private String smsUsage;
    private Timestamp sendTime;
    private String smsVariable;
    private String isUsed;
    private String requestId;
    private String sendCode;
    private String message;
    private String bizId;
    private Long orgId;

    public int getSmsSendId() {
        return smsSendId;
    }

    public void setSmsSendId(int smsSendId) {
        this.smsSendId = smsSendId;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public String getSmsUsage() {
        return smsUsage;
    }

    public void setSmsUsage(String smsUsage) {
        this.smsUsage = smsUsage;
    }


    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }


    public String getSmsVariable() {
        return smsVariable;
    }

    public void setSmsVariable(String smsVariable) {
        this.smsVariable = smsVariable;
    }


    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }


    public String getSendCode() {
        return sendCode;
    }

    public void setSendCode(String sendCode) {
        this.sendCode = sendCode;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }


    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmsSendEntity that = (SmsSendEntity) o;
        return smsSendId == that.smsSendId && Objects.equals(mobile, that.mobile) && Objects.equals(smsUsage, that.smsUsage) && Objects.equals(sendTime, that.sendTime) && Objects.equals(smsVariable, that.smsVariable) && Objects.equals(isUsed, that.isUsed) && Objects.equals(requestId, that.requestId) && Objects.equals(sendCode, that.sendCode) && Objects.equals(message, that.message) && Objects.equals(bizId, that.bizId) && Objects.equals(orgId, that.orgId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(smsSendId, mobile, smsUsage, sendTime, smsVariable, isUsed, requestId, sendCode, message, bizId, orgId);
    }
}
