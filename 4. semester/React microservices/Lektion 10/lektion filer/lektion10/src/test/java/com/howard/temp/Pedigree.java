package com.howard.temp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Pedigree {
    private List<Horse> horses;

    @JsonCreator
    public Pedigree(@JsonProperty("horses") List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }
}
