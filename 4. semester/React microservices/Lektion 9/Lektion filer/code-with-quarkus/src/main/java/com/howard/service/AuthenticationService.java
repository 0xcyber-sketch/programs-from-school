package com.howard.service;

import com.howard.domain.Email;
import com.howard.domain.Role;
import com.howard.domain.Roles;
import com.howard.domain.User;
import com.howard.domain.exception.NoUserException;
import com.howard.domain.exception.Sid;
import com.howard.domain.security.JWTToken;
import com.howard.repository.Repository;
import com.howard.service.request.LoginRequest;
import com.howard.service.request.SignupRequest;
import com.howard.service.response.LoginResponse;
import com.howard.service.response.SignUpResponse;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Transactional(rollbackOn = Exception.class)
@Dependent
public class AuthenticationService {

    private final JWTService jwtService;
    private final Repository repository;

    @Inject
    public AuthenticationService(JWTService jwtService, Repository repository) {
        this.jwtService = jwtService;
        this.repository = repository;
    }

    public SignUpResponse signUp(SignupRequest request) {
        Email email = repository.createUser(request.getEmail(), request.getUserName(), request.getPassword(), new Roles(Role.USER));
        return new SignUpResponse(email);
    }

    public LoginResponse login(LoginRequest request) {
        User user = repository.findUser(request.getEmail(), request.getUserName(), request.getPassword());

        if (user == null) {
            throw new NoUserException(Sid.NO_SUCH_USER, String.format("User userName:%s email: %s  does not exist", request.getUserName() != null ? request.getUserName().getValue() : "", request.getEmail() != null ? request.getEmail().getValue() : ""));
        }

        JWTToken token = jwtService.createJWT(user);
        return new LoginResponse(token);
    }


}
