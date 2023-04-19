package com.howard.authentication.resource.dto;

import com.howard.authentication.domain.Email;
import com.howard.authentication.domain.Password;
import com.howard.authentication.domain.UserName;
import com.howard.authentication.domain.exception.BadRequestException;
import com.howard.authentication.domain.exception.DomainException;
import com.howard.authentication.service.request.CreateCredentialsRequest;

public class SignUpDTO {
    private final String email;
    private final String userName;
    private final String password;

    public SignUpDTO(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public CreateCredentialsRequest getRequest() {
        try {
            return new CreateCredentialsRequest(new Email(email), new UserName(userName), new Password(password));
        } catch (DomainException e) {
            throw new BadRequestException(e.getSid(), e.getMessage(), e);
        }
    }

}

