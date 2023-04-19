package com.howard.domain;

import io.quarkus.elytron.security.common.BcryptUtil;

public class Password {
    private final String value;

    public Password(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getHash() {
        return BcryptUtil.bcryptHash(this.value);
    }
}
