package com.adopteunrdv.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Service
public class ConfigService {

    @Value("classpath:${config.file}")
    private Resource configFile;

    private Map<String, Object> config;

    public Map<String, Object> getConfig() {
        if (config == null) {
            loadConfig();
        }
        return config;
    }

    private void loadConfig() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = configFile.getInputStream()) {
            config = objectMapper.readValue(inputStream, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
