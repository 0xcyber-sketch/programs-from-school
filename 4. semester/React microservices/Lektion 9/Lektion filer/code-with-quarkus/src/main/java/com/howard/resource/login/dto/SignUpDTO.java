package com.howard.resource.login.dto;

import com.howard.domain.Email;
import com.howard.domain.Password;
import com.howard.domain.UserName;
import com.howard.service.request.SignupRequest;

public class SignUpDTO {
    private final String email;
    private final String userName;
    private final String password;

    public SignUpDTO(String email, String userName, String password) {
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public SignupRequest toSignupRequest() {
        return new SignupRequest(new Email(email), new UserName(userName), new Password(password));
    }
}
