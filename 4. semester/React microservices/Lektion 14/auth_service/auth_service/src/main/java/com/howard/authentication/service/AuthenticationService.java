package com.howard.authentication.service;

import com.howard.authentication.domain.JWTToken;
import com.howard.authentication.domain.SecurityInfo;
import com.howard.authentication.integration.userservice.UserService;
import com.howard.authentication.service.request.VerifyCredentialsRequest;
import com.howard.authentication.service.response.VerifyCredentialsResponse;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class AuthenticationService {

    private final UserService userService;

    @Inject
    public AuthenticationService(UserService userService) {

        this.userService = userService;
    }

    public VerifyCredentialsResponse login(VerifyCredentialsRequest request) {
        SecurityInfo securityInfo = userService.validateCredentials(
                request.getCredential(),
                request.getPassword());
        return new VerifyCredentialsResponse(securityInfo.getUserId(), new JWTToken(securityInfo));
    }

}
