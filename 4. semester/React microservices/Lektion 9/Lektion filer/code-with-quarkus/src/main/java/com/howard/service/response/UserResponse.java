package com.howard.service.response;

import com.howard.domain.User;

public class UserResponse {
    private final User user;

    public UserResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
