package org.top.ShopCatalog.util;

import lombok.Setter;

import java.util.regex.Pattern;

@Setter
public class EmailValidatorImpl implements StringValidator {
    private Pattern validationPattern;

    @Override
    public boolean validate(String email) {
        return validationPattern.matcher(email).matches();
    }
}