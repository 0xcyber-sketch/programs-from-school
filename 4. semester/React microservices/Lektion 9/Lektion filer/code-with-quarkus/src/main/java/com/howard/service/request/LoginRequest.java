package com.howard.service.request;

import com.howard.domain.Email;
import com.howard.domain.Password;
import com.howard.domain.UserName;

public class LoginRequest {
    private final Email email;
    private final UserName userName;
    private final Password password;


    public LoginRequest(String credential, String password) {
        if (credential.contains("@")) {
            this.email = new Email(credential);
            this.userName = null;
        } else {
            this.userName = new UserName(credential);
            this.email = null;
        }

        this.password = new Password(password);
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

    public boolean containsEmail() {
        return getEmail() != null;
    }
}
