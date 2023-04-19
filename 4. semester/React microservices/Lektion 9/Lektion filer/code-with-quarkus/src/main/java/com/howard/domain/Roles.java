package com.howard.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Roles {
    private static final String SEPARATOR = ",";

    private final List<Role> roles;

    public Roles(String rolesAsString) {
        String[] roles = rolesAsString.split(SEPARATOR);
        this.roles = Arrays.stream(roles).map(Role::valueOf).collect(Collectors.toList());
    }
    public Roles(Role... roles) {
        this.roles= Arrays.asList(roles);
    }

    public List<Role> getRoles() {
        return roles;
    }

    public String getRolesAsString() {
        return roles.stream().map(Enum::name).collect(Collectors.joining(SEPARATOR));
    }

    public List<String> getRolesAsList() {
        return roles.stream().map(Enum::name).collect(Collectors.toList());
    }

}
