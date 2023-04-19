package com.howard.authentication.domain;

import com.howard.authentication.domain.exception.DomainException;
import com.howard.authentication.domain.exception.Sid;

import java.util.UUID;

public class Id {
    private final UUID uuid;

    public Id(UUID uuid) {
        this.uuid = uuid;
    }

    public Id(String uuid) throws DomainException {
        try {
            this.uuid = UUID.fromString(uuid);
        } catch (IllegalArgumentException e) {
            throw new DomainException(Sid.ID_VALIDATION_ERROR, e.getMessage(), e);
        }
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getRaw() {
        return uuid.toString();
    }
}
