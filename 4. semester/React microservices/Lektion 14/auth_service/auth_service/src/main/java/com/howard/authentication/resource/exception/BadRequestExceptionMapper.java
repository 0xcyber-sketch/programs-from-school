package com.howard.authentication.resource.exception;

import com.howard.authentication.domain.exception.BadRequestException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {
    @Override
    public Response toResponse(BadRequestException e) {
        return new ErrorResponse(e.getSid(), e.getMessage(), Response.Status.BAD_REQUEST).toResponse();
    }
}
