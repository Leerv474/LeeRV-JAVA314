package org.top.springdemo.util;

import lombok.Builder;
import lombok.Setter;

import java.util.regex.Pattern;

@Builder
public class EmailValidatorImpl implements EmailValidator {
    @Setter
    private Pattern validationPattern;

    @Override
    public boolean validate(String email) {
        return validationPattern.matcher(email).matches();
    }
}
