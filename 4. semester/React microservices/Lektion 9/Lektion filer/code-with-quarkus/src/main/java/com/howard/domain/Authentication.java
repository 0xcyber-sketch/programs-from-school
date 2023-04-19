package com.howard.domain;

public class Authentication {
    private final UserName userName;
    private final Password password;

    public Authentication(UserName userName, Password password) {
        this.userName = userName;
        this.password = password;
    }

    public UserName getUserName() {
        return userName;
    }

    public Password getPassword() {
        return password;
    }
}
