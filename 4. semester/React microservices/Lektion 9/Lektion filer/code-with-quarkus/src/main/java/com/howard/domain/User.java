package com.howard.domain;

public class User {
    private final Id id;
    private final Email email;
    private final Password password;
    private final Roles roles;
    private Name name;
    private Gender gender;
    private UserName userName;


    public User(Id id, Email email, UserName userName, Password password, Roles roles, Name name, Gender gender) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
        this.name = name;
        this.gender = gender;
    }

    public Id getId() {
        return id;
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    public Roles getRoles() {
        return roles;
    }

    public Name getName() {
        return name;
    }

    public UserName getUserName() {
        return userName;
    }

    public Gender getGender() {
        return gender;
    }
}
