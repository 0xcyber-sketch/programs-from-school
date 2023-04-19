package com.howard.resource.login.dto;

import com.howard.domain.User;

public class ProfileDTO {
    private final String userName;
    private final String firstName;
    private final String lastName;
    private final String gender;
    private final String email;

    public ProfileDTO(User user) {
        this.userName = user.getUserName().getValue();
        this.firstName = user.getName().getFirstName();
        this.lastName = user.getName().getLastName();
        this.gender = user.getGender().name();
        this.email = user.getEmail().getValue();
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }
}

