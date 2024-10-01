package org.top.springdemo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.top.springdemo.dao.AccountsDao;
import org.top.springdemo.dao.AccountsDaoImpl;
import org.top.springdemo.util.*;

import javax.sql.DataSource;
import java.util.regex.Pattern;

@PropertySource(value = "classpath:application.properties")
public class ApplicationConfig {
    private final Environment environment;

    @Autowired
    public ApplicationConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public PasswordValidator passwordValidator() {
        return PasswordSizeValidatorImpl.builder()
                .passwordSize(environment.getProperty("passwordValidator.passwordSize", Integer.class))
                .build();
    }

    @Bean
    public EmailValidator emailValidator() {
        return EmailValidatorImpl.builder()
                .validationPattern(environment.getProperty("emailValidator.validatorPattern", Pattern.class))
                .build();
    }

    @Bean
    public AccountsDao accountDao() {
        return new AccountsDaoImpl(dataSource());
    }

    @Bean
    public HikariConfig hikariConfig() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(environment.getProperty("database.url"));
        config.setUsername(environment.getProperty("database.username"));
        config.setPassword(environment.getProperty("database.password"));
        config.setDriverClassName(environment.getProperty("database.driverClassName"));
        config.setMaximumPoolSize(environment.getProperty("database.maximumPoolSize", Integer.class));
        return config;
    }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public AccountRegisterValidator accountRegisterValidator() {
        return new AccountRegisterValidatorImpl(emailValidator(), passwordValidator());
    }
}
