package com.howard.domain;

import java.util.UUID;

public class Id {
    private final UUID uuid;

    public Id(UUID uuid) {
        this.uuid = uuid;
    }

    public Id(String uuid) {
        this.uuid = UUID.fromString(uuid);
    }

    public String getRaw() {
        return uuid.toString();
    }


    public UUID getUuid() {
        return uuid;
    }

}
