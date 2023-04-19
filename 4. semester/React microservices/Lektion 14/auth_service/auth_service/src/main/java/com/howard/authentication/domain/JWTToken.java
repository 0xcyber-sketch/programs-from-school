package com.howard.authentication.domain;

import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.jwt.Claims;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class JWTToken {
    private final String token;

    public JWTToken(SecurityInfo securityInfo) {
        this(securityInfo, 60 * 60);
    }

    public JWTToken(SecurityInfo securityInfo, int age) {
        this.token =
                Jwt.issuer("http://com.howard/")
                        .subject(securityInfo.getUserId().getRaw())
                        .preferredUserName(securityInfo.getUserName().getValue())
                        .groups(securityInfo.getRoles().getRolesAsStringSet())
                        .expiresIn(60 * 60)
                        .issuedAt(LocalDateTime.now().toInstant(ZoneOffset.UTC))
                        .sign();

    }

    public String getToken() {
        return token;
    }

}
