package com.howard.service.response;

import com.howard.domain.Email;

public class SignUpResponse {
    private final Email email;

    public SignUpResponse(Email email) {
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }
}
