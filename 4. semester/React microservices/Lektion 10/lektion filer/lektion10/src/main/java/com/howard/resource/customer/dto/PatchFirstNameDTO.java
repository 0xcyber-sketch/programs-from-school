package com.howard.resource.customer.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PatchFirstNameDTO {

    private String name;


    @JsonCreator
    public PatchFirstNameDTO(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
