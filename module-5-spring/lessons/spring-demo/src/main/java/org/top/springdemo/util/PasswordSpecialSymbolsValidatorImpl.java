package org.top.springdemo.util;

public class PasswordSpecialSymbolsValidatorImpl implements PasswordValidator {
    private final String specialSymbols = "$#<>:\"';%^~`*(){}[]";
    @Override
    public boolean validate(String password) {
        if ((password.contains("?") && password.contains("$"))) {
            System.out.println("Special symbols are forbidden");
            return false;
        }
        return true;
    }
}
