package com.howard.service.polymorph;

import io.quarkus.arc.AlternativePriority;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

@Dependent
//@Named("PolyExtra")
@AlternativePriority(4)

public class PolyMorph4 implements PolyMorphService {
    @Override
    public List<String> getValues() {
        return Arrays.asList("poly priority 4");
    }
}
