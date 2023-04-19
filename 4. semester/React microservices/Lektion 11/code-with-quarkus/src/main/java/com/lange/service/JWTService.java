package com.lange.service;

import com.lange.domain.User;
import com.lange.domain.security.JWTToken;
import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.jwt.Claims;

import javax.enterprise.context.Dependent;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
@Dependent
public class JWTService {

    public JWTToken createJWT(User user) {
        String token =
                Jwt.issuer("http://com.lange/")
                        .preferredUserName(user.getUserName().getValue())
                        .subject(user.getId().getUserID().toString())
                        .claim(Claims.email.name(), user.getEmail().getValue())
                        .expiresIn(60 * 60)
                        .issuedAt(LocalDateTime.now().toInstant(ZoneOffset.UTC))
                        .sign();
        return new JWTToken(token, user.getUserName().getValue());
    }

}
