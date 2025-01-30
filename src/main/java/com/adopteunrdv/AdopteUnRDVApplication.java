package com.adopteunrdv;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdopteUnRDVApplication {

    @Value("${config.file}")
    private String configFile;

    public static void main(String[] args) {
        SpringApplication.run(AdopteUnRDVApplication.class, args);
    }

    @Bean
    public boolean isEditableMode() {
        return configFile == null || configFile.isEmpty();
    }
}
