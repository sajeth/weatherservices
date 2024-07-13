package com.weather.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RestConfig {
    @Value("${weather.endpoint}")
    private String url;

    @Bean
    public WebClient weatherClient() {
        return WebClient.builder().baseUrl(url).build();
    }
}
