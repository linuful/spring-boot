package com.example.demo.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@ConfigurationProperties(value = "amazon")
//@ConfigurationProperties(prefix = "amazon")
@ConfigurationProperties("amazon")
@Component
public class Configuration {

    private String associateId;

    public String getAssociateId() {
        return associateId;
    }

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }


}


