package com.howard.authentication.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.howard.authentication.domain.Email;
import com.howard.authentication.domain.Password;
import com.howard.authentication.domain.UserName;
import com.howard.authentication.domain.exception.BadRequestException;
import com.howard.authentication.domain.exception.DomainException;
import com.howard.authentication.service.request.VerifyCredentialsRequest;

public class LoginDTO {
    private final String credential;
    private final String password;
    private final boolean isEmail;

    @JsonCreator
    public LoginDTO(@JsonProperty("credential") String credential, @JsonProperty("password") String password, @JsonProperty("isEmail") boolean isEmail) {
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

    public boolean isEmail() {
        return isEmail;
    }

    @JsonIgnore
    public VerifyCredentialsRequest toRequest() {
        try {
            return new VerifyCredentialsRequest(isEmail ? new Email(credential) : new UserName(credential), new Password(password));
        } catch (DomainException e) {
            throw new BadRequestException(e.getSid(), e.getMessage(), e);
        }
    }
}
