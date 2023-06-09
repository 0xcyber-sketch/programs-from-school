package com.lange.resources.login.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginDTO {

    private final String userName;
    private final String password;

    @JsonCreator
    public LoginDTO(@JsonProperty("credentials") String userName,@JsonProperty("password") String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
