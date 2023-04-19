package com.howard.domain.exception;

public class NoUserException extends RuntimeException {
    private final Sid sid;

    public NoUserException(Sid sid, String message) {
        super(message);
        this.sid = sid;
    }

    public NoUserException(Sid sid, String message, Throwable cause) {
        super(message, cause);
        this.sid = sid;
    }

    public Sid getSid() {
        return sid;
    }
}
