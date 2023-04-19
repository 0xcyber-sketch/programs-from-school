package com.howard.authentication.resource.dto;

public class LoggedInDTO {
    private final String id;


    public LoggedInDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
