package org.top.ShopCatalog.util;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ShopRegisterValidatorImpl implements ShopRegisterValidator {

    private final EmailValidatorImpl emailValidator;
    private final PhoneNumberValidatorImpl phoneNumberValidator;
    private final WebLinkValidatorImpl webLinkValidator;


    @Override
    public boolean isValid(String email, String phoneNumber, String weblink) {
        return emailValidator.validate(email) && phoneNumberValidator.validate(phoneNumber) && webLinkValidator.validate(weblink);
    }
}
