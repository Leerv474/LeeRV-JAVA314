package org.top.springdemo.service;

import lombok.RequiredArgsConstructor;
import org.top.springdemo.dao.AccountsDao;
import org.top.springdemo.model.Account;
import org.top.springdemo.util.AccountRegisterValidator;

@RequiredArgsConstructor
public class RegisterService {
    private final AccountRegisterValidator accountRegisterValidator;
    private final AccountsDao accountsDao;

    public void register(String email, String password) {
        if (!accountRegisterValidator.isValid(email, password)) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        accountsDao.save(Account.builder()
                .email(email)
                .password(password)
                .build());
        System.out.println("Registered successfully");
    }
}
