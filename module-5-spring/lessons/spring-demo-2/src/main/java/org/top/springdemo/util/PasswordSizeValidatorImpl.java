package org.top.springdemo.util;

import lombok.Builder;
import lombok.Setter;

@Builder
public class PasswordSizeValidatorImpl implements PasswordValidator{
    @Setter
    private int passwordSize;

    @Override
    public boolean validate(String password) {
        if (password.length() < passwordSize) {
            System.out.println("Password size is too small");
            return false;
        }
        return true;
    }
}
