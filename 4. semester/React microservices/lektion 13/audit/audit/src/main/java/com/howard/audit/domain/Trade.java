package com.howard.audit.domain;

import java.util.UUID;

public class Trade {
    private final UUID id;
    private final TradeData data;

    public Trade(UUID id, TradeData data) {
        this.id = id;
        this.data = data;
    }

    public UUID getId() {
        return id;
    }

    public TradeData getData() {
        return data;
    }
}
