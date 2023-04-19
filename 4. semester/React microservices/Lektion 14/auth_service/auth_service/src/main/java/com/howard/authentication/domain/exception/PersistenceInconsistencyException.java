package com.howard.authentication.domain.exception;

public class PersistenceInconsistencyException extends RuntimeException {
    private final Sid sid;

    public PersistenceInconsistencyException(Sid sid, String message) {
        super(message);
        this.sid = sid;
    }

    public PersistenceInconsistencyException(Sid sid, String message, Throwable cause) {
        super(message, cause);
        this.sid = sid;
    }

    public Sid getSid() {
        return sid;
    }
}
