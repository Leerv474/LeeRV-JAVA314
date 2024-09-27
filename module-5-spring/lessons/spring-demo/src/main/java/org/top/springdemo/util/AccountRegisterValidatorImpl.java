package org.top.springdemo.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.regex.Pattern;

@RequiredArgsConstructor
public class AccountRegisterValidatorImpl implements AccountRegisterValidator {

    private final EmailValidator emailValidator;
    private final PasswordValidator passwordValidator;

    @Override
    public boolean isValid(String email, String password) {
        return passwordValidator.validate(password) && emailValidator.validate(email);
    }
}
