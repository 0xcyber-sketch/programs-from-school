package com.howard.resource.exception;

import com.howard.domain.exception.Sid;
import io.quarkus.security.UnauthorizedException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.UUID;

@Provider
public class UnAuthorizedExceptionMapper implements ExceptionMapper<UnauthorizedException> {

    @Override
    public Response toResponse(UnauthorizedException e) {
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity(new ErrorResponse(Sid.UNAUTHORIZED, UUID.randomUUID().toString(), e.getMessage(), Response.Status.UNAUTHORIZED))
                .build();
    }
}
