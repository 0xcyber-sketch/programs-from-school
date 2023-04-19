package com.howard.service.request;

import com.howard.domain.Id;

public class GetUserRequest {
    private final Id id;

    public GetUserRequest(String id) {
        this.id = new Id(id);
    }

    public Id getId() {
        return id;
    }
}
