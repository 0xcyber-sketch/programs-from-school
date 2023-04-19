package com.howard.authentication.service.request;

import com.howard.authentication.domain.Id;
import com.howard.authentication.domain.exception.BadRequestException;
import com.howard.authentication.domain.exception.DomainException;

public class GetCredentialsRequest {
    private final Id id;

    public GetCredentialsRequest(Id id) {
        this.id = id;
    }

    public GetCredentialsRequest(String id) {
        try {
            this.id = new Id(id);
        } catch (DomainException e) {
            throw new BadRequestException(e.getSid(), e.getMessage(), e);
        }
    }

    public Id getId() {
        return id;
    }
}
