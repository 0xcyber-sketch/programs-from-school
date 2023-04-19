package com.lange.domain;

import com.lange.domain.exception.DomainValidation;

import java.util.Objects;

public class Email {
    private final String value;

    public Email(String email) throws  DomainValidation{

        this.value = email;
        vailditate();
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private void vailditate() throws DomainValidation {

        if (!this.value.contains("@")) {
            throw new DomainValidation("Fejl");
        }
        }

}
