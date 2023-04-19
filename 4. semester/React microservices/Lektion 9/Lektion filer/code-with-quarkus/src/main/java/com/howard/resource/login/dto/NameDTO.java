package com.howard.resource.login.dto;

import com.howard.domain.Name;

public class NameDTO {
    private final String firstName;
    private final String lastName;

    public NameDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Name toName() {
        return new Name(firstName, lastName);
    }
}
