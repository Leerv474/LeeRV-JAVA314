package org.top.springdemo.config;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@PropertySource(value = "classpath:application.properties")
public class ApplicationConfig {
    private final Environment environment;

    @Autowired
    public ApplicationConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

}
