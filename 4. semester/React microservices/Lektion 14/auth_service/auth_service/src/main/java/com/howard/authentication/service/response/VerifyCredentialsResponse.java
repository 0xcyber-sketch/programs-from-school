package com.howard.authentication.service.response;

import com.howard.authentication.domain.Id;
import com.howard.authentication.domain.JWTToken;

public class VerifyCredentialsResponse {
    private final JWTToken token;
    private final Id id;

    public VerifyCredentialsResponse(Id id, JWTToken jwtToken) {
        this.token = jwtToken;
        this.id = id;
    }

    public VerifyCredentialsResponse() {
        this.token = null;
        this.id = null;
    }


    public JWTToken getToken() {
        return token;
    }

    public Id getId() {
        return id;
    }

    public boolean isVerified() {
        return token != null;
    }
}
