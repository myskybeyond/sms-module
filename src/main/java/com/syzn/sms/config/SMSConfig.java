package com.syzn.sms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *  sms 短信服务器及相关设置
 */
@Configuration
@ConfigurationProperties(prefix = "sms")
public class SMSConfig {
    private String provider;
    private String accessKey;
    private String secretKey;
    private int validSeconds = 1200;
    private int sendInterval = 120;
    private int maxSendsPerDay = 5;

    private Boolean enable;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public int getValidSeconds() {
        return validSeconds;
    }

    public void setValidSeconds(int validSeconds) {
        this.validSeconds = validSeconds;
    }

    public int getSendInterval() {
        return sendInterval;
    }

    public void setSendInterval(int sendInterval) {
        this.sendInterval = sendInterval;
    }

    public int getMaxSendsPerDay() {
        return maxSendsPerDay;
    }

    public void setMaxSendsPerDay(int maxSendsPerDay) {
        this.maxSendsPerDay = maxSendsPerDay;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
