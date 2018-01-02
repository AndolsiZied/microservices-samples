package com.zandolsi.examples.ms.establishment.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class WebConfiguration {
    @Value("${welcome.message: default message}")
    private String message;

    public String message() {
        return message;
    }
}
