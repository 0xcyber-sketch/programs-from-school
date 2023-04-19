package com.howard.resource.exception;

import com.howard.domain.exception.NoUserException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.UUID;

@Provider
public class NoUserExceptionMapper implements ExceptionMapper<NoUserException> {

    @Override
    public Response toResponse(NoUserException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorResponse(e.getSid(), UUID.randomUUID().toString(), e.getMessage(), Response.Status.BAD_REQUEST))
                .build();
    }
}
