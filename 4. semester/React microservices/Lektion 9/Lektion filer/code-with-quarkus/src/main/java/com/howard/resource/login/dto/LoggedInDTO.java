package com.howard.resource.login.dto;

public class LoggedInDTO {
    private final boolean loggedIn;
    private final String userName;
    private final String gender;

    public LoggedInDTO(boolean loggedIn, String userName, String gender) {
        this.loggedIn = loggedIn;
        this.userName = userName;
        this.gender = gender;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getUserName() {
        return userName;
    }

    public String getGender() {
        return gender;
    }
}
