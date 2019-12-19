package com.example.demo.configurationFile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationProperties {

    public static String regionId;
    public static String regionKey;
    public static String secretKey;
    public static String tokenUrl;

    @Value("${gffp.regionId}")
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    @Value("${gffp.regionKey}")
    public void setRegionKey(String regionKey) {
        this.regionKey = regionKey;
    }

    @Value("${gffp.secretKey}")
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Value("${token.url}")
    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }
}
