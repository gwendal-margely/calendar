package com.adopteunrdv.config;

import com.adopteunrdv.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Autowired
    private ConfigService configService;

    @Autowired
    private Environment env;

    @Bean
    @Primary
    public DataSource dataSource() {
        Map<String, Object> config = configService.getConfig();
        Map<String, Object> dbConfig = (Map<String, Object>) config.get("database");

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl((String) dbConfig.get("url"));
        dataSource.setUsername((String) dbConfig.get("username"));
        dataSource.setPassword((String) dbConfig.get("password"));

        return dataSource;
    }
}
