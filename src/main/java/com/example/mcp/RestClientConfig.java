package com.example.mcp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Value("${weather.api.base-url}")
    private String baseUrl;

    @Value("${weather.api.user-agent}")
    private String userAgent;

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Accept", "application/geo+json")
                .defaultHeader("User-Agent", userAgent)
                .build();
    }
}

