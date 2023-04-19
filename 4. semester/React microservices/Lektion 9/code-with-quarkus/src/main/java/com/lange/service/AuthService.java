package com.lange.service;

import com.lange.domain.User;
import com.lange.domain.security.JWTToken;
import com.lange.persistance.Repository;
import com.lange.service.requests.LoginRequest;
import com.lange.service.requests.SignupRequest;
import com.lange.service.responses.LoginResponse;
import com.lange.service.responses.SignupResponse;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class AuthService {

    private final Repository repository;
    private final JWTService jwtService;

    @Inject
    public AuthService(Repository rep, JWTService jwtService) {
        repository = rep;
        this.jwtService = jwtService;
    }

    public SignupResponse signup(SignupRequest request) {
        if (this.repository.UserExsit(request.getUserName(), request.getEmail())) {
            throw new IllegalArgumentException("fejl");

        }
        User u = repository.createUser(request.getUserName(), request.getEmail(), request.getPassword());



        return new SignupResponse(u);
    }

    public LoginResponse login(LoginRequest request) {
        User u = this.repository.findUser(request.getEmail(), request.getUserName(), request.getPassword());
        if (u == null) {
            // Should be a better execption
            throw new IllegalArgumentException("Fejl");
        }
        JWTToken token = jwtService.createJWT(u);
        return new LoginResponse(token);
    }
}
