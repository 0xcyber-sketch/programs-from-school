package com.howard.authentication.service.response;

import com.howard.authentication.domain.Credentials;

import java.util.Optional;

public class GetCredentialsResponse {
    private final Optional<Credentials> credentials;

    public GetCredentialsResponse(Optional<Credentials> credentials) {
        this.credentials = credentials;
    }

    public Optional<Credentials> getCredentials() {
        return credentials;
    }
}
