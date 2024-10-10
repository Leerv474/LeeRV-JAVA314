package org.top.springdemo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "passwordSizeValidator")
public class PasswordSizeValidatorImpl implements PasswordValidator{
    private int passwordSize;

    @Value(value = "${passwordSizeValidator.passwordSize}")
    public void setPasswordSize(int passwordSize) {
        this.passwordSize = passwordSize;
    }

    @Override
    public boolean validate(String password) {
        if (password.length() < passwordSize) {
            System.out.println("Password size is too small");
            return false;
        }
        return true;
    }
}
