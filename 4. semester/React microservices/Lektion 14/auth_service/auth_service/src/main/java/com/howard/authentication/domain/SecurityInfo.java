package com.howard.authentication.domain;

public class SecurityInfo {
    private final Id userId;
    private final Roles roles;
    private final UserName userName;


    public SecurityInfo(Id userId, UserName userName, Roles roles) {
        this.userId = userId;
        this.roles = roles;
        this.userName = userName;
    }

    public Id getUserId() {
        return userId;
    }

    public Roles getRoles() {
        return roles;
    }

    public UserName getUserName() {
        return userName;
    }
}
