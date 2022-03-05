package com.yangqiang.tukuserver.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "yq")
public class YamlConfig {

    private String website;

    private Cron cron;

    public Cron getCron() {
        return cron;
    }

    public void setCron(Cron cron) {
        this.cron = cron;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}

