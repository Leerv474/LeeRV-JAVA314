package org.top.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.top.springdemo.model.Account;
import org.top.springdemo.service.RegisterService;

public class Main {
    public static void main(String[] args) {
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
