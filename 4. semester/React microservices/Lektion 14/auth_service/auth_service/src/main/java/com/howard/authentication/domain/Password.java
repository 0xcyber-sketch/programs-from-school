package com.howard.authentication.domain;

import com.howard.authentication.domain.exception.DomainException;
import com.howard.authentication.domain.exception.Sid;

import java.util.regex.Pattern;

public class Password {
    private final Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$");
    private final String value;

    public Password(String value) throws DomainException {
        if (!pattern.matcher(value).matches()) {
            throw new DomainException(Sid.PASSWORD_VALIDATION_ERROR, "Password invalid");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
