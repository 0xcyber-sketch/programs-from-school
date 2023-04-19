package com.howard.authentication.service.request;

import com.howard.authentication.domain.Email;
import com.howard.authentication.domain.Password;
import com.howard.authentication.domain.UserName;

public class CreateCredentialsRequest {
    private final Email email;
    private final UserName userName;
    private final Password password;

    public CreateCredentialsRequest(Email email, UserName userName, Password password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public Email getEmail() {
        return email;
    }

    public UserName getUserName() {
        return userName;
    }

    public Password getPassword() {
        return password;
    }
}
