package com.howard.authentication.domain.exception;

public class ProgrammingException extends RuntimeException {
    private final Sid sid;

    public ProgrammingException(Sid sid, String message) {
        super(message);
        this.sid = sid;
    }

    public ProgrammingException(Sid sid, String message, Throwable cause) {
        super(message, cause);
        this.sid = sid;
    }

    public Sid getSid() {
        return sid;
    }
}
