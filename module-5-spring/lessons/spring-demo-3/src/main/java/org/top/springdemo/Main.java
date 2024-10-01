package org.top.springdemo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.top.springdemo.dao.AccountsDaoImpl;
import org.top.springdemo.model.Account;
import org.top.springdemo.service.RegisterService;
import org.top.springdemo.util.AccountRegisterValidatorImpl;
import org.top.springdemo.util.EmailValidatorImp;
import org.top.springdemo.util.PasswordSizeValidatorImpl;

public class Main {
    public static void main(String[] args) {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("context.xml");
//        AccountsDaoImpl accountsDao = classPathXmlApplicationContext.getBean(AccountsDaoImpl.class);

        RegisterService registerService = classPathXmlApplicationContext.getBean(RegisterService.class);
//        new RegisterService(
//                new AccountRegisterValidatorImpl(
//                        new PasswordSizeValidatorImpl(),
//                        new EmailValidatorImp()),
//                new AccountsDaoImpl(
//                        new HikariDataSource(
//                                new HikariConfig("classpath:props.properties"))));
        Account account = Account.builder()
                .email("test@mail.com")
                .password("secret")
                .build();

        registerService.register(account.getEmail(), account.getPassword());

    }
}
