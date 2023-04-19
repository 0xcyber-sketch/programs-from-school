package com.lange.integration.userservice.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;

public class UserIdDTO {
    private final String id;
    private final String userName;

    @JsonCreator
    public UserIdDTO(@JsonProperty("id") String id, @JsonProperty("userName") String userName) {
        this.id = id;
        this.userName = userName;
    }
    public String getId() {
        return id;
    }


}