package com.howard.resource.exception;

import com.howard.domain.exception.Sid;

import javax.ws.rs.core.Response;

public class ErrorResponse {

    private final Sid sid;
    private final String traceId;
    private final String message;
    private final int status;

    public ErrorResponse(Sid sid, String traceId, String message, Response.Status status) {
        this.sid = sid;
        this.traceId = traceId;
        this.message = message;
        this.status = status.getStatusCode();
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
        return status;
    }
}
