package com.howard.authentication.service.response;

import com.howard.authentication.domain.Credentials;

public class CreateCredentialsResponse {
    private final Credentials credentials;

    public CreateCredentialsResponse(Credentials credentials) {
        this.credentials = credentials;
    }

    public Credentials getCredentials() {
        return credentials;
    }
}
