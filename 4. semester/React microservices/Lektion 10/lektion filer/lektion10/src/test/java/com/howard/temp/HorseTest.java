package com.howard.temp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HorseTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    public void before() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void serializeHorse() throws JsonProcessingException {
        Horse father = new Horse("lola", 23, null);
        Horse mother = new Horse("hans", 23, null);
        Pedigree pedigree = new Pedigree(Arrays.asList(father, mother));
        Horse child = new Horse("stark", 45, pedigree);
        System.out.println(objectMapper.writeValueAsString(child));
    }

    @Test
    public void deSerializeHorse() throws JsonProcessingException {
        String json = "{\"name\":\"stark\",\"age\":45,\"pedigree\":{\"horses\":[{\"name\":\"lola\",\"age\":23,\"pedigree\":null},{\"name\":\"hans\",\"age\":23,\"pedigree\":null}]}}";
        Horse h = objectMapper.readValue(json, Horse.class);
        System.out.println(h.getAge());
        System.out.println(h.getMyName());
        System.out.println(h.getPedigree().getHorses());

    }


}
