package com.howard.service.polymorph;

import io.quarkus.arc.AlternativePriority;

import javax.enterprise.context.Dependent;
import java.util.Arrays;
import java.util.List;

@Dependent
@AlternativePriority(1)
public class PolyMorph1 implements PolyMorphService {
    @Override
    public List<String> getValues() {
        return Arrays.asList("poly priority 1");
    }
}
