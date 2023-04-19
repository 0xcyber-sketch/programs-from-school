package com.howard.authentication.service.request;

import com.howard.authentication.domain.Credential;
import com.howard.authentication.domain.Email;
import com.howard.authentication.domain.Password;
import com.howard.authentication.domain.UserName;
import com.howard.authentication.domain.exception.BadRequestException;
import com.howard.authentication.domain.exception.DomainException;

public class VerifyCredentialsRequest {
    private final Credential credential;
    private final Password password;

    public VerifyCredentialsRequest(Credential credential, Password password) {
        this.password = password;
        this.credential = credential;
    }

    public Credential getCredential() {
        return credential;
    }

    public Password getPassword() {
        return password;
    }
}
