package com.example.mcp;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class HttpClientHelper {

    private final RestClient restClient;

    public HttpClientHelper(RestClient restClient) {
        this.restClient = restClient;
    }

    public String get(String endpoint) {
        return restClient.get()
                .uri(endpoint)
                .retrieve()
                .body(String.class);
    }
}

