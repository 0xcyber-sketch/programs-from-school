package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatePerson {

    public String name;
    public int age;

    @JsonCreator
    public CreatePerson(
        @JsonProperty("Name") String name,
        @JsonProperty("Age") int age) {
        this.name = name;
        this.age = age;


    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
