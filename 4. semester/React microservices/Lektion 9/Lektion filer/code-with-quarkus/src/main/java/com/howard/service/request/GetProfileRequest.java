package com.howard.service.request;

import com.howard.domain.Id;

public class GetProfileRequest {
    private final Id userId;

    public GetProfileRequest(String userId) {
        this.userId = new Id(userId);
    }
}
