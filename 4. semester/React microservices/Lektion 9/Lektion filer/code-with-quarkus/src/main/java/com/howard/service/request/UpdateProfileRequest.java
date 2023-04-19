package com.howard.service.request;

import com.howard.domain.*;
import com.howard.resource.login.dto.UpdateProfileDTO;

public class UpdateProfileRequest {
    private final Id id;
    private final UserName userName;
    private final Email email;
    private final Name name;
    private final Gender gender;

    public UpdateProfileRequest(String id, UpdateProfileDTO dto) {
        this.id = new Id(id);
        this.userName = new UserName(dto.getUserName());
        this.email = new Email(dto.getEmail());
        this.name = new Name(dto.getFirstName(), dto.getLastName());
        this.gender = Gender.valueOf(dto.getGender());
    }

    public Id getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public UserName getUserName() {
        return userName;
    }

    public Email getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }
}
