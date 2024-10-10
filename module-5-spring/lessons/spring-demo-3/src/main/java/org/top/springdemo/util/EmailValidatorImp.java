package org.top.springdemo.util;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
@Builder
public class EmailValidatorImp implements EmailValidator {
    private Pattern validationPattern;


    public EmailValidatorImp(@Value("${emailValidator.validatorPattern}") Pattern validationPattern) {
        this.validationPattern = validationPattern;
    }

    @Override
    public boolean validate(String email) {
        return validationPattern.matcher(email).matches();
    }
}
