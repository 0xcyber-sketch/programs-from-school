package com.howard.resource.login.dto;

import com.howard.domain.User;

public class UserDTO {
    private final String id;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String gender;


    public UserDTO(User user) {
        this.id = user.getId().getRaw();
        this.email = user.getEmail().getValue();
        this.firstName = user.getName().getFirstName();
        this.lastName = user.getName().getLastName();
        this.gender = user.getGender().name();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
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
}
