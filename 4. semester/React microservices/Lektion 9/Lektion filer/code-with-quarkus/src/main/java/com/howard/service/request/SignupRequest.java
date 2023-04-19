package com.howard.service.request;

import com.howard.domain.Email;
import com.howard.domain.Password;
import com.howard.domain.UserName;

public class SignupRequest {
    private final Email email;
    private final Password password;
    private final UserName userName;

    public SignupRequest(Email email, UserName userName, Password password) {
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    public UserName getUserName() {
        return userName;
    }
}
