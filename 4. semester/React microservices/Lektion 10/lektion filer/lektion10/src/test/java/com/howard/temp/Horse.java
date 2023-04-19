package com.howard.temp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Horse {
    private String name;
    private int age;
    private Pedigree pedigree;

    @JsonCreator
    public Horse(@JsonProperty("name") String name, @JsonProperty("age") int age, @JsonProperty("pedigree") Pedigree pedigree) {
        this.name = name;
        this.age = age;
        this.pedigree = pedigree;
    }

    @JsonProperty("whatEver")
    public String getMyName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Pedigree getPedigree() {
        return pedigree;
    }
}
