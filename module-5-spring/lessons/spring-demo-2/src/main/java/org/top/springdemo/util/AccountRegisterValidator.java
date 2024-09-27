package org.top.springdemo.util;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public interface AccountRegisterValidator {
    public boolean isValid(String email, String password);
}
