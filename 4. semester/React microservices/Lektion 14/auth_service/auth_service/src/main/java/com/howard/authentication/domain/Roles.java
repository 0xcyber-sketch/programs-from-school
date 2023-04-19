package com.howard.authentication.domain;

import com.howard.authentication.domain.exception.DomainException;
import com.howard.authentication.domain.exception.Sid;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Roles {
    private final String SEPARATOR = ",";
    private final List<Role> roles;
    public static final Roles DEFAULT_ROLES = new Roles(Role.USER);
    public static final Roles API_ROLES = new Roles(Role.SUPER_USER);

    public Roles(String rolesAsString) throws DomainException {
        try {
            String[] roles = rolesAsString.split(SEPARATOR);
            this.roles = Arrays.stream(roles).map(Role::valueOf).collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new DomainException(Sid.ROLE_VALIDATION_ERROR, e.getMessage(), e);
        }
    }

    public Roles(Role... roles) {
        this.roles = Arrays.asList(roles);
    }

    public Roles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public String getRolesAsString() {
        return roles.stream().map(r -> r.name()).collect(Collectors.joining(","));
    }

    public Set<String> getRolesAsStringSet() {
        return roles.stream().map(r -> r.name()).collect(Collectors.toSet());
    }

}
