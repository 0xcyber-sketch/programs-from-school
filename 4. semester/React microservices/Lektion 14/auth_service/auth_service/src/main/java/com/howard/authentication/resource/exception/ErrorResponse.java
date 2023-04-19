package com.howard.authentication.resource.exception;

import com.howard.authentication.domain.exception.Sid;

import javax.ws.rs.core.Response;
import java.util.UUID;

public class ErrorResponse {
    private final Sid sid;
    private final String traceId;
    private final String message;
    private final Response.Status status;

    public ErrorResponse(Sid sid, String message, Response.Status status) {
        this.sid = sid;
        this.traceId = UUID.randomUUID().toString();
        this.message = message;
        this.status = status;
    }

    Response toResponse() {
        return Response.status(status).entity(this).build();
    }

    public Sid getSid() {
        return sid;
    }

    public String getTraceId() {
        return traceId;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status.getStatusCode();
    }
}
