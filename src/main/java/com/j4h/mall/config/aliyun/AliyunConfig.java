package com.j4h.mall.config.aliyun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mall.aliyun")
public class AliyunConfig {
    String accessKeyId;
    String accessSecret;
    @Autowired
    MallOssConfig ossConfig;
    @Autowired
    SmsConfig smsConfig;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public MallOssConfig getOssConfig() {
        return ossConfig;
    }

    public void setOssConfig(MallOssConfig ossConfig) {
        this.ossConfig = ossConfig;
    }

    public SmsConfig getSmsConfig() {
        return smsConfig;
    }

    public void setSmsConfig(SmsConfig smsConfig) {
        this.smsConfig = smsConfig;
    }
}
