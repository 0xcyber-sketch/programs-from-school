package com.howard.resource.login.dto;

import com.howard.service.request.LoginRequest;

public class LoginDTO {
    private final String credential;
    private final String password;

    public LoginDTO(String credential, String password) {
        this.credential = credential;
        this.password = password;
    }

    public LoginRequest toLoginRequest() {
        return new LoginRequest(credential, password);
    }
}
