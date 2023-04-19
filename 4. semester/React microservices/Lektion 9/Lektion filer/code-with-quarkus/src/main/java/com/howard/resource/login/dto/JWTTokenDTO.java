package com.howard.resource.login.dto;

import com.howard.service.response.LoginResponse;

public class JWTTokenDTO {
    private final String token;

    public JWTTokenDTO(LoginResponse loginResponse) {
        this.token = loginResponse.getToken().getToken();
    }

    public String getToken() {
        return token;
    }
}
