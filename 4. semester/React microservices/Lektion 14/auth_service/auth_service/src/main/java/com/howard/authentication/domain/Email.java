package com.howard.authentication.domain;

import com.howard.authentication.domain.exception.DomainException;
import com.howard.authentication.domain.exception.Sid;

import java.util.regex.Pattern;

public class Email implements Credential{
    private static final Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
    private final String value;

    public Email(String value) throws DomainException {
        if (!isEmail(value)) {
            throw new DomainException(Sid.EMAIL_VALIDATION_ERROR, String.format("Email %s is not valid", value));
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isEmail(String value) {
        return pattern.matcher(value).matches();
    }
}
