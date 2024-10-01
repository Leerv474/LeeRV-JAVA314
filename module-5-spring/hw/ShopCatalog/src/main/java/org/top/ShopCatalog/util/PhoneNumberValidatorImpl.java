package org.top.ShopCatalog.util;

import lombok.Setter;

import java.util.regex.Pattern;

@Setter
public class PhoneNumberValidatorImpl implements StringValidator {
    private Pattern validationPattern;

    @Override
    public boolean validate(String phoneNumber) {
        return validationPattern.matcher(phoneNumber).matches();
    }
}
