package org.top.ShopCatalog.util;

import lombok.Setter;

import java.util.regex.Pattern;

@Setter
public class WebLinkValidatorImpl implements StringValidator {

    private Pattern validationPattern;
    @Override
    public boolean validate(String weblink) {
        return validationPattern.matcher(weblink).matches();
    }
}
