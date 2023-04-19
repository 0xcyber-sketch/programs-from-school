package com.lange.integration.userservice.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CredentialsDTO {
    private final String credential;
    private final String password;
    private final boolean isEmail;

    public CredentialsDTO(String credential, String password, boolean isEmail) {
        this.credential = credential;
        this.password = password;
        this.isEmail = isEmail;
    }

    public String getCredential() {
        return credential;
    }

    public String getPassword() {
        return password;
    }

    @JsonProperty("isEmail")
    public boolean isEmail() {
        return isEmail;
    }
}
