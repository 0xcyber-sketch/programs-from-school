package com.lange.service;

import com.lange.domain.User;
import com.lange.domain.security.JWTToken;
import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.jwt.Claims;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class JWTService {

    public JWTToken createJWT(User user) {
        String token =
                Jwt.issuer("http://com.lange/")
                        .preferredUserName(user.getUserName().getValue())
                        .subject("" + user.getId())
                        .claim(Claims.email.name(), user.getEmail())
                        .expiresIn(60 * 60)
                        .issuedAt(LocalDateTime.now().toInstant(ZoneOffset.UTC))
                        .sign();
        return new JWTToken(token, user.getUserName().getValue());
    }

}
