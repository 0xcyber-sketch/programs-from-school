package com.howard.service.polymorph;

import io.quarkus.arc.AlternativePriority;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;
import java.util.Arrays;
import java.util.List;


@Dependent
@AlternativePriority(3)

public class PolyMorph3 implements PolyMorphService {
    @Override
    public List<String> getValues() {
        return Arrays.asList("poly priority 3");
    }
}
