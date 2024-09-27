package org.top.springdemo.util;

import lombok.Setter;

import java.util.regex.Pattern;

public class EmailValidatorImp implements EmailValidator {
    @Setter
    private Pattern validationPattern;

    @Override
    public boolean validate(String email) {
        return validationPattern.matcher(email).matches();
    }
}
