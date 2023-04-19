package com.howard.domain.security;

public class JWTToken {
    private final String token;
    private final String userName;
    private final String gender;

    public JWTToken(String token, String userName, String gender) {
        this.token = token;
        this.userName = userName;
        this.gender = gender;
    }

    public String getToken() {
        return token;
    }

    public String getUserName() {
        return userName;
    }

    public String getGender() {
        return gender;
    }
}
