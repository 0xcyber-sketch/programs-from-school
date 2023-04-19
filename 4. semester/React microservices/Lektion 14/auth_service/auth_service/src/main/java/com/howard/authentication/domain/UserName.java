package com.howard.authentication.domain;

import com.howard.authentication.domain.exception.DomainException;
import com.howard.authentication.domain.exception.Sid;

public class UserName implements Credential {
    private final String value;

    public UserName(String value) throws DomainException {
        if (!isUserName(value)) {
            throw new DomainException(Sid.USERNAME_VALIDATION_ERROR, String.format("User name %s is not valid", value));
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isUserName(String value) {
        return !(value == null || value.trim().length() != value.length() || value.length() > 20 || value.contains("@"));
    }
}
