package com.howard.service;

import com.howard.domain.User;
import com.howard.domain.security.JWTToken;
import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.jwt.Claims;

import javax.enterprise.context.Dependent;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.HashSet;

@Dependent
public class JWTService {

    public JWTToken createJWT(User user) {
        String token =
                Jwt.issuer("http://com.howard/")
                        .claim(Claims.gender, user.getGender().name())
                        .preferredUserName(user.getUserName().getValue())
                        .subject(user.getId().getRaw())
                        .groups(new HashSet<>(user.getRoles().getRolesAsList()))
                        .claim(Claims.email.name(), user.getEmail().getValue())
                        .expiresIn(60 * 60)
                        .issuedAt(LocalDateTime.now().toInstant(ZoneOffset.UTC))
                        .sign();
        return new JWTToken(token, user.getUserName().getValue(), user.getGender().name());
    }
}
