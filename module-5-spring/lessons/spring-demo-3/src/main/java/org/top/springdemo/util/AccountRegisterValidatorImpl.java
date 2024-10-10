package org.top.springdemo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AccountRegisterValidatorImpl implements AccountRegisterValidator {

    private final EmailValidator emailValidator;
    private final PasswordValidator passwordValidator;

    @Autowired
    public AccountRegisterValidatorImpl(EmailValidator emailValidator, PasswordValidator passwordValidator) {
        System.out.println("EmailValidator: " + emailValidator);
        System.out.println("PasswordValidator: " + passwordValidator);
        this.emailValidator = emailValidator;
        this.passwordValidator = passwordValidator;
    }

    @Override
    public boolean isValid(String email, String password) {
        return passwordValidator.validate(password) && emailValidator.validate(email);
    }
}
