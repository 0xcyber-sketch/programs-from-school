package com.lange.service.responses;

import com.lange.domain.User;

public class SignupResponse {
    private final User user;


    public SignupResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
