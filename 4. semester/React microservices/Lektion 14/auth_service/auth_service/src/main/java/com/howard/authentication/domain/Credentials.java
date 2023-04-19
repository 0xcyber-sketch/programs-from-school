package com.howard.authentication.domain;

public class Credentials {
    private final Id id;
    private final Email email;
    private final UserName userName;
    private final Password password;
    private final Roles roles;

    public Credentials(Id id, Email email, UserName userName, Password password, Roles roles) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public Id getId() {
        return id;
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

    public Roles getRoles() {
        return roles;
    }
}
