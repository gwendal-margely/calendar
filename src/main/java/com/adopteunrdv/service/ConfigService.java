package com.adopteunrdv.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Service
public class ConfigService {

    @Value("${config.file}")
    private String configFile;

    public Map<String, Object> getConfig() throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:" + configFile);
        String content = new String(resource.getInputStream().readAllBytes());
        return parseConfig(content);
    }

    private Map<String, Object> parseConfig(String content) {
        Map<String, Object> config = new HashMap<>();
        // Parse the JSON content and populate the config map
        return config;
    }

    public void saveConfig(String configName, Map<String, Object> config) throws IOException {
        String configPath = "src/main/resources/data/" + configName.toLowerCase() + "/" + configName + "_config.json";
        Files.createDirectories(Paths.get(configPath).getParent());
        Files.write(Paths.get(configPath), config.toString().getBytes());
    }
}
