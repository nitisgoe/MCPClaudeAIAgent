package com.example.mcp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JsonUtils {

    private final ObjectMapper objectMapper;

    public JsonUtils() {
        this.objectMapper = new ObjectMapper();
    }

    public JsonNode parse(String jsonString) {
        try {
            return objectMapper.readTree(jsonString);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON: " + e.getMessage(), e);
        }
    }

    public JsonNode getNode(JsonNode root, String... paths) {
        JsonNode current = root;
        for (String path : paths) {
            current = current.path(path);
        }
        return current;
    }
}

